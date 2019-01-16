package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.GoToHelpPagePropertyManager;

public class GoToHelpPageTest extends BaseTest {

    private static class TestData {
        private static GoToHelpPagePropertyManager goToHelpPagePM = new GoToHelpPagePropertyManager();
        private static String title = goToHelpPagePM.getTitle();
    }

    @Test(priority = 3)
    public void goToHelpPage (){

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .goToHelpPageAssert(TestData.title);
    }
}
