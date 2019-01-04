package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class AttachFilePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/attachFile";
    private String attachFilePath;
    private String attachFileAssert;

    public AttachFilePM() {
        super(propertyFilePath);
        attachFilePath = getProperties().getProperty("attachFilePath");
        attachFileAssert = getProperties().getProperty("attachFileAssert");
    }

    public String getAttachFilePath() {
        setCanonicalFilePath();
        return attachFilePath;
    }

    public String getAttachFileAssert() {
        return attachFileAssert;
    }

    public void setCanonicalFilePath() {
        try {
            this.attachFilePath = new File(attachFilePath).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}