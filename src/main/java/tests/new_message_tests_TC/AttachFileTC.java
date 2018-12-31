package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.new_message_tests_PM.AttachFilePM;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;

public class AttachFileTC extends BaseTestTC {
    private static class TestData{
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static AttachFilePM testDataPM = new AttachFilePM();
        private static String pathToFile = testDataPM.getPathToFile();
        private static String fileAddedAssert = testDataPM.getFileAddedAssert();
    }
    @Test (priority = 1)
    public void attachFile() {

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
                .clickAttachFileButton(TestData.pathToFile)
                .verifyAttachmentsAdded(TestData.fileAddedAssert)
                .logOut();
    }
}