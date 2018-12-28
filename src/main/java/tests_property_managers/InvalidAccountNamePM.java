package tests_property_managers;

public class InvalidAccountNamePM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\invalidAccountName.properties";
    private String accountName;
    private String password;
    private String invalidLoginOrPasswordError;
    public InvalidAccountNamePM() {
        super(propertyFilePath);
        accountName = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("accountName");
        password = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("password");
        invalidLoginOrPasswordError = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("invalidLoginOrPasswordError");
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
