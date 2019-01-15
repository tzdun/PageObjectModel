package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.ItalicFontPropertyManager;

public class ItalicFontTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static ItalicFontPropertyManager italicFontPM = new ItalicFontPropertyManager();
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
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.messageTextArea)
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .italicFontAssertion(TestData.italicFontAssert)
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .clickMessageTextFrame()
                .logOut();
    }
}