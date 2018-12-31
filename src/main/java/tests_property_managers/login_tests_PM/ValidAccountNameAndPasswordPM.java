package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ValidAccountNameAndPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\validAccountNameAndPassword.properties";
    private static String accountName;
    private static String password;
    private static String validLoginAndPasswordAssert;
    public ValidAccountNameAndPasswordPM() {
        super(propertyFilePath);
        accountName = getProperties().getProperty("accountName");
        password = getProperties().getProperty("password");
        validLoginAndPasswordAssert = getProperties().getProperty("validLoginAndPasswordAssert");
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public String getValidLoginAndPasswordAssert() {
        return validLoginAndPasswordAssert;
    }
}
