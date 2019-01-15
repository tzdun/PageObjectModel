package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.SendEmailWithAttachmentPropertyManager;

public class SendEmailWithAttachmentTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SendEmailWithAttachmentPropertyManager sendEmailWithAttachmentPM = new SendEmailWithAttachmentPropertyManager();
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
                .fillInLoginField(TestData.login)
                .fillInPasswordField(TestData.password)
                .acceptCookies()
                .clickLogInButtonWithPass()
                .clickNewMessageButton()
                .enterMessageToField(TestData.messageTo)
                .enterMessageSubjectField(TestData.messageSubject)
                .fillInMessageTextArea(TestData.messageText)
                .attachFile(TestData.canonicalAttachmentPath)
                .attachFileAndInsertImageAssertion(TestData.attachFileAssert)
                .clickSendButtonWithPass()
                .messageSentAssertion(TestData.sendEmailWithAttachmentAssert)
                .logOut();
    }
}