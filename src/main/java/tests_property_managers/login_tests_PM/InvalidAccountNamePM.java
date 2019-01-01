package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class InvalidAccountNamePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/invalidAccountName.properties";
    private String accountName;
    private String password;
    private String invalidLoginOrPasswordError;
    public InvalidAccountNamePM() {
        super(propertyFilePath);
        accountName = getProperties().getProperty("accountName");
        password = getProperties().getProperty("password");
        invalidLoginOrPasswordError = getProperties().getProperty("invalidLoginOrPasswordError");
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidLoginOrPasswordError() {
        return invalidLoginOrPasswordError;
    }
}
