package utilities;

public class GoToHelpPagePropertyManager extends PropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\goToHelpPage.properties";
    private static String title;

    public GoToHelpPagePropertyManager() {
        super(propertyFilePath);
        title = PropertyManager.getInstance(propertyFilePath).getProperties().getProperty("title");
    }

    public String getTitle(){
        return title;
    }
}
