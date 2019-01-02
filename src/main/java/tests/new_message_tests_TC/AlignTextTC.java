package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.AlignmentTextPM;

public class AlignTextTC extends BaseTestTC {

    private static class TestData{
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static AlignmentTextPM alignmentTextTestDataPM = new AlignmentTextPM();
        private static String textAreaFieldMessage = alignmentTextTestDataPM.getTextAreaFieldMessage();
        private static String leftAlignAssert = alignmentTextTestDataPM.getLeftAlignAssert();
        private static String centerAlignAssert = alignmentTextTestDataPM.getCenterAlignAssert();
        private static String rightAlignAssert = alignmentTextTestDataPM.getRightAlignAssert();
    }
    @Test (priority = 1)
    public void alignmentText() {

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