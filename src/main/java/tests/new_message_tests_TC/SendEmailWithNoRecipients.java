package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class SendEmailWithNoRecipients extends BaseTestTC {

    @Test (priority = 1)
    public void sendEmailWithNoRecipients () {

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
                .clickSendButton()
                .verifyNoRecipientsError("Wpisz odbiorców!")
                .logOut();
    }
}