package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ListText extends BaseTest {

    @Test (priority = 1)
    public void listText() {

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
                .clickListAndAlignmentTextButton()
                .clickNumericListOption()
                .clickMessageTextFrame()
                .verifyNumericList("li","ol")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickNumericListOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickPointListOption()
                .clickMessageTextFrame()
                .verifyPointedList("li","ul")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickPointListOption()
                .clickMessageTextFrame()
                .logOut();

    }
}