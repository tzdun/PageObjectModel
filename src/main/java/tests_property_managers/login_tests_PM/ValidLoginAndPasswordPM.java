package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ValidLoginAndPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/login_tests_properties/validLoginAndPassword";
    private static String login;
    private static String password;
    private static String validLoginAndPasswordAssert;
    public ValidLoginAndPasswordPM() {
        super(propertyFilePath);
        login = getProperties().getProperty("login");
        password = getProperties().getProperty("password");
        validLoginAndPasswordAssert = getProperties().getProperty("validLoginAndPasswordAssert");
    }

    public String getAccountName() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getValidLoginAndPasswordAssert() {
        return validLoginAndPasswordAssert;
    }
}
