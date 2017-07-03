package eu.ludimus.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import eu.ludimus.converter.ConvertException;
import eu.ludimus.converter.ConverterFactoy;
import eu.ludimus.model.Ticket;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static eu.ludimus.converter.ConverterFactoy.ConverterType.IMAGE;
import static eu.ludimus.converter.ConverterFactoy.ConverterType.PDF;

public class TicketDeserializer extends JsonDeserializer<Ticket> {
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private int count;

    @Override
    public Ticket deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final Ticket ticket = new Ticket();
        ticket.setForMonth(node.get("forMonth").asInt());
        ticket.setIncome(node.get("income").asBoolean());
        ticket.setPrice(BigDecimal.valueOf(node.get("price").asDouble()));
        ticket.setInvoiceNumber(node.get("invoiceNumber").asText());
        ticket.setDescription(node.get("description").asText());
        ticket.setVatRate(BigDecimal.valueOf(node.get("vatRate").asDouble()));
        final String ticketFilename = node.get("ticketFilename").asText();
        final String attachment = node.get("ticketImage").asText();
        if (attachment != null && attachment.indexOf(',') > -1) {
            String base64String = attachment.split(",")[1];
            byte[] data = Base64.getDecoder().decode(base64String.getBytes("UTF-8"));
            try {
                final byte[] ticketImage = ConverterFactoy.createConverter(ticketFilename.toUpperCase().endsWith(".PDF") ? PDF : IMAGE).toJpg(new ByteArrayInputStream(data));
                final FileOutputStream s1 = new FileOutputStream(ticketFilename);
                s1.write(data);
                s1.flush();s1.close();
                final FileOutputStream s = new FileOutputStream(ticketFilename + ".jpg");
                s.write(ticketImage);
                s.flush();s.close();
                ticket.setTicketImage(ticketImage);
            } catch (ConvertException e) {
                throw new IOException(e.getCause());
            }
        }
        try {
            ticket.setTicketDate(DATE_FORMAT.parse(node.get("ticketDate").asText()));
        } catch (ParseException e) {
            ticket.setTicketDate(new Date());
        }
        return ticket;
    }
}
