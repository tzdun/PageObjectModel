package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;
import tests_property_managers.login_property_managers.ValidLoginAndPasswordPropertyManager;
import tests_property_managers.new_message_property_managers.SaveMessageAsADraftPropertyManager;

public class SaveMessageAsADraftTest extends BaseTest {
    private static class TestData {
        private static ValidLoginAndPasswordPropertyManager validLoginAndPasswordPM = new ValidLoginAndPasswordPropertyManager();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static SaveMessageAsADraftPropertyManager saveMessageAsADraftPM = new SaveMessageAsADraftPropertyManager();
        private static String messageTo = saveMessageAsADraftPM.getMessageTo();
        private static String messageSubject = saveMessageAsADraftPM.getMessageSubject();
        private static String messageText = saveMessageAsADraftPM.getMessageText();
        private static String canonicalAttachmentPath = saveMessageAsADraftPM.getCanonicalAttachmentPath();
        private static String attachFileAssert = saveMessageAsADraftPM.getAttachFileAssert();
        private static String saveMessageAsADraftAssert = saveMessageAsADraftPM.getSaveMessageAsADraftAssert();
    }

    @Test(priority = 1)
    public void saveMessageAsADraft() {

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
                .clickMessageOptionsButton()
                .clickSaveMessageAsADraftButton()
                .saveMessageAsADraftAssertion(TestData.saveMessageAsADraftAssert)
                .logOut();
    }
}