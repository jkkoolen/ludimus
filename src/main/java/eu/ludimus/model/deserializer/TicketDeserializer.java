package eu.ludimus.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.drive.model.File;
import eu.ludimus.converter.ConvertException;
import eu.ludimus.converter.ConverterFactoy;
import eu.ludimus.googledrive.GoogleDriveUtil;
import eu.ludimus.model.Ticket;
import eu.ludimus.model.User;
import eu.ludimus.security.UserRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static eu.ludimus.converter.ConverterFactoy.ConverterType.IMAGE;
import static eu.ludimus.converter.ConverterFactoy.ConverterType.PDF;

@Component
public class TicketDeserializer extends JsonDeserializer<Ticket> {
    private SimpleDateFormat JAVASCRIPT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    @Autowired
    private UserRequestUtil userRequestUtil;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Ticket deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final Ticket.TicketBuilder ticketBuilder;
        try {
            ticketBuilder = Ticket.builder()
                    .forMonth(node.get("forMonth").asInt())
                    .income(node.get("income").asBoolean())
                    .carcost(node.get("carcost").asBoolean())
                    .price(BigDecimal.valueOf(node.get("price").asDouble()))
                    .invoiceNumber(node.get("invoiceNumber").asText())
                    .description(node.get("description").asText())
                    .vatRate(BigDecimal.valueOf(node.get("vatRate").asDouble()))
                    .user(getUser(node))
                    .depreciationYears(node.get("depreciationYears") != null ? node.get("depreciationYears").asInt() : null)
                    .yearOfEntry(node.get("yearOfEntry") != null ? node.get("yearOfEntry").asInt() : null)
                    .ticketImage(getTicketImage(node))
                    .ticketDate(getTicketDate(node));
        } catch (ConvertException e) {
            throw new IOException(e);
        }

        final Ticket ticket = ticketBuilder.build();
        final JsonNode id = node.get("id");
        if(id != null) {
            ticket.setId(id.asLong());
        }

        return ticket;
    }

    private Date getTicketDate(final JsonNode node) {
        JsonNode ticketDateNode = node.get("ticketDate");
        if(ticketDateNode == null) {
            return new Date();
        }
        String ticketDate = ticketDateNode.asText();
        try {
            long aLong = Long.parseLong(ticketDate);
            return new Date(aLong);
        } catch(NumberFormatException nfe) {
            try {
                return JAVASCRIPT_DATE_FORMAT.parse(ticketDate);
            } catch (ParseException e) {
                return new Date();
            }
        }
    }

    private byte[] getTicketImage(final JsonNode node) throws IOException, ConvertException {
        if(fromGoogleDrive(node)) {
            File  googleFile = objectMapper.readValue(node.get("googleFile").toString(), File.class);
            if(googleFile != null) {
                String name = userRequestUtil.getUser().getEmail();
                byte[] data = GoogleDriveUtil.getFileFromDriveFor(googleFile.getId(), name).toByteArray();
                return ConverterFactoy.createConverter(googleFile.getName().toUpperCase().endsWith(".PDF") ? PDF : IMAGE).toJpg(new ByteArrayInputStream(data));
            }
        }
        final String uploadFileName = getFileName(node);
        final JsonNode ticketImageNode = node.get("ticketImage");
        if (ticketImageNode != null) {
            final String attachment = ticketImageNode.asText();
            byte[] data;
            String base64String;
            if (attachment.indexOf(',') > -1) {
                base64String = attachment.split(",")[1];
            } else {
                base64String = attachment;
            }
            data = Base64.getDecoder().decode(base64String.getBytes("UTF-8"));
            return uploadFileName == null ? data
                        : ConverterFactoy.createConverter(uploadFileName.toUpperCase().endsWith(".PDF") ? PDF : IMAGE).toJpg(new ByteArrayInputStream(data));
        }
        throw new IOException("Error: TicketImage could not be processed ");
    }

    private String getFileName(final JsonNode node) {
        final JsonNode ticketFilenameNode = node.get("ticketFilename");
        if(ticketFilenameNode != null) {
            return ticketFilenameNode.asText();
        }
        return null;
    }

    private boolean fromGoogleDrive(final JsonNode node) {
        JsonNode useGoogleDriveNode = node.get("useGoogleDrive");
        return useGoogleDriveNode != null && useGoogleDriveNode.asBoolean();
    }

    private User getUser(final JsonNode node) {
        final JsonNode userNode = node.get("user");
        if(userNode != null && userNode.get("id") != null) {
            final User user = User.builder().build();
            final long id = userNode.get("id").asLong();
            user.setId(id);
        }
        return null;
    }
}
