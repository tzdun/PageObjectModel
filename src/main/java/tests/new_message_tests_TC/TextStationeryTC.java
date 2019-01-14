package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_assertions.login_tests.ValidLoginAndPasswordAS;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.TextStationeryPM;

public class TextStationeryTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static TextStationeryPM textStationeryTestDataPM = new TextStationeryPM();
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
                .validLoginAndPasswordAssertion(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .clickStationeryButton()
                .clickStationeryOption()
                .textStationeryAssertion(TestData.textStationeryAssert)
                .clickStationeryButton()
                .clickStationeryResetOption()
                .logOut();
    }
}