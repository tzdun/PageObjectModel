package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ResizeNewMessagePopupPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/new_message_tests_properties/resizeNewMessagePopup.properties";
    private String maxAssert;
    private String minAssert;
    private String resMinAssert;
    private String resMaxAssert;

    public ResizeNewMessagePopupPM() {
        super(propertyFilePath);
        maxAssert = getProperties().getProperty("maxAssert");
        minAssert = getProperties().getProperty("minAssert");
        resMinAssert = getProperties().getProperty("resMinAssert");
        resMaxAssert = getProperties().getProperty("resMaxAssert");
    }

    public String getMaxAssert() {
        return maxAssert;
    }

    public String getMinAssert() {
        return minAssert;
    }

    public String getResMinAssert() {
        return resMinAssert;
    }

    public String getResMaxAssert() {
        return resMaxAssert;
    }
}