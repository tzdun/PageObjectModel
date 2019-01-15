package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.FontSizePM;

public class FontSizeTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static FontSizePM fontSizePM = new FontSizePM();
        private static String textAreaFieldMessage = fontSizePM.getTextAreaFieldMessage();
        private static String textFontSizeAssert = fontSizePM.getFontSizeAssert();
    }

    @Test (priority = 1)
    public void fontSize() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.textAreaFieldMessage)
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .fontSizeAssertion(TestData.textFontSizeAssert)
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .clickMessageTextFrame()
                .logOut();
    }
}