package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class TextStyle extends BaseTest {

    @Test (priority = 1)
    public void textStyle() {

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
                .enterMessageTextAreaField("Czcionka")
                .keyPress_Ctrl_A()
                .clickBoldButton()
                .verifyTextIsBold("strong")
                .clickBoldButton()
                .clickItalicButton()
                .keyPress_Ctrl_A()
                .verifyTextIsItalic("em");
    }
}