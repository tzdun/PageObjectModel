package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.SendEmailWithoutRecipientPM;

public class SendEmailWithoutRecipientTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM loginTestDataPM = new ValidLoginAndPasswordPM();
        private static String accountName = loginTestDataPM.getAccountName();
        private static String password = loginTestDataPM.getPassword();
        private static String validLoginAndPasswordAssert = loginTestDataPM.getValidLoginAndPasswordAssert();
        private static SendEmailWithoutRecipientPM sendEmailWithoutRecipientPM = new SendEmailWithoutRecipientPM();
        private static String sendEmailWithoutRecipientAssert = sendEmailWithoutRecipientPM.getSendEmailWithoutRecipientAssert();
    }

    @Test(priority = 1)
    public void sendEmailWithoutRecipient() {

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
                .clickSendButton()
                .verifyNoRecipientsError(TestData.sendEmailWithoutRecipientAssert)
                .logOut();
    }
}