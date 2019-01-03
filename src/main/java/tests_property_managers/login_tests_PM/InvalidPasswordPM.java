package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class InvalidPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/login_tests_properties/invalidPassword";
    private static String login;
    private static String password;
    private static String invalidLoginOrPasswordError;
    public InvalidPasswordPM() {
        super(propertyFilePath);
        login = getProperties().getProperty("login");
        password = getProperties().getProperty("password");
        invalidLoginOrPasswordError = getProperties().getProperty("invalidLoginOrPasswordError");
    }

    public String getAccountName() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidLoginOrPasswordError() {
        return invalidLoginOrPasswordError;
    }
}
