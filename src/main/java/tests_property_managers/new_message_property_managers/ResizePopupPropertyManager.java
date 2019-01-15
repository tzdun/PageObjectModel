package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class ResizePopupPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getNewMessagePropertyFilePath() + "resizePopup";
    private String maxAssert;
    private String minAssert;
    private String resMinAssert;
    private String resMaxAssert;

    public ResizePopupPropertyManager() {
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