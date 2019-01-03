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
                .enterAccountName(TestData.login)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .enterMessageTextAreaField(TestData.textAreaFieldMessage)
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickLeftAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment(TestData.leftAlignAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickLeftAlignmentOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickCenterAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment(TestData.centerAlignAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickCenterAlignmentOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickRightAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment(TestData.rightAlignAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickRightAlignmentOption()
                .clickMessageTextFrame()
                .logOut();
    }
}