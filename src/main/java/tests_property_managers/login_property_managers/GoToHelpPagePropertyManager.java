package tests_property_managers.login_property_managers;

import tests_property_managers.BasePropertyManager;

public class GoToHelpPagePropertyManager extends BasePropertyManager {
    private static final String propertyFilePath = BasePropertyManager.getLoginPropertyFilePath() + "goToHelpPage";
    private String title;

    public GoToHelpPagePropertyManager() {
        super(propertyFilePath);
        title = getProperties().getProperty("title");
    }

    public String getTitle() {
        return title;
    }
}
