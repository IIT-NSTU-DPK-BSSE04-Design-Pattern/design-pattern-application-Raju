import com.fasterxml.jackson.databind.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.io.*;

public class DataProcessingPipeline {
    public static void main(String[] args) 
    {
        if (args.length < 2) 
        {
            System.out.println("DATA Processing");
            return;
        }
        String fileType = args[0];
        String filePath = args[1];
        
        try {
            File_Processor processor = File_Processor_Factory.getProcessor(fileType);
            processor.process(filePath);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
