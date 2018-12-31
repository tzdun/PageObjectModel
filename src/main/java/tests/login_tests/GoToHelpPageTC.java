package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.GoToHelpPagePM;

public class GoToHelpPageTC extends BaseTestTC {

    private static class TestData {
        private static GoToHelpPagePM testDataPM = new GoToHelpPagePM();
        private static String title = testDataPM.getTitle();
    }

    @Test(priority = 3)
    public void goToHelpPage (){
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .verifyHelpPage(TestData.title);
    }
}
