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
        final Kmr.KmrBuilder kmrBuilder = Kmr.builder()
                .isBusiness(node.get("isBusiness").asBoolean())
                .origin(node.get("origin").asText())
                .destination(node.get("destination").asText())
                .startTotal(node.get("startTotal").asInt())
                .endTotal(node.get("endTotal").asInt());
        try {
            kmrBuilder.day(JAVASCRIPT_DATE_FORMAT.parse(node.get("day").asText()));
        } catch (ParseException e) {
            kmrBuilder.day(new Date());
        }
        return kmrBuilder.build();
    }
}
