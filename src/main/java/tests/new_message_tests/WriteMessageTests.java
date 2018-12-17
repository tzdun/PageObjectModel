package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.InboxPage;
import pages.NewMessagePopupPage;
import tests.BaseTest;

public class WriteMessageTests extends BaseTest {

/*    @Test (priority = 3)
    public void sendEmail_NoRecipientsError () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        InboxPage ip = homePage.goToHomePage()
        		.loginToEmailBox("login.testowy", "haslo.testowe")
        		.acceptCookies()
        		.clickLogInForOK()
        		.verifyValidLogin("Dodaj inne konta e-mail")
        		.clickNewMessageButton();
        try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        		ip.clickSendButton()
        		.verifyNoRecipientsError("Wpisz odbiorców!");



    }*/

    @Test (priority = 4)
    public void sendEmail () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        InboxPage ip = homePage.goToHomePage()
                .enterAccountName("login.login")
                .enterPassword("haslo.haslo")
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin("Dodaj inne konta e-mail");
        for(int i=0; i<10; i++) {

            ip.clickNewMessageButton()
              .enterMessageToField("login.testowy@int.pl")
              .enterMessageSubjectField("T: "+ (i+1))
              .enterMessageTextAreaField("T: " + (i+1))
              .clickAttachFileButton()
              .verifyAttachementsAdded("Załączniki zostały dodane.")
              .clickSendButton()
              .verifyMessageSent("Wiadomość wysłana");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //.clickCloseMessagePopupPageButton();
            System.out.println("T: " + (i+1));
        }
    }
}