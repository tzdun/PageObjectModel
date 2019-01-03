package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class InvalidLoginPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/login_tests_properties/invalidLogin";
    private String login;
    private String password;
    private String invalidLoginOrPasswordError;
    public InvalidLoginPM() {
        super(propertyFilePath);
        login = getProperties().getProperty("login");
        password = getProperties().getProperty("password");
        invalidLoginOrPasswordError = getProperties().getProperty("invalidLoginOrPasswordError");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidLoginOrPasswordError() {
        return invalidLoginOrPasswordError;
    }
}
