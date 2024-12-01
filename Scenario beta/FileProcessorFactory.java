public class FileProcessorFactory {
    public static FileProcessor getProcessor(String fileType) {
        switch (fileType.toLowerCase()) {
            case "csv":
                return new CSVProcessor();
            case "json":
                return new JSONProcessor();
            case "xml":
                return new XMLProcessor();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }
    }
}