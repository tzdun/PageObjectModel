package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class GoToHelpPagePM extends BasePropertyManager {
    private static final String propertyFilePath = "C:\\Users\\rb26508\\PageObjectModel\\src\\main\\resources\\goToHelpPage.properties";
    private static String title;

    public GoToHelpPagePM() {
        super(propertyFilePath);
        title = BasePropertyManager.getInstance(propertyFilePath).getProperties().getProperty("title");
    }

    public String getTitle(){
        return title;
    }
}
