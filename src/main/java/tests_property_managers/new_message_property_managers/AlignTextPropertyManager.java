package tests_property_managers.new_message_property_managers;

import tests_property_managers.BasePropertyManager;

public class AlignTextPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/new_message_properties/alignText";
    private String textAreaFieldMessage;
    private String leftAlignAssert;
    private String centerAlignAssert;
    private String rightAlignAssert;

    public AlignTextPropertyManager() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        leftAlignAssert = getProperties().getProperty("leftAlignAssert");
        centerAlignAssert = getProperties().getProperty("centerAlignAssert");
        rightAlignAssert = getProperties().getProperty("rightAlignAssert");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getLeftAlignAssert() {
        return leftAlignAssert;
    }

    public String getCenterAlignAssert() {
        return centerAlignAssert;
    }

    public String getRightAlignAssert() {
        return rightAlignAssert;
    }
}