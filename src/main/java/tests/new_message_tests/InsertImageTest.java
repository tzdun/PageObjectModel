package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.InsertImagePropertyManager;

public class InsertImageTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static InsertImagePropertyManager insertImagePM = new InsertImagePropertyManager();
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
                .clickNewMessageButton()
                .insertImage(TestData.canonicalPathToImage)
                .attachFileAndInsertImageAssertion(TestData.insertImageAssert)
                .logOut();
    }
}