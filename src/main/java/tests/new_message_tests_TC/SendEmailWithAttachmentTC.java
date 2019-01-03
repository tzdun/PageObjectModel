package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.SendEmailWithAttachmentPM;

public class SendEmailWithAttachmentTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static SendEmailWithAttachmentPM sendEmailWithAttachmentPM = new SendEmailWithAttachmentPM();
        private static String messageTo = sendEmailWithAttachmentPM.getMessageTo();
        private static String messageSubject = sendEmailWithAttachmentPM.getMessageSubject();
        private static String messageText = sendEmailWithAttachmentPM.getMessageText();
        private static String canonicalAttachmentPath = sendEmailWithAttachmentPM.getCanonicalAttachmentPath();
        private static String attachFileAssert = sendEmailWithAttachmentPM.getAttachFileAssert();
        private static String sendEmailWithAttachmentAssert = sendEmailWithAttachmentPM.getSendEmailWithAttachmentAssert();
    }

    @Test(priority = 1)
    public void sendEmailWithAttachment() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.login)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(TestData.validLoginAndPasswordAssert)
                .clickNewMessageButton()
                .enterMessageToField(TestData.messageTo)
                .enterMessageSubjectField(TestData.messageSubject)
                .enterMessageTextAreaField(TestData.messageText)
                .clickAttachFileButton(TestData.canonicalAttachmentPath)
                .verifyAttachmentsAdded(TestData.attachFileAssert)
                .clickSendButton()
                .verifyMessageSent(TestData.sendEmailWithAttachmentAssert)
                .logOut();
    }
}