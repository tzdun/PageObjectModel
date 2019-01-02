package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class FontColorPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/fontColor.properties";
    private String textAreaFieldMessage;
    private String fontColorAssert;

    public FontColorPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        fontColorAssert = getProperties().getProperty("fontColorAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getFontColorAssert() {
        return fontColorAssert;
    }
}