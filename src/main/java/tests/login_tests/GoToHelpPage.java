package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class GoToHelpPage extends BaseTest {

    @Test(priority = 3)
    public void goToHelpPage (){

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .goToHelpPage()
                .verifyHelpPage("Pierwsze kroki na poczcie - Podstawy - Pomoc - Poczta w int.pl");
    }
}
