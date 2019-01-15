package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class FontSizePropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getNewMessagePropertyFilePath() + "fontSize";
    private String textAreaFieldMessage;
    private String fontSizeAssert;

    public FontSizePropertyManager() {
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