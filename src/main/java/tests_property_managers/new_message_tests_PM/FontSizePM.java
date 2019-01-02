package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class FontSizePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/fontSize.properties";
    private String textAreaFieldMessage;
    private String fontSizeAssert;

    public FontSizePM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        fontSizeAssert = getProperties().getProperty("fontSizeAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getFontSizeAssert() {
        return fontSizeAssert;
    }
}