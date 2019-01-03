package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class NewMessagePopupPage extends BasePage {

    // *********Constructor*********
    public NewMessagePopupPage(WebDriver driver) {
        super(driver);
    }

    // *********Web Elements*********
    private By messageToInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[1]");
    private By ccInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[2]");
    private By bccInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[3]");
    private By messageSubjectInputBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//input[@placeholder=\"Temat:\"]");
    private By messageTextFrameBy = By.xpath("//iframe[@title]");
    private By sendMessageButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[contains(text(),'Wyślij')]");
    private By attachFileButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[@ng-click='fileUploadClick()']");
    private By closeNewMessagePopupButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//*[@data-tooltip='Zamknij']");
    private By messageSentInfoBy = By.xpath("//*[contains(text(),'Wiadomość wysłana')]");
    private By attachmentsAddedInfoBy = By.xpath("//*[contains(text(),'Załączniki zostały dodane.')]");
    private By errorMessageInfoBy = By.xpath("//div[@class='notification-message']");
    private By messageOptionsButtonBy = By.xpath("(//*[contains(text(),'Napisz z innego')]/../..//*[@data-tooltip = 'Opcje wiadomości'])[last()]");
    private By saveMessageAsADraftButtonBy = By.xpath("(//*[contains(text(),'Napisz z innego')]/../..//*[contains(text(),'Zapisz jako robocze')])[last()]");
    private By messageSavedAsADraftInfoBy = By.xpath("//*[contains(text(),'Wiadomość zapisana w folderze Robocze')]");
    private By minMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Minimalizuj']");
    private By resMinMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Przywróć okno wiadomości']");
    private By maxMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Pełny ekran']");
    private By closeMaxMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Zamknij pełny ekran']");
    private By ccButtonBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//*[text()='DW']");
    private By bccButtonBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//*[text()='UDW']");
    private By boldButtonBy = By.xpath("//button[@data-tooltip='Pogrubienie']");
    private By italicButtonBy = By.xpath("//button[@data-tooltip='Kursywa']");
    private By underlineButtonBy = By.xpath("//button[@data-tooltip='Podkreślenie']");
    private By fontColorButtonBy = By.xpath("//button[@data-tooltip='Kolor tekstu']");
    private By redFontColorButtonBy = By.xpath("//div[@style='background-color: #F90000']");
    private By blackFontColorButtonBy = By.xpath("//div[@style='background-color: #000000']");
    private By styleAndSizeButtonBy = By.xpath("//button[@data-tooltip='Rodzaj i wielkość czcionki']");
    private By georgiaFontBy = By.xpath("//span[text()='Georgia']");
    private By hugeFontBy = By.xpath("//span[text()='Wielki']");
    private By listAndAlignmentTextButtonBy = By.xpath("//button[@data-tooltip='Tworzenie list i wyrównanie tekstu']");
    private By numericListBy = By.xpath("//span[text()='Lista numerowana']");
    private By pointedListBy = By.xpath("//span[text()='Lista punktowa']");
    private By leftAlignmentBy = By.xpath("//span[text()='Do lewej']");
    private By centerAlignmentBy = By.xpath("//span[text()='Do środka']");
    private By rightAlignmentBy = By.xpath("//span[text()='Do prawej']");
    private By mailContentStationeryButtonBy = By.xpath("//button[@data-tooltip='Papeterie']");
    private By mailContentStationeryOptionBy = By.xpath("//img[@src='https://o.iplsc.com/n/st/thumb_56.png']");
    private By mailContentStationeryResetBy = By.xpath("//img[@src='https://o.iplsc.com/n/st/empty.png']");
    private By mailContentInsImgButtonBy = By.xpath("//button[@data-tooltip='Wstaw obrazek']");

    // *********Page Methods*********
    // Enter Message To Input Field
    public NewMessagePopupPage enterMessageToField(String messageTo) {
        writeText(messageToInputBy, messageTo);
        return this;
    }

    // Enter CC Input Field
    public NewMessagePopupPage enterCCInputField(String ccRecipient) {
        writeText(ccInputBy, ccRecipient);
        return this;
    }

    // Enter BCC Input Field
    public NewMessagePopupPage enterBCCInputField(String bccRecipient) {
        writeText(bccInputBy, bccRecipient);
        return this;
    }

    // Enter Message Subject Input Field
    public NewMessagePopupPage enterMessageSubjectField(String messageSubject) {
        writeText(messageSubjectInputBy, messageSubject);
        return this;
    }

    // Enter Message Text Area Field
    public NewMessagePopupPage fillInMessageTextArea(String messageText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//body");
        writeText(messageTextAreaBy, messageText);
        driver.switchTo().defaultContent();
        return this;
    }

    // Click Send Button
    public NewMessagePopupPage clickSendButton() {
        click(sendMessageButtonBy);
        return this;
    }

    // Click Attach File Button
    public NewMessagePopupPage
    clickAttachFileButton(String pathToLocalFile) {
        click(attachFileButtonBy);
        try {
            Thread.sleep(10000);
            StringSelection stringSelection = new StringSelection(pathToLocalFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Thread.sleep(2000);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Problem z załączeniem pliku: " + pathToLocalFile);
        }
        return this;
    }

    // KeyPress Ctrl + A
    public NewMessagePopupPage keyPress_Ctrl_A() {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//body");
        driver.findElement(messageTextAreaBy).sendKeys(Keys.LEFT_CONTROL + "a");
        driver.switchTo().defaultContent();
        return this;
    }

    // Click Close Button
    public InboxPage clickCloseNewMessagePopupButton() {
        click(closeNewMessagePopupButtonBy);
        return new InboxPage(driver);
    }

    // Verify Attachment Added
    public NewMessagePopupPage verifyAttachFile(String expectedText) {
        waitVisibility(attachmentsAddedInfoBy);
        try {
            assertEquals(attachmentsAddedInfoBy, expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify Message Sent
    public NewMessagePopupPage verifyMessageSent(String expectedText) {
        waitVisibility(messageSentInfoBy);
        try {
            assertEquals(messageSentInfoBy, expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify No Recipients Error
    public NewMessagePopupPage verifyNoRecipientsError(String expectedText) {
        waitVisibility(errorMessageInfoBy);
        try {
            assertEquals(errorMessageInfoBy, expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify Message Saved As A Draft
    public NewMessagePopupPage verifyMessageSavedAsADraft(String expectedText) {
        waitVisibility(messageSavedAsADraftInfoBy);
        try {
            assertEquals(messageSavedAsADraftInfoBy, expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Click Message Options Button
    public NewMessagePopupPage clickMessageOptionsButton() {
        click(messageOptionsButtonBy);
        return this;
    }

    // Click Save Message As A Draft Button
    public NewMessagePopupPage clickSaveMessageAsADraftButton() {
        click(saveMessageAsADraftButtonBy);
        return this;
    }

    // Click Min Message Popup Button
    public NewMessagePopupPage clickMinMessagePopupButton() {
        click(minMessagePopupButtonBy);
        return this;
    }

    // Click Max Message Popup Button
    public NewMessagePopupPage clickMaxMessagePopupButton() {
        click(maxMessagePopupButtonBy);
        return this;
    }

    // Click Close Max Message Popup Button
    public NewMessagePopupPage clickCloseMaxMessagePopupButton() {
        click(closeMaxMessagePopupButtonBy);
        return this;
    }

    // Click Res Min Message Popup Button
    public NewMessagePopupPage clickResMinMessagePopupButton() {
        click(resMinMessagePopupButtonBy);
        return this;
    }

    // Click CC Message Button
    public NewMessagePopupPage clickCCButton() {
        click(ccButtonBy);
        return this;
    }

    // Click BCC Message Button
    public NewMessagePopupPage clickBCCButton() {
        click(bccButtonBy);
        return this;
    }

    // Verify Message Popup Is Max
    public NewMessagePopupPage verifyMessagePopupIsMax(String expectedText) {
        waitVisibility(closeMaxMessagePopupButtonBy);
        try {
            Assert.assertEquals(driver.findElement(closeMaxMessagePopupButtonBy).getAttribute("data-tooltip"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify Message Popup Is Min
    public NewMessagePopupPage verifyMessagePopupIsMin(String expectedText) {
        waitVisibility(resMinMessagePopupButtonBy);
        try {
            Assert.assertEquals(driver.findElement(resMinMessagePopupButtonBy).getAttribute("data-tooltip"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify Message Popup Is Res
    public NewMessagePopupPage verifyMessagePopupIsRes(String expectedTextMin, String expectedTextMax) {
        waitVisibility(minMessagePopupButtonBy);
        try {
            Assert.assertEquals(driver.findElement(minMessagePopupButtonBy).getAttribute("data-tooltip"), expectedTextMin);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        waitVisibility(maxMessagePopupButtonBy);
        try {
            Assert.assertEquals(driver.findElement(maxMessagePopupButtonBy).getAttribute("data-tooltip"), expectedTextMax);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Click Bold Button
    public NewMessagePopupPage clickBoldButton() {
        click(boldButtonBy);
        return this;
    }

    // Click Italic Button
    public NewMessagePopupPage clickItalicButton() {
        click(italicButtonBy);
        return this;
    }

    // Click Style And Size Button
    public NewMessagePopupPage clickFontStyleAndSizeButton() {
        click(styleAndSizeButtonBy);
        return this;
    }

    // Click Georgia Font
    public NewMessagePopupPage clickGeorgiaFontStyle() {
        click(georgiaFontBy);
        return this;
    }

    // Click Huge Font
    public NewMessagePopupPage clickHugeFontSize() {
        click(hugeFontBy);
        return this;
    }

    // Click Underline Button
    public NewMessagePopupPage clickUnderlineButton() {
        click(underlineButtonBy);
        return this;
    }

    // Click Font Color Button
    public NewMessagePopupPage clickFontColorButton() {
        click(fontColorButtonBy);
        return this;
    }

    // Click Red Font Color Button
    public NewMessagePopupPage clickRedFontColorButton() {
        click(redFontColorButtonBy);
        return this;
    }

    // Click Black Font Color Button
    public NewMessagePopupPage clickBlackFontColorButton() {
        click(blackFontColorButtonBy);
        return this;
    }

    // Click List And Alignment Text Button
    public NewMessagePopupPage clickListAndAlignTextButton() {
        click(listAndAlignmentTextButtonBy);
        return this;
    }

    // Click Numeric List Option
    public NewMessagePopupPage clickNumericListOption() {
        click(numericListBy);
        return this;
    }

    // Click Point List Option
    public NewMessagePopupPage clickPointListOption() {
        click(pointedListBy);
        return this;
    }

    // Click Left Alignment Option
    public NewMessagePopupPage clickLeftAlignOption() {
        click(leftAlignmentBy);
        return this;
    }

    // Click Center Alignment Option
    public NewMessagePopupPage clickCenterAlignOption() {
        click(centerAlignmentBy);
        return this;
    }

    // Click Right Alignment Option
    public NewMessagePopupPage clickRightAlignOption() {
        click(rightAlignmentBy);
        return this;
    }

    // Click Stationery Button
    public NewMessagePopupPage clickStationeryButton() {
        click(mailContentStationeryButtonBy);
        return this;
    }

    // Click Stationery Option
    public NewMessagePopupPage clickStationeryOption() {
        click(mailContentStationeryOptionBy);
        return this;
    }

    // Click Stationery Reset Option
    public NewMessagePopupPage clickStationeryResetOption() {
        click(mailContentStationeryResetBy);
        return this;
    }

    // Click Message Text Frame
    public NewMessagePopupPage clickMessageTextFrame() {
        click(messageTextFrameBy);
        return this;
    }

    // Click Insert Image Button
    public NewMessagePopupPage clickInsertImageButton(String pathToLocalFile) {
        click(attachFileButtonBy);
        try {
            Thread.sleep(9000);
            StringSelection stringSelection = new StringSelection(pathToLocalFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Thread.sleep(2000);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Problem ze wstawieniem obrazka: " + pathToLocalFile);
        }
        return this;
    }

    // Verify Text Is Bold
    public NewMessagePopupPage verifyBoldFont(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getTagName(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Is Italic
    public NewMessagePopupPage verifyItalicFont(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getTagName(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Font Style
    public NewMessagePopupPage verifyTextFontColorAndStyle(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Font Size
    public NewMessagePopupPage verifyTextFontSize(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Is Underlined
    public NewMessagePopupPage verifyTextIsUnderlined(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Is Colored
    public NewMessagePopupPage verifyTextIsColored(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Numeric List
    public NewMessagePopupPage verifyNumericList(String liExpectedText, String olExpectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaLiBy = By.xpath("//*[contains(text(),'Czcionka')]");
        By messageTextAreaOlBy = By.xpath("//*[contains(text(),'Czcionka')]/..");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaLiBy).getTagName(), liExpectedText);
            Assert.assertEquals(driver.findElement(messageTextAreaOlBy).getTagName(), olExpectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Pointed List
    public NewMessagePopupPage verifyPointedList(String liExpectedText, String ulExpectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaLiBy = By.xpath("//*[contains(text(),'Czcionka')]");
        By messageTextAreaOlBy = By.xpath("//*[contains(text(),'Czcionka')]/..");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaLiBy).getTagName(), liExpectedText);
            Assert.assertEquals(driver.findElement(messageTextAreaOlBy).getTagName(), ulExpectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Left Alignment
    public NewMessagePopupPage verifyTextAlignment(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Stationery Option
    public NewMessagePopupPage verifyStationeryOption(String expectedText) {
        waitVisibility(messageTextFrameBy);
        try {
            driver.switchTo().frame(driver.findElement(messageTextFrameBy));
            Assert.assertEquals(driver.findElement(By.xpath("//body")).getAttribute("class"), expectedText);
            driver.switchTo().defaultContent();
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}