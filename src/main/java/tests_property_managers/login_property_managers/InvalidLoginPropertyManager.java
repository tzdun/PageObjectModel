package tests_property_managers.login_property_managers;

import tests_property_managers.BasePropertyManager;

public class InvalidLoginPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getLoginPropertyFilePath() + "invalidLogin";
    private String login;
    private String password;
    private String invalidLoginOrPasswordError;
    public InvalidLoginPropertyManager() {
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
