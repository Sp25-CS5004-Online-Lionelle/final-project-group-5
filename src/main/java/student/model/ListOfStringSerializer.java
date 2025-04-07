package student.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListOfStringSerializer extends JsonSerializer<ArrayList<String>> {

    @Override
    public void serialize(ArrayList<String> list, JsonGenerator jsonGenerator, SerializerProvider serializer)throws IOException {
        jsonGenerator.writeString(String.join(", ", list));
    }
}
