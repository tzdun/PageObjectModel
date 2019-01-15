package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.InvalidPasswordPropertyManager;

public class InvalidPasswordTest extends BaseTest {

    private static class TestData {
        private static InvalidPasswordPropertyManager invalidPasswordPM = new InvalidPasswordPropertyManager();
        private static String login = invalidPasswordPM.getAccountName();
        private static String password = invalidPasswordPM.getPassword();
        private static String invalidLoginOrPasswordError = invalidPasswordPM.getInvalidLoginOrPasswordError();
    }

    @Test(priority = 0)
    public void invalidPassword() {

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