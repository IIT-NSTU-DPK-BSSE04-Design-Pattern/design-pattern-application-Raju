import com.fasterxml.jackson.databind.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.io.*;

public class JSONProcessor implements FileProcessor {
    @Override
    public void process(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(new File(filePath), Map.class);
        System.out.println(jsonMap); // Displaying parsed JSON object
    }
}