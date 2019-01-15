package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.AttachFilePropertyManager;

public class AttachFileTest extends BaseTest {
    private static class TestData{
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static AttachFilePropertyManager attachFilePM = new AttachFilePropertyManager();
        private static String attachFilePath = attachFilePM.getAttachFilePath();
        private static String attachFileAssert = attachFilePM.getAttachFileAssert();
    }
    @Test (priority = 1)
    public void attachFile() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .attachFile(TestData.attachFilePath)
                .attachFileAndInsertImageAssertion(TestData.attachFileAssert)
                .logOut();
    }
}