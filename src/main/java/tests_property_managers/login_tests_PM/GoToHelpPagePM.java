package tests_property_managers.login_tests_PM;

import tests_property_managers.BasePropertyManager;

public class GoToHelpPagePM extends BasePropertyManager {
    private static final String propertyFilePath = "src/main/resources/goToHelpPage.properties";
    private static String title;

    public GoToHelpPagePM() {
        super(propertyFilePath);
        title = getProperties().getProperty("title");
    }

    public String getTitle(){
        return title;
    }
}
