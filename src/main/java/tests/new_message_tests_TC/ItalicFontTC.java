package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ItalicFontPM;

public class ItalicFontTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static ItalicFontPM italicFontPM = new ItalicFontPM();
        private static String messageTextArea = italicFontPM.getTextAreaFieldMessage();
        private static String italicFontAssert = italicFontPM.getItalicFontAssert();
    }

    @Test(priority = 1)
    public void italicFont() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .verifyValidLoginAndPassword(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.messageTextArea)
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .clickMessageTextFrame()
                .verifyItalicFont(TestData.italicFontAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .clickMessageTextFrame()
                .logOut();
    }
}