package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ListTextPM;

public class ListTextTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static ListTextPM listTextTestDataPM = new ListTextPM();
        private static String textAreaFieldMessage = listTextTestDataPM.getTextAreaFieldMessage();
        private static String liListTextAssert = listTextTestDataPM.getLiListAssert();
        private static String olListTextAssert = listTextTestDataPM.getOlListAssert();
        private static String ulListTextAssert = listTextTestDataPM.getUllListAssert();
    }

    @Test(priority = 1)
    public void listText() {

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
                .clickNumericListOption()
                .clickMessageTextFrame()
                .verifyNumericList(TestData.liListTextAssert, TestData.olListTextAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickNumericListOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickPointListOption()
                .clickMessageTextFrame()
                .verifyPointedList(TestData.liListTextAssert, TestData.ulListTextAssert)
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickPointListOption()
                .clickMessageTextFrame()
                .logOut();
    }
}