package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class UnderlineText extends BaseTest {

    @Test (priority = 1)
    public void underlineText() {

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
                .enterMessageTextAreaField("Czcionka")
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .clickMessageTextFrame()
                .verifyTextIsUnderlined("text-decoration: underline;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .clickMessageTextFrame()
                .logOut();
    }
}