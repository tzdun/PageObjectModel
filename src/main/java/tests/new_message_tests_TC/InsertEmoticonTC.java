package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.InsertEmoticonPM;

public class InsertEmoticonTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static InsertEmoticonPM insertEmoticonPM = new InsertEmoticonPM();
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