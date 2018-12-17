package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ValidAccountNameAndPassword extends BaseTest {

    @Test (priority = 2)
    public void validAccountNameAndPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .loginToEmailBox("login.testowy", "haslo.testowe")
                .acceptCookies()
                .clickLogInForOK()
                .verifyValidLogin("Dodaj inne konta e-mail");
    }
}