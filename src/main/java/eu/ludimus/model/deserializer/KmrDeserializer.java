package eu.ludimus.model.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import eu.ludimus.model.Kmr;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KmrDeserializer extends JsonDeserializer<Kmr> {
    private SimpleDateFormat JAVASCRIPT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private int count;

    @Override
    public Kmr deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        final Kmr kmr = new Kmr()
                .setBusiness(node.get("isBusiness").asBoolean())
                .setOrigin(node.get("origin").asText())
                .setDestination(node.get("destination").asText())
                .setStartTotal(node.get("startTotal").asInt())
                .setEndTotal(node.get("endTotal").asInt());
        try {
            kmr.setDay(JAVASCRIPT_DATE_FORMAT.parse(node.get("day").asText()));
        } catch (ParseException e) {
            kmr.setDay(new Date());
        }
        return kmr;
    }
}
