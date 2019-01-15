package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.SendEmailWithoutRecipientPropertyManager;

public class SendEmailWithoutRecipientTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SendEmailWithoutRecipientPropertyManager sendEmailWithoutRecipientPM = new SendEmailWithoutRecipientPropertyManager();
        private static String sendEmailWithoutRecipientAssert = sendEmailWithoutRecipientPM.getSendEmailWithoutRecipientAssert();
    }

    @Test(priority = 1)
    public void sendEmailWithoutRecipient() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .clickSendButtonWithFail()
                .sendEmailWithoutRecipientAssertion(TestData.sendEmailWithoutRecipientAssert)
                .logOut();
    }
}