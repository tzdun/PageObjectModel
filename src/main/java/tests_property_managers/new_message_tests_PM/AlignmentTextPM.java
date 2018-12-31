package tests_property_managers.new_message_tests_PM;

import tests_property_managers.BasePropertyManager;

public class AlignmentTextPM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\alignmentText.properties";
    private String textAreaFieldMessage;
    private String textAlignmentLeftAssert;
    private String textAlignmentCenterAssert;
    private String textAlignmentRightAssert;

    public AlignmentTextPM() {
        super(propertyFilePath);
        textAreaFieldMessage = getProperties().getProperty("textAreaFieldMessage");
        textAlignmentLeftAssert = getProperties().getProperty("textAlignmentLeft");
        textAlignmentCenterAssert = getProperties().getProperty("textAlignmentCenter");
        textAlignmentRightAssert = getProperties().getProperty("textAlignmentRight");
    }

    public String getTextAreaFieldMessage() {
        return textAreaFieldMessage;
    }

    public String getTextAlignmentLeftAssert() {
        return textAlignmentLeftAssert;
    }

    public String getTextAlignmentCenterAssert() {
        return textAlignmentCenterAssert;
    }

    public String getTextAlignmentRightAssert() {
        return textAlignmentRightAssert;
    }
}