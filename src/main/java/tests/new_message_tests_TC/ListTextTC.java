package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_assertions.login_tests.ValidLoginAndPasswordAS;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.ListTextPM;

public class ListTextTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static ListTextPM listTextPM = new ListTextPM();
        private static String textAreaFieldMessage = listTextPM.getTextAreaFieldMessage();
        private static String liListTextAssert = listTextPM.getLiListAssert();
        private static String olListTextAssert = listTextPM.getOlListAssert();
        private static String ulListTextAssert = listTextPM.getUllListAssert();
    }

    @Test(priority = 1)
    public void listText() {

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
                .clickNumericListOption()
                .verifyNumericList(TestData.liListTextAssert, TestData.olListTextAssert)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickNumericListOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickPointListOption()
                .verifyPointedList(TestData.liListTextAssert, TestData.ulListTextAssert)
                .keyPress_Ctrl_A()
                .clickListAndAlignTextButton()
                .clickPointListOption()
                .clickMessageTextFrame()
                .logOut();
    }
}