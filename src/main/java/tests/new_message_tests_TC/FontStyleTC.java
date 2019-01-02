package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.FontStylePM;

public class FontStyleTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static FontStylePM fontStyleTestDataPM = new FontStylePM();
        private static String textAreaFieldMessage = fontStyleTestDataPM.getTextAreaFieldMessage();
        private static String fontStyleAssert = fontStyleTestDataPM.getFontStyleAssert();
    }
    @Test (priority = 1)
    public void fontStyle() {

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
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .verifyTextFontStyle(TestData.fontStyleAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .logOut();
    }
}