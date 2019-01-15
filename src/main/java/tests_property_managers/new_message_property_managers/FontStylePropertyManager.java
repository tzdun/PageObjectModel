package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class FontStylePropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getNewMessagePropertyFilePath() + "fontStyle";
    private String textAreaFieldMessage;
    private String fontStyleAssert;

    public FontStylePropertyManager() {
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