package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class SendEmailWithoutRecipientPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/sendEmailWithoutRecipient";
    private String sendEmailWithoutRecipientAssert;

    public SendEmailWithoutRecipientPM() {
        super(propertyFilePath);
        sendEmailWithoutRecipientAssert = getProperties().getProperty("sendEmailWithoutRecipientAssert");
    }

    public String getSendEmailWithoutRecipientAssert() {
        return sendEmailWithoutRecipientAssert;
    }
}