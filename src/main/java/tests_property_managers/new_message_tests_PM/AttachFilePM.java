package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class AttachFilePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/attachFile.properties";
    private String pathToFile;
    private String fileAddedAssert;

    public AttachFilePM() {
        super(propertyFilePath);
        pathToFile = getProperties().getProperty("pathToFile");
        fileAddedAssert = getProperties().getProperty("fileAddedAssert");
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getFileAddedAssert() {
        return fileAddedAssert;
    }
}