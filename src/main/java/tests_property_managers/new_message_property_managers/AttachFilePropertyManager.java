package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class AttachFilePropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/attachFile";
    private String attachFilePath;
    private String attachFileAssert;

    public AttachFilePropertyManager() {
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