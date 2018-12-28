package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class SendEmailWithCCandBCC extends BaseTestTC {

    @Test(priority = 1)
    public void sendEmailWithCCandBCC() {

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
                .clickCCButton()
                .enterCCInputField("login.testowy@int.pl")
                .clickBCCButton()
                .enterBCCInputField("login.testowy@int.pl")
                .enterMessageSubjectField("Temat wiadomości")
                .enterMessageTextAreaField("Treść wiadomości")
                .clickAttachFileButton("C:\\Users\\rb26508\\Desktop\\Test\\Test.bmp")
                .verifyAttachmentsAdded("Załączniki zostały dodane.")
                .clickSendButton()
                .verifyMessageSent("Wiadomość wysłana")
                .logOut();
    }
}