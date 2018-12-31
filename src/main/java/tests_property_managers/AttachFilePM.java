package tests_property_managers;

public class AttachFilePM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\attachFile.properties";
    private String pathToFile;
    private String fileAddedAssert;

    public AttachFilePM() {
        super(propertyFilePath);
        pathToFile = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("pathToFile");
        fileAddedAssert = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("fileAddedAssert");
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getFileAddedAssert() {
        return fileAddedAssert;
    }
}