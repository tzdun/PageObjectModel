package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class InvalidPassword extends BaseTest {
    @Test(priority = 0)
    public void invalidPassword() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .loginToEmailBox("login.testowy", "haslo.nieprawidłowe")
                .acceptCookies()
                .clickLogInForNotOK()
                .verifyInvalidLoginOrPasword("BŁĘDNY LOGIN LUB HASŁO");
        //. POPRAW DANE I PRZEPISZ KOD Z OBRAZKA");
    }
}