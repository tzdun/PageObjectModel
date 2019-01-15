package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.UnderlineFontPropertyManager;

public class UnderlineFontTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static UnderlineFontPropertyManager underlineFontPM = new UnderlineFontPropertyManager();
        private static String textAreaFieldMessage = underlineFontPM.getTextAreaFieldMessage();
        private static String underlineFontAssert = underlineFontPM.getUnderlineFontAssert();
    }

    @Test (priority = 1)
    public void underlineText() {

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
                .clickUnderlineButton()
                .underlineFontAssertion(TestData.underlineFontAssert)
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .clickMessageTextFrame()
                .logOut();
    }
}