package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class BoldFontPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/boldFont.properties";
    private String textAreaFieldMessage;
    private String boldFontAssert;

    public BoldFontPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        boldFontAssert = getProperties().getProperty("boldFontAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getBoldFontAssert() {
        return boldFontAssert;
    }
}