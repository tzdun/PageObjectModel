package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.BoldFontPM;

public class BoldFontTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static BoldFontPM boldFontPM = new BoldFontPM();
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