package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class FontStylePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/fontStyle.properties";
    private String textAreaFieldMessage;
    private String textFontStyleAssert;

    public FontStylePM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        textFontStyleAssert = getProperties().getProperty("textFontStyleAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getTextFontStyleAssert() {
        return textFontStyleAssert;
    }
}