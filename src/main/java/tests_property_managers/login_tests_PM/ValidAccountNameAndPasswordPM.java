package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class ValidAccountNameAndPasswordPM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\validAccountNameAndPassword.properties";
    private static String accountName;
    private static String password;
    private static String validLoginAndPasswordAssert;
    public ValidAccountNameAndPasswordPM() {
        super(propertyFilePath);
        accountName = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("accountName");
        password = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("password");
        validLoginAndPasswordAssert = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("validLoginAndPasswordAssert");
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
