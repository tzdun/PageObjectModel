package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class BoldTextPM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\boldText.properties";
    private String textAreaFieldMessage;
    private String textIsBoldAssert;

    public BoldTextPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        textIsBoldAssert = getProperties().getProperty("textIsBoldAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getTextIsBoldAssert() {
        return textIsBoldAssert;
    }
}