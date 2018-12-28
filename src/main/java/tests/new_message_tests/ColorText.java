package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class ColorText extends BaseTestTC {

    @Test (priority = 1)
    public void colorText() {

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
                .clickFontColorButton()
                .clickRedFontColorButton()
                .clickMessageTextFrame()
                .verifyTextFontStyle("color: rgb(249, 0, 0);")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontColorButton()
                .clickBlackFontColorButton()
                .clickMessageTextFrame()
                .logOut();
    }
}