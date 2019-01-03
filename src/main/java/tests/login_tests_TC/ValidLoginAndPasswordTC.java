package tests.login_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;

public class ValidLoginAndPasswordTC extends BaseTestTC {

    private static class TestData {
        private static ValidLoginAndPasswordPM testDataPM = new ValidLoginAndPasswordPM();
        private static String login = testDataPM.getAccountName();
        private static String password = testDataPM.getPassword();
        private static String validLoginAndPasswordAssert = testDataPM.getValidLoginAndPasswordAssert();
    }

    @Test (priority = 2)
    public void validAccountNameAndPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.login)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(TestData.validLoginAndPasswordAssert)
                .logOut();
    }
}