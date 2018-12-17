package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class InvalidAccountName extends BaseTest {
    @Test(priority = 1)
    public void invalidAccountName() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName("login.testowybledny")
                .enterPassword("haslo.haslo")
                .acceptCookies()
                .clickLogInWithFail()
                .verifyInvalidLoginOrPassword("BŁĘDNY LOGIN LUB HASŁO");
    }
}