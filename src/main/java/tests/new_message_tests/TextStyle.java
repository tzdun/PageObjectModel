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
                .keyPress_Ctrl_A()
                .clickBoldButton()
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .verifyTextIsItalic("em")
                .keyPress_Ctrl_A()
                .clickItalicButton()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .verifyTextFontStyle("font-family: georgia, palatino;")
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickGeorgiaFontStyle()
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .verifyTextFontSize("font-size: 18pt;")
                .keyPress_Ctrl_A()
                .clickFontStyleAndSizeButton()
                .clickHugeFontSize()
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .verifyTextIsUnderlined("text-decoration: underline;")
                .keyPress_Ctrl_A()
                .clickUnderlineButton()
                .keyPress_Ctrl_A()
                .clickFontColorButton()
                .clickRedFontColorButton()
                .verifyTextFontStyle("color: rgb(249, 0, 0);")
                .keyPress_Ctrl_A()
                .clickFontColorButton()
                .clickBlackFontColorButton()
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickNumericListOption()
                .verifyNumericList("li","ol")
                .keyPress_Ctrl_A()
                .clickListAndAlignmentTextButton()
                .clickNumericListOption();
    }
}