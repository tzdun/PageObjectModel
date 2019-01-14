package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_assertions.login_tests.ValidLoginAndPasswordAS;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.FontStylePM;

public class FontStyleTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static FontStylePM fontStylePM = new FontStylePM();
        private static String textAreaFieldMessage = fontStylePM.getTextAreaFieldMessage();
        private static String fontStyleAssert = fontStylePM.getFontStyleAssert();
    }

    @Test (priority = 1)
    public void fontStyle() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass();
                new ValidLoginAndPasswordAS(driver)
                .validLoginAndPasswordAssertion(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.textAreaFieldMessage)
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .verifyFontColorAndStyle(TestData.fontStyleAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .logOut();
    }
}