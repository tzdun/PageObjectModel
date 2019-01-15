package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class SendEmailWithoutAttachmentPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/sendEmailWithoutAttachment";
    private String messageTo;
    private String messageSubject;
    private String messageText;
    private String sendEmailWithoutAttachmentAssert;

    public SendEmailWithoutAttachmentPropertyManager() {
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