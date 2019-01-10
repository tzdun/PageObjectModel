package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class InsertEmoticonPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/insertEmoticon";
    private String insertEmoticonAssert;

    public InsertEmoticonPM() {
        super(propertyFilePath);
        insertEmoticonAssert = getProperties().getProperty("insertEmoticonAssert");
    }

    public String getInsertEmoticonAssert() {
        return insertEmoticonAssert;
    }
}