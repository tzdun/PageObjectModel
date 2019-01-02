package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ItalicFontPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/italicFont.properties";
    private String textAreaFieldMessage;
    private String italicFontAssert;

    public ItalicFontPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        italicFontAssert = getProperties().getProperty("italicFontAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getItalicFontAssert() {
        return italicFontAssert;
    }
}