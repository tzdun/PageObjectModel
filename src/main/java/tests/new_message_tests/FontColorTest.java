package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.FontColorPropertyManager;

public class FontColorTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static FontColorPropertyManager fontColorPM = new FontColorPropertyManager();
        private static String textAreaFieldMessage = fontColorPM.getTextAreaFieldMessage();
        private static String fontColorAssert = fontColorPM.getFontColorAssert();
    }

    @Test (priority = 1)
    public void fontColor() {

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
                .clickFontColorButton()
                .clickRedFontColorButton()
                .fontColorAndStyleAssertion(TestData.fontColorAssert)
                .fontButtonColorAssertion(TestData.fontColorAssert)
                .keyPress_Ctrl_A()
                .clickFontColorButton()
                .clickBlackFontColorButton()
                .clickMessageTextFrame()
                .logOut();
    }
}