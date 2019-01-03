package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class UnderlineFontPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/underlineFont";
    private String textAreaFieldMessage;
    private String underlineFontAssert;

    public UnderlineFontPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        underlineFontAssert = getProperties().getProperty("underlineFontAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getUnderlineFontAssert() {
        return underlineFontAssert;
    }
}