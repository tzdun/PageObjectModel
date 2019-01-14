package tests.login_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.InvalidLoginPM;

public class InvalidLoginTC extends BaseTestTC {

    private static class TestData {
        private static InvalidLoginPM invalidLoginPM = new InvalidLoginPM();
        private static String login = invalidLoginPM.getLogin();
        private static String password = invalidLoginPM.getPassword();
        private static String invalidLoginOrPasswordError = invalidLoginPM.getInvalidLoginOrPasswordError();
    }

    @Test(priority = 1)
    public void invalidAccountName() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInWithFail()
                .invalidLoginOrPasswordAssertion(TestData.invalidLoginOrPasswordError);
    }
}