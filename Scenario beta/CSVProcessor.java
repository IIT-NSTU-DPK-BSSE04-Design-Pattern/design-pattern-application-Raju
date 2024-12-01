import java.io.*;
import java.util.*;

public class CSV_Processor implements File_Processor {
    @Override
    public void process(String filePath) throws Exception 
    {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) 
        {
            String[] values = line.split(",");
            System.out.println(Arrays.toString(values)); 
        }
    }
}