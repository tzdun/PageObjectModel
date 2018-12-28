package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import utilities.GoToHelpPagePropertyManager;

public class GoToHelpPage extends BaseTest {
    private GoToHelpPagePropertyManager testData = new GoToHelpPagePropertyManager();
    @Test(priority = 3)
    public void goToHelpPage (){
        GoToHelpPagePropertyManager x = new GoToHelpPagePropertyManager();
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .verifyHelpPage(testData.getTitle());
    }
}
