package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ResizeNewMessagePopup extends BaseTest {

    @Test (priority = 1)
    public void resizeNewMessagePopup() {

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
                .clickMaxMessagePopupButton()
                .verifyMessagePopupIsMax("Zamknij pełny ekran")
                .clickCloseMaxMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickMinMessagePopupButton()
                .verifyMessagePopupIsMin("Przywróć okno wiadomości")
                .clickResMinMessagePopupButton()
                .verifyMessagePopupIsRes("Minimalizuj","Pełny ekran")
                .clickMinMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickCloseNewMessagePopupButton();
    }
}