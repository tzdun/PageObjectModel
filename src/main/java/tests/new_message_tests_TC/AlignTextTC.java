package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.AlignTextPM;

public class AlignTextTC extends BaseTestTC {

    private static class TestData{
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static AlignTextPM alignTextPM = new AlignTextPM();
        private static String textAreaFieldMessage = alignTextPM.getTextAreaFieldMessage();
        private static String leftAlignAssert = alignTextPM.getLeftAlignAssert();
        private static String centerAlignAssert = alignTextPM.getCenterAlignAssert();
        private static String rightAlignAssert = alignTextPM.getRightAlignAssert();
    }
    @Test (priority = 1)
    public void alignText() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .validLoginAndPasswordAssertion(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .fillInMessageTextArea(TestData.textAreaFieldMessage)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickLeftAlignOption()
                .alignTextAssertion(TestData.leftAlignAssert)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickLeftAlignOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickCenterAlignOption()
                .alignTextAssertion(TestData.centerAlignAssert)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickCenterAlignOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickRightAlignOption()
                .alignTextAssertion(TestData.rightAlignAssert)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickRightAlignOption()
                .clickMessageTextFrame()
                .logOut();
    }
}