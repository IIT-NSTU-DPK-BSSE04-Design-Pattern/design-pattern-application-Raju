interface File_Processor 
{
    void process(String filePath) throws Exception;
}
public class XML_Processor implements File_Processor {
    @Override
    public void process(String filePath) throws Exception 
    {
        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Tag_dite_hbe"); 
        for (int temp = 0; temp < nList.getLength(); temp++) 
        {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) 
            {
                Element element = (Element) nNode;
                System.out.println("Data: " + element.getTextContent()); 
            }
        }
    }
}