package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.BoldFontPropertyManager;

public class BoldFontTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static BoldFontPropertyManager boldFontPM = new BoldFontPropertyManager();
        private static String textAreaFieldMessage = boldFontPM.getTextAreaFieldMessage();
        private static String boldFontAssert = boldFontPM.getBoldFontAssert();
        private static String boldTextButtonPressedAssert = boldFontPM.getBoldTextButtonPressedAssert();
    }

    @Test(priority = 1)
    public void boldFont() {

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
                .clickBoldButton()
                .boldFontAssertion(TestData.boldFontAssert)
                .boldFontButtonPressedAssertion(TestData.boldTextButtonPressedAssert)
                .keyPress_Ctrl_A()
                .clickBoldButton()
                .clickMessageTextFrame()
                .logOut();
    }
}