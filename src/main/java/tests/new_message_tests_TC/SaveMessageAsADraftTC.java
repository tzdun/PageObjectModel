package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.login_tests_PM.ValidLoginAndPasswordPM;
import tests_property_managers.new_message_tests_PM.SaveMessageAsADraftPM;

public class SaveMessageAsADraftTC extends BaseTestTC {
    private static class TestData {
        private static ValidLoginAndPasswordPM validLoginAndPasswordPM = new ValidLoginAndPasswordPM();
        private static String login = validLoginAndPasswordPM.getLogin();
        private static String password = validLoginAndPasswordPM.getPassword();
        private static String validLoginAndPasswordAssert = validLoginAndPasswordPM.getValidLoginAndPasswordAssert();
        private static SaveMessageAsADraftPM saveMessageAsADraftPM = new SaveMessageAsADraftPM();
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
                .clickMessageOptionsButton()
                .clickSaveMessageAsADraftButton()
                .verifyMessageSavedAsADraft(TestData.saveMessageAsADraftAssert)
                .logOut();
    }
}