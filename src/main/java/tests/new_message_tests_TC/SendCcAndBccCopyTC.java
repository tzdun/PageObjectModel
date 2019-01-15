package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.SendCcAndBccCopyPM;

public class SendCcAndBccCopyTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SendCcAndBccCopyPM sendCcAndBccEmailPM = new SendCcAndBccCopyPM();
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