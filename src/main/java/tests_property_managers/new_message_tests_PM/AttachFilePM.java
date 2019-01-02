package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class AttachFilePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/attachFile.properties";
    private String pathToFile;
    private String attachFileAssert;

    public AttachFilePM() {
        super(propertyFilePath);
        pathToFile = getProperties().getProperty("pathToFile");
        attachFileAssert = getProperties().getProperty("attachFileAssert");
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getAttachFileAssert() {
        return attachFileAssert;
    }
}