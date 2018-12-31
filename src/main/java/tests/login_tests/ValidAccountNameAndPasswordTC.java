package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.ValidAccountNameAndPasswordPM;

public class ValidAccountNameAndPasswordTC extends BaseTestTC {

    private static class TestData {
        private static ValidAccountNameAndPasswordPM testDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = testDataPM.getAccountName();
        private static String password = testDataPM.getPassword();
        private static String validLoginAndPasswordAssert = testDataPM.getValidLoginAndPasswordAssert();
    }

    @Test (priority = 2)
    public void validAccountNameAndPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.accountName)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(TestData.validLoginAndPasswordAssert)
                .logOut();
    }
}