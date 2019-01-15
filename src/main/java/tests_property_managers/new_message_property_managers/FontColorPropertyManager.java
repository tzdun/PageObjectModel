package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class FontColorPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/fontColor";
    private String textAreaFieldMessage;
    private String fontColorAssert;

    public FontColorPropertyManager() {
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