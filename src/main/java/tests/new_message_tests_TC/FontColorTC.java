package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.FontColorPM;

public class FontColorTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static FontColorPM colorTextTestDataPM = new FontColorPM();
        private static String textAreaFieldMessage = colorTextTestDataPM.getTextAreaFieldMessage();
        private static String fontColorAssert = colorTextTestDataPM.getFontColorAssert();
    }
    @Test (priority = 1)
    public void colorText() {

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
                .clickFontColorButton()
                .clickRedFontColorButton()
                .clickMessageTextFrame()
                .verifyTextFontStyle(TestData.fontColorAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontColorButton()
                .clickBlackFontColorButton()
                .clickMessageTextFrame()
                .logOut();
    }
}