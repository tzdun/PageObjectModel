package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.SendEmailWithoutAttachmentPropertyManager;

public class SendEmailWithoutAttachmentTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SendEmailWithoutAttachmentPropertyManager sendEmailWithoutAttachmentPM = new SendEmailWithoutAttachmentPropertyManager();
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
                .clickNewMessageButton()
                .enterMessageToField(TestData.messageTo)
                .enterMessageSubjectField(TestData.messageSubject)
                .fillInMessageTextArea(TestData.messageText)
                .clickSendButtonWithPass()
                .messageSentAssertion(TestData.sendEmailWithoutAttachmentAssert)
                .logOut();
    }
}