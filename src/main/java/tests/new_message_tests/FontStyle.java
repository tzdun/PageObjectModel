package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class FontStyle extends BaseTest {

    @Test (priority = 1)
    public void fontStyle() {

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
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .verifyTextFontStyle("font-family: georgia, palatino;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .clickMessageTextFrame()
                .logOut();
    }
}