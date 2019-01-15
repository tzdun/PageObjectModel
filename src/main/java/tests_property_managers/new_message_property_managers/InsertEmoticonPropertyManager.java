package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class InsertEmoticonPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/insertEmoticon";
    private String insertEmoticonAssert;

    public InsertEmoticonPropertyManager() {
        super(propertyFilePath);
        insertEmoticonAssert = getProperties().getProperty("insertEmoticonAssert");
    }

    public String getInsertEmoticonAssert() {
        return insertEmoticonAssert;
    }
}