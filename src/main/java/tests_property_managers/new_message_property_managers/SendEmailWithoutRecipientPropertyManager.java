package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class SendEmailWithoutRecipientPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/sendEmailWithoutRecipient";
    private String sendEmailWithoutRecipientAssert;

    public SendEmailWithoutRecipientPropertyManager() {
        super(propertyFilePath);
        sendEmailWithoutRecipientAssert = getProperties().getProperty("sendEmailWithoutRecipientAssert");
    }

    public String getSendEmailWithoutRecipientAssert() {
        return sendEmailWithoutRecipientAssert;
    }
}