package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class FontSize extends BaseTestTC {

    @Test (priority = 1)
    public void fontSize() {

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
                .clickHugeFontSize()
                .clickMessageTextFrame()
                .verifyTextFontSize("font-size: 18pt;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .clickMessageTextFrame()
                .logOut();
    }
}