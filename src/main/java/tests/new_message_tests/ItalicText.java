package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ItalicText extends BaseTest {

    @Test (priority = 1)
    public void italicText() {

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
                .clickItalicButton()
                .clickMessageTextFrame()
                .verifyTextIsItalic("em")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .clickMessageTextFrame()
                .logOut();
    }
}