package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ColorTextPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/colorText.properties";
    private String textAreaFieldMessage;
    private String textIsColoredAssert;

    public ColorTextPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        textIsColoredAssert = getProperties().getProperty("textIsColoredAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getTextIsColoredAssert() {
        return textIsColoredAssert;
    }
}