package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ResizePopupPM;

public class ResizePopupTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM loginTestDataPM = new ValidLoginAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
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
                .enterAccountName(TestData.accountName)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .clickMaxMessagePopupButton()
                .verifyMessagePopupIsMax(TestData.maxAssert)
                .clickCloseMaxMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickMinMessagePopupButton()
                .verifyMessagePopupIsMin(TestData.minAssert)
                .clickResMinMessagePopupButton()
                .verifyMessagePopupIsRes(TestData.resMinAssert,TestData.resMaxAssert)
                .clickMinMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickCloseNewMessagePopupButton()
                .logOut();
    }
}