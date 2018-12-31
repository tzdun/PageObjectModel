package tests.new_message_tests_TC;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class ResizeNewMessagePopup extends BaseTestTC {

    private String accountName = "login.login";
    private String password = "haslo.haslo";
    private String validLogin = "Dodaj inne konta e-mail";
    private String popupIsMax = "Zamknij pełny ekran";
    private String popupIsMin = "Przywróć okno wiadomości";
    private String popupIsResMin = "Minimalizuj";
    private String popupIsResMax = "Pełny ekran";

    @Test (priority = 1)
    public void resizeNewMessagePopup() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(accountName)
                .enterPassword(password)
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(validLogin)
                .clickNewMessageButton()
                .clickMaxMessagePopupButton()
                .verifyMessagePopupIsMax(popupIsMax)
                .clickCloseMaxMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickMinMessagePopupButton()
                .verifyMessagePopupIsMin(popupIsMin)
                .clickResMinMessagePopupButton()
                .verifyMessagePopupIsRes(popupIsResMin,popupIsResMax)
                .clickMinMessagePopupButton()
                .clickMaxMessagePopupButton()
                .clickCloseNewMessagePopupButton()
                .logOut();
    }
}