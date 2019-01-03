package tests.login_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.InvalidPasswordPM;

public class InvalidPasswordTC extends BaseTestTC {

    private static class TestData {
        private static InvalidPasswordPM testDataPM = new InvalidPasswordPM();
        private static String login = testDataPM.getAccountName();
        private static String password = testDataPM.getPassword();
        private static String invalidLoginOrPasswordError = testDataPM.getInvalidLoginOrPasswordError();
    }

    @Test(priority = 0)
    public void invalidPassword() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.login)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithFail()
                .verifyInvalidLoginOrPassword(TestData.invalidLoginOrPasswordError);
    }
}