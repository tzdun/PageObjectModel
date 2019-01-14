package tests.login_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.GoToHelpPagePM;

public class GoToHelpPageTC extends BaseTestTC {

    private static class TestData {
        private static GoToHelpPagePM goToHelpPagePM = new GoToHelpPagePM();
        private static String title = goToHelpPagePM.getTitle();
    }

    @Test(priority = 3)
    public void goToHelpPage (){
        System.out.println(this.getClass().getName());

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .goToHelpPageAssert(TestData.title);
    }
}
