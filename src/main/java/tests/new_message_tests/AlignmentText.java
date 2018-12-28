package tests.new_message_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;

public class AlignmentText extends BaseTestTC {

    @Test (priority = 1)
    public void alignmentText() {

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
                .clickLeftAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment("text-align: left;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickLeftAlignmentOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickCenterAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment("text-align: center;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickCenterAlignmentOption()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickRightAlignmentOption()
                .clickMessageTextFrame()
                .verifyTextAlignment("text-align: right;")
                .clickMessageTextFrame()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickRightAlignmentOption()
                .clickMessageTextFrame()
                .logOut();
    }
}