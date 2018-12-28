package utilities;

public class InvalidAccountNamePM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\invalidAccountName.properties";
    private static String accountName;
    private static String password;
    private static String invalidLoginOrPasswordError;
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
