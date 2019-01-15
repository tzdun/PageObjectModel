package tests_property_managers.login_property_managers;

import tests_property_managers.BasePropertyManager;

public class ValidLoginAndPasswordPropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/tests_properties/login_properties/validLoginAndPassword";
    private String login;
    private String password;
    private String validLoginAndPasswordAssert;

    public ValidLoginAndPasswordPropertyManager() {
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