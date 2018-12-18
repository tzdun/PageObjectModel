package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class SaveMessageAsADraft extends BaseTest {

    @Test (priority = 1)
    public void saveMessageAsADraft() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName("login.login")
                .enterPassword("haslo.haslo")
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin("Dodaj inne konta e-mail")
                .clickNewMessageButton()
                .enterMessageToField("login.testowy@int.pl")
                .enterMessageSubjectField("Temat wiadomości")
                .enterMessageTextAreaField("Treść wiadomości")
                .clickAttachFileButton("C:\\Users\\rb26508\\Desktop\\Test\\Test.bmp")
                .verifyAttachementsAdded("Załączniki zostały dodane.")
                .clickMessageOptionsButton()
                .clickSaveMessageAsADraftButton()
                .verifyMessageSavedAsADraft("Wiadomość zapisana w folderze Robocze");
    }
}