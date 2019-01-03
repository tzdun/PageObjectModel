package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class TextStationeryPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/textStationery";
    private String textStationeryAssert;

    public TextStationeryPM() {
        super(propertyFilePath);
        textStationeryAssert = getProperties().getProperty("textStationeryAssert");
    }

    public String getTextStationeryAssert() {
        return textStationeryAssert;
    }
}