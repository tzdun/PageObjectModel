package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class InvalidPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/login_tests_properties/invalidPassword.properties";
    private static String accountName;
    private static String password;
    private static String invalidLoginOrPasswordError;
    public InvalidPasswordPM() {
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
