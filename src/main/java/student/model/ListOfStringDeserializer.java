package student.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class ListOfStringDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String stringList = jp.getText();
        return Arrays.stream(stringList.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
