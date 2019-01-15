package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class ItalicFontPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/italicFont";
    private String textAreaFieldMessage;
    private String italicFontAssert;

    public ItalicFontPropertyManager() {
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