package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class SendEmailWithoutAttachmentPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/sendEmailWithoutAttachment";
    private String messageTo;
    private String messageSubject;
    private String messageText;
    private String sendEmailWithoutAttachmentAssert;

    public SendEmailWithoutAttachmentPM() {
        super(propertyFilePath);
        messageTo = getProperties().getProperty("messageTo");
        messageSubject = getProperties().getProperty("messageSubject");
        messageText = getProperties().getProperty("messageText");
        sendEmailWithoutAttachmentAssert = getProperties().getProperty("sendEmailWithoutAttachmentAssert");
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

    public String getSendEmailWithoutAttachmentAssert() {
        return sendEmailWithoutAttachmentAssert;
    }
}