package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ResizePopupPM;

public class ResizePopupTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static ResizePopupPM resizePopupPM = new ResizePopupPM();
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
                .validLoginAndPasswordAssertion(TestData.validLoginAndPasswordAssert)
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