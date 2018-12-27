package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class AttachFile extends BaseTest {

    @Test (priority = 1)
    public void attachFile() {

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
                .clickAttachFileButton("C:\\Users\\rb26508\\Desktop\\Test\\Test.bmp")
                .verifyAttachmentsAdded("Załączniki zostały dodane.")
                .logOut();
    }
}