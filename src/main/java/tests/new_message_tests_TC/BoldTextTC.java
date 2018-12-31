package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.BoldTextPM;

public class BoldTextTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static BoldTextPM boldTextTestDataPM = new BoldTextPM();
        private static String textAreaFieldMessage = boldTextTestDataPM.getTextAreaFieldMessage();
        private static String textIsBoldAssert = boldTextTestDataPM.getTextIsBoldAssert();
    }

    @Test(priority = 1)
    public void boldText() {

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
                .enterMessageTextAreaField(TestData.textAreaFieldMessage)
                .keyPress_Ctrl_A()
                .clickBoldButton()
                .clickMessageTextFrame()
                .verifyTextIsBold(TestData.textIsBoldAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickBoldButton()
                .clickMessageTextFrame()
                .logOut();
    }
}