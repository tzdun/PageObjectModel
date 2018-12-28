package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import utilities.GoToHelpPagePM;

public class GoToHelpPage extends BaseTest {
    private GoToHelpPagePM testData = new GoToHelpPagePM();

    @Test(priority = 3)
    public void goToHelpPage (){
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .verifyHelpPage(testData.getTitle());
    }
}
