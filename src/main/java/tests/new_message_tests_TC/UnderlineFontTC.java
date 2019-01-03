package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.UnderlineFontPM;

public class UnderlineFontTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM loginTestDataPM = new ValidLoginAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static UnderlineFontPM underlineFontTestDataPM = new UnderlineFontPM();
        private static String textAreaFieldMessage = underlineFontTestDataPM.getTextAreaFieldMessage();
        private static String underlineFontAssert = underlineFontTestDataPM.getUnderlineFontAssert();
    }
    @Test (priority = 1)
    public void underlineText() {

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
                .clickUnderlineButton()
                .clickMessageTextFrame()
                .verifyTextIsUnderlined(TestData.underlineFontAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .clickMessageTextFrame()
                .logOut();
    }
}