package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.FontSizePM;

public class FontSizeTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM loginTestDataPM = new ValidLoginAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static FontSizePM fontSizeTestDataPM = new FontSizePM();
        private static String textAreaFieldMessage = fontSizeTestDataPM.getTextAreaFieldMessage();
        private static String textFontSizeAssert = fontSizeTestDataPM.getFontSizeAssert();
    }
    @Test (priority = 1)
    public void fontSize() {

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
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .clickMessageTextFrame()
                .verifyTextFontSize(TestData.textFontSizeAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .clickMessageTextFrame()
                .logOut();
    }
}