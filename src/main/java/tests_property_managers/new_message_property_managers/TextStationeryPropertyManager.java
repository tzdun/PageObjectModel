package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class TextStationeryPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/textStationery";
    private String textStationeryAssert;

    public TextStationeryPropertyManager() {
        super(propertyFilePath);
        textStationeryAssert = getProperties().getProperty("textStationeryAssert");
    }

    public String getTextStationeryAssert() {
        return textStationeryAssert;
    }
}