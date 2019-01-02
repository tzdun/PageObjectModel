package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class FontStylePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/fontStyle.properties";
    private String textAreaFieldMessage;
    private String fontStyleAssert;

    public FontStylePM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        fontStyleAssert = getProperties().getProperty("fontStyleAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getFontStyleAssert() {
        return fontStyleAssert;
    }
}