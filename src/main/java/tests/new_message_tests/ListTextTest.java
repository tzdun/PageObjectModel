package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.ListTextPropertyManager;

public class ListTextTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static ListTextPropertyManager listTextPM = new ListTextPropertyManager();
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