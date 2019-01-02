package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ItalicFontPM;

public class ItalicFontTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static ItalicFontPM italicFontTestDataPM = new ItalicFontPM();
        private static String textAreaFieldMessage = italicFontTestDataPM.getTextAreaFieldMessage();
        private static String italicFontAssert = italicFontTestDataPM.getItalicFontAssert();
    }
    @Test (priority = 1)
    public void italicText() {

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
                .clickItalicButton()
                .clickMessageTextFrame()
                .verifyTextIsItalic(TestData.italicFontAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .clickMessageTextFrame()
                .logOut();
    }
}