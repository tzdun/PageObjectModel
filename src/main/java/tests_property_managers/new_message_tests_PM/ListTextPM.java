package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ListTextPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/listText";
    private String textAreaFieldMessage;
    private String liListAssert;
    private String olListAssert;
    private String ulListAssert;

    public ListTextPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        liListAssert = getProperties().getProperty("liListAssert");
        olListAssert = getProperties().getProperty("olListAssert");
        ulListAssert = getProperties().getProperty("ulListAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getLiListAssert() {
        return liListAssert;
    }

    public String getOlListAssert() {
        return olListAssert;
    }

    public String getUllListAssert() {
        return ulListAssert;
    }
}