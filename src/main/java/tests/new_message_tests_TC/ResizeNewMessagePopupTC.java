package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ResizeNewMessagePopupPM;

public class ResizeNewMessagePopupTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static ResizeNewMessagePopupPM resizeNewMessagePopupTestDataPM = new ResizeNewMessagePopupPM();
        private static String minAssert = resizeNewMessagePopupTestDataPM.getMinAssert();
        private static String maxAssert = resizeNewMessagePopupTestDataPM.getMaxAssert();
        private static String resMinAssert = resizeNewMessagePopupTestDataPM.getResMinAssert();
        private static String resMaxAssert = resizeNewMessagePopupTestDataPM.getResMaxAssert();
    }

    @Test (priority = 1)
    public void resizeNewMessagePopup() {

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