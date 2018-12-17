package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.InboxPage;
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
                .loginToEmailBox("login.testowy", "haslo.testowe")
                .acceptCookies()
                .clickLogInForOK()
                .verifyValidLogin("Dodaj inne konta e-mail");
        for(int i=0; i<1000000; i++) {

            ip.sendNewEmail("login.testowy@int.pl", "T: "+ (i+1), "T: " + (i+1));
            //.verifyMessageSent("Wiadomość wysłana");
            System.out.println("T: " + (i+1));
        }

    }
}