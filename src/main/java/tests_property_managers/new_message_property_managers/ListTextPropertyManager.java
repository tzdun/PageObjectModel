package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class ListTextPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/listText";
    private String textAreaFieldMessage;
    private String liListAssert;
    private String olListAssert;
    private String ulListAssert;

    public ListTextPropertyManager() {
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