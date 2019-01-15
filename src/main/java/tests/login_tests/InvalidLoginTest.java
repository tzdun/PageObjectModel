package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.InvalidLoginPropertyManager;

public class InvalidLoginTest extends BaseTest {

    private static class TestData {
        private static InvalidLoginPropertyManager invalidLoginPM = new InvalidLoginPropertyManager();
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