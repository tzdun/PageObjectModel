package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.InsertImagePM;

public class InsertImageTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static InsertImagePM insertImagePM = new InsertImagePM();
        private static String canonicalPathToImage = insertImagePM.getCanonicalImagePath();
        private static String insertImageAssert = insertImagePM.getInsertImageAssert();

    }

    @Test(priority = 1)
    public void insertImage() {

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
                .clickInsertImageButton(TestData.canonicalPathToImage)
                .verifyAttachFile(TestData.insertImageAssert)
                .logOut();
    }
}