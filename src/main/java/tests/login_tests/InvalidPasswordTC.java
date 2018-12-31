package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.InvalidPasswordPM;

public class InvalidPasswordTC extends BaseTestTC {

    private static class TestData {
        private static InvalidPasswordPM testDataPM = new InvalidPasswordPM();
        private static String accountName = testDataPM.getAccountName();
        private static String password = testDataPM.getPassword();
        private static String invalidLoginOrPasswordError = testDataPM.getInvalidLoginOrPasswordError();
    }

    @Test(priority = 0)
    public void invalidPassword() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.accountName)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithFail()
                .verifyInvalidLoginOrPassword(TestData.invalidLoginOrPasswordError);
    }
}