package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidAccountNameAndPasswordPM;
import tests_property_managers.new_message_tests_PM.InsertImagePM;

public class InsertImageTC extends BaseTestTC {
    private static class TestData {
        private static ValidAccountNameAndPasswordPM loginTestDataPM = new ValidAccountNameAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();

        private static InsertImagePM insertImageTestDataPM = new InsertImagePM();
        private static String canonicalPathToImage = insertImageTestDataPM.getCanonicalPathToImage();
        private static String insertImageAssert = insertImageTestDataPM.getInsertImageAssert();

    }
    @Test(priority = 1)
    public void mailContentInsertImage() {

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
                .clickInsertImageButton(TestData.canonicalPathToImage)
                .verifyAttachmentsAdded(TestData.insertImageAssert)
                .logOut();
    }
}