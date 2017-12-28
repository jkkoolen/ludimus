package eu.ludimus.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import eu.ludimus.converter.ConvertException;
import eu.ludimus.converter.ConverterFactoy;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static eu.ludimus.converter.ConverterFactoy.ConverterType.IMAGE;
import static eu.ludimus.converter.ConverterFactoy.ConverterType.PDF;

public class TicketDeserializer extends JsonDeserializer<Ticket> {
    private SimpleDateFormat JAVASCRIPT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    @Override
    public Ticket deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final Ticket.TicketBuilder ticketBuilder = Ticket.builder()
                .forMonth(node.get("forMonth").asInt())
                .income(node.get("income").asBoolean())
                .carcost(node.get("carcost").asBoolean())
                .price(BigDecimal.valueOf(node.get("price").asDouble()))
                .invoiceNumber(node.get("invoiceNumber").asText())
                .description(node.get("description").asText())
                .vatRate(BigDecimal.valueOf(node.get("vatRate").asDouble()));

        final JsonNode userNode = node.get("user");
        if(userNode != null && userNode.get("id") != null) {
            final User user = User.builder().build();
            final long id = userNode.get("id").asLong();
            user.setId(id);
            ticketBuilder.user(user);
        }

        final JsonNode depreciationYears = node.get("depreciationYears");
        final JsonNode yearOfEntry = node.get("yearOfEntry");
        if(depreciationYears != null && yearOfEntry != null) {
            ticketBuilder.depreciationYears(depreciationYears.asInt())
                .yearOfEntry(yearOfEntry.asInt());
        }
        final JsonNode ticketFilenameNode = node.get("ticketFilename");
        String ticketFilename = null;
        if(ticketFilenameNode != null) {
            ticketFilename = ticketFilenameNode.asText();
        }
        final JsonNode ticketImageNode = node.get("ticketImage");
        if (ticketImageNode != null) {
            final String attachment = ticketImageNode.asText();
            byte[] data;
            String base64String;
            if(attachment.indexOf(',') > -1) {
                base64String = attachment.split(",")[1];
            } else {
                base64String = attachment;
            }
            data =  Base64.getDecoder().decode(base64String.getBytes("UTF-8"));
            try {
                final byte[] ticketImage = ticketFilename == null ?
                        data
                        : ConverterFactoy.createConverter(ticketFilename.toUpperCase().endsWith(".PDF") ? PDF : IMAGE).toJpg(new ByteArrayInputStream(data));

//                final FileOutputStream s = new FileOutputStream("default.jpg");
//                s.write(ticketImage);
//                s.flush();s.close();
                ticketBuilder.ticketImage(ticketImage);
            } catch (ConvertException e) {
                throw new IOException(e.getCause());
            }
        }
        try {
            if(ticketFilenameNode == null) {
                ticketBuilder.ticketDate(new Date(node.get("ticketDate").asLong()));
            } else {
                ticketBuilder.ticketDate(JAVASCRIPT_DATE_FORMAT.parse(node.get("ticketDate").asText()));
            }
        } catch (ParseException e) {
            ticketBuilder.ticketDate(new Date());
        }
        final Ticket ticket = ticketBuilder.build();
        final JsonNode id = node.get("id");
        if(id != null) {
            ticket.setId(id.asLong());
        }

        return ticket;
    }
}
