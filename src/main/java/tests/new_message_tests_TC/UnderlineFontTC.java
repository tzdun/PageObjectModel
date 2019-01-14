package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_assertions.login_tests.ValidLoginAndPasswordAS;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.UnderlineFontPM;

public class UnderlineFontTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static UnderlineFontPM underlineFontPM = new UnderlineFontPM();
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
                .clickLogInButtonWithPass();
                new ValidLoginAndPasswordAS(driver)
                .validLoginAndPasswordAssertion(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.textAreaFieldMessage)
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