package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.ResizePopupPropertyManager;

public class ResizePopupTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static ResizePopupPropertyManager resizePopupPM = new ResizePopupPropertyManager();
        private static String minAssert = resizePopupPM.getMinAssert();
        private static String maxAssert = resizePopupPM.getMaxAssert();
        private static String resMinAssert = resizePopupPM.getResMinAssert();
        private static String resMaxAssert = resizePopupPM.getResMaxAssert();
    }

    @Test (priority = 1)
    public void resizePopup() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .clickMaxMessagePopupButton()
                .resizePopupMinOrMaxAssertion(TestData.maxAssert)
                .clickCloseMaxMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickMinMessagePopupButton()
                .resizePopupMinOrMaxAssertion(TestData.minAssert)
                .clickResMinMessagePopupButton()
                .resizePopupResAssertion(TestData.resMinAssert,TestData.resMaxAssert)
                .clickMinMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickCloseNewMessagePopupButton()
                .logOut();
    }
}