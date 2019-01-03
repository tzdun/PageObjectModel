package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.SendEmailWithoutAttachmentPM;

public class SendEmailWithoutAttachmentTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static SendEmailWithoutAttachmentPM sendEmailWithoutAttachmentPM = new SendEmailWithoutAttachmentPM();
        private static String messageTo = sendEmailWithoutAttachmentPM.getMessageTo();
        private static String messageSubject = sendEmailWithoutAttachmentPM.getMessageSubject();
        private static String messageText = sendEmailWithoutAttachmentPM.getMessageText();
        private static String sendEmailWithoutAttachmentAssert = sendEmailWithoutAttachmentPM.getSendEmailWithoutAttachmentAssert();
    }

    @Test(priority = 1)
    public void sendEmailWithoutAttachment() {

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
                .enterMessageToField(TestData.messageTo)
                .enterMessageSubjectField(TestData.messageSubject)
                .fillInMessageTextArea(TestData.messageText)
                .clickSendButton()
                .verifyMessageSent(TestData.sendEmailWithoutAttachmentAssert)
                .logOut();
    }
}