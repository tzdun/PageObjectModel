package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class TextStationeryPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getNewMessagePropertyFilePath() + "textStationery";
    private String textStationeryAssert;

    public TextStationeryPropertyManager() {
        super(propertyFilePath);
        textStationeryAssert = getProperties().getProperty("textStationeryAssert");
    }

    public String getTextStationeryAssert() {
        return textStationeryAssert;
    }
}