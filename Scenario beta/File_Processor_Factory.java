public class File_Processor_Factory {
    public static File_Processor getProcessor(String Type) {
        switch (Type.toLowerCase()) {
            case "csv":
                return new CSV_Processor();
            case "json":
                return new JSON_Processor();
            case "xml":
                return new XML_Processor();
            default:
                throw new IllegalArgumentException("file type: " + Type);
        }
    }
}