package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.InsertEmoticonPropertyManager;

public class InsertEmoticonTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static InsertEmoticonPropertyManager insertEmoticonPM = new InsertEmoticonPropertyManager();
        private static String insertEmoticonAssert = insertEmoticonPM.getInsertEmoticonAssert();
    }

    @Test (priority = 1)
    public void insertEmoticon() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .clickEmoticonButton()
                .clickEmoticonOption()
                .insertEmoticonAssertion(TestData.insertEmoticonAssert)
                .logOut();
    }
}