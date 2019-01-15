package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.TextStationeryPropertyManager;

public class TextStationeryTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static TextStationeryPropertyManager textStationeryTestDataPM = new TextStationeryPropertyManager();
        private static String textStationeryAssert = textStationeryTestDataPM.getTextStationeryAssert();
    }

    @Test (priority = 1)
    public void mailContentStationery() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .clickStationeryButton()
                .clickStationeryOption()
                .textStationeryAssertion(TestData.textStationeryAssert)
                .clickStationeryButton()
                .clickStationeryResetOption()
                .logOut();
    }
}