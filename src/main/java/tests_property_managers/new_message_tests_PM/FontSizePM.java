package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class FontSizePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/fontSize.properties";
    private String textAreaFieldMessage;
    private String textFontSizeAssert;

    public FontSizePM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        textFontSizeAssert = getProperties().getProperty("textFontSizeAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getTextFontSizeAssert() {
        return textFontSizeAssert;
    }
}