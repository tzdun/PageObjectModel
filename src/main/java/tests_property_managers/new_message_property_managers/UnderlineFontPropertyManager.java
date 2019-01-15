package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class UnderlineFontPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/underlineFont";
    private String textAreaFieldMessage;
    private String underlineFontAssert;

    public UnderlineFontPropertyManager() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        underlineFontAssert = getProperties().getProperty("underlineFontAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getUnderlineFontAssert() {
        return underlineFontAssert;
    }
}