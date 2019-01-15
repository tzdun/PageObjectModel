package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.SendCcAndBccCopyPropertyManager;

public class SendCcAndBccCopyTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SendCcAndBccCopyPropertyManager sendCcAndBccEmailPM = new SendCcAndBccCopyPropertyManager();
        private static String messageTo = sendCcAndBccEmailPM.getMessageTo();
        private static String ccMessageTo = sendCcAndBccEmailPM.getCcMessageTo();
        private static String bccMessageTo = sendCcAndBccEmailPM.getBccMessageTo();
        private static String messageSubject = sendCcAndBccEmailPM.getMessageSubject();
        private static String messageText = sendCcAndBccEmailPM.getMessageText();
        private static String canonicalAttachmentPath = sendCcAndBccEmailPM.getCanonicalAttachmentPath();
        private static String attachFileAssert = sendCcAndBccEmailPM.getAttachFileAssert();
        private static String sendCcAndBccCopyAssert = sendCcAndBccEmailPM.getSendCcAndBccCopyAssert();
    }

    @Test(priority = 1)
    public void sendCcAndBccEmail() {

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
                .clickCCButton()
                .enterCCInputField(TestData.ccMessageTo)
                .clickBCCButton()
                .enterBCCInputField(TestData.bccMessageTo)
                .enterMessageSubjectField(TestData.messageSubject)
                .fillInMessageTextArea(TestData.messageText)
                .attachFile(TestData.canonicalAttachmentPath)
                .attachFileAndInsertImageAssertion(TestData.attachFileAssert)
                .clickSendButtonWithPass()
                .messageSentAssertion(TestData.sendCcAndBccCopyAssert)
                .logOut();
    }
}