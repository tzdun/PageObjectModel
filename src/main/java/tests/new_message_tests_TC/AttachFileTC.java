package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.new_message_tests_PM.AttachFilePM;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;

public class AttachFileTC extends BaseTestTC {
    private static class TestData{
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static AttachFilePM attachFilePM = new AttachFilePM();
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
                .verifyValidLoginAndPassword(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .clickAttachFileButton(TestData.attachFilePath)
                .verifyAttachFile(TestData.attachFileAssert)
                .logOut();
    }
}