package tests_property_managers.login_property_managers;

import tests_property_managers.BasePropertyManager;

public class InvalidPasswordPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getLoginPropertyFilePath() + "invalidPassword";
    private String login;
    private String password;
    private String invalidLoginOrPasswordError;

    public InvalidPasswordPropertyManager() {
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
