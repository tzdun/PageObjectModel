package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class SendEmailWithAttachmentPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/sendEmailWithAttachment";
    private String messageTo;
    private String messageSubject;
    private String messageText;
    private String relativeAttachmentPath;
    private String canonicalAttachmentPath;
    private String attachFileAssert;
    private String sendEmailWithAttachmentAssert;

    public SendEmailWithAttachmentPropertyManager() {
        super(propertyFilePath);
        messageTo = getProperties().getProperty("messageTo");
        messageSubject = getProperties().getProperty("messageSubject");
        messageText = getProperties().getProperty("messageText");
        relativeAttachmentPath = getProperties().getProperty("relativeAttachmentPath");
        attachFileAssert = getProperties().getProperty("attachFileAssert");
        sendEmailWithAttachmentAssert = getProperties().getProperty("sendEmailWithAttachmentAssert");
    }

    public static String getPropertyFilePath() {
        return propertyFilePath;
    }

    public String getAttachFileAssert() {
        return attachFileAssert;
    }

    public void setCanonicalAttachmentPath(String relativePathToImage) throws IOException {
        String canonicalPathToImage = new File(relativePathToImage).getCanonicalPath();
        this.canonicalAttachmentPath = canonicalPathToImage;
    }

    public String getCanonicalAttachmentPath() {
        try {
            setCanonicalAttachmentPath(this.relativeAttachmentPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return canonicalAttachmentPath;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getSendEmailWithAttachmentAssert() {
        return sendEmailWithAttachmentAssert;
    }
}