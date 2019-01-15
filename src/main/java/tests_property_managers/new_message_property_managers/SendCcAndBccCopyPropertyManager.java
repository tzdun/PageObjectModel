package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class SendCcAndBccCopyPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getNewMessagePropertyFilePath() + "sendCcAndBccCopy";
    private String messageTo;
    private String ccMessageTo;
    private String bccMessageTo;
    private String messageSubject;
    private String messageText;
    private String relativeAttachmentPath;
    private String canonicalAttachmentPath;
    private String attachFileAssert;
    private String sendCcAndBccCopyAssert;

    public SendCcAndBccCopyPropertyManager() {
        super(propertyFilePath);
        messageTo = getProperties().getProperty("messageTo");
        ccMessageTo = getProperties().getProperty("ccMessageTo");
        bccMessageTo = getProperties().getProperty("bccMessageTo");
        messageSubject = getProperties().getProperty("messageSubject");
        messageText = getProperties().getProperty("messageText");
        relativeAttachmentPath = getProperties().getProperty("relativeAttachmentPath");
        attachFileAssert = getProperties().getProperty("attachFileAssert");
        sendCcAndBccCopyAssert = getProperties().getProperty("sendCcAndBccCopyAssert");
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

    public String getCcMessageTo() {
        return ccMessageTo;
    }

    public String getBccMessageTo() {
        return bccMessageTo;
    }

    public String getSendCcAndBccCopyAssert() {
        return sendCcAndBccCopyAssert;
    }
}