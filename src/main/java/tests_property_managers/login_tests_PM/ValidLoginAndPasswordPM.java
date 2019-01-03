package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ValidLoginAndPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/login_tests_properties/validLoginAndPassword";
    private String login;
    private String password;
    private String validLoginAndPasswordAssert;

    public ValidLoginAndPasswordPM() {
        super(propertyFilePath);
        login = getProperties().getProperty("login");
        password = getProperties().getProperty("password");
        validLoginAndPasswordAssert = getProperties().getProperty("validLoginAndPasswordAssert");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getValidLoginAndPasswordAssert() {
        return validLoginAndPasswordAssert;
    }
}
