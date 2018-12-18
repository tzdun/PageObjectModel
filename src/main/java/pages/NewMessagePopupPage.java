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
    public NewMessagePopupPage enterMessageTextAreaField(String messageText) {
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
    public NewMessagePopupPage clickAttachFileButton(String pathToLocalFile) {
        click(attachFileButtonBy);
        StringSelection stringSelection = new StringSelection(pathToLocalFile);
        try {
            Thread.sleep(8000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            // native key strokes for CTRL, V and ENTER keys
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
    public NewMessagePopupPage verifyAttachmentsAdded(String expectedText) {
        waitVisibility(attachmentsAddedInfoBy);
        assertEquals(attachmentsAddedInfoBy, expectedText);
        return this;
    }

    // Verify Message Sent
    public NewMessagePopupPage verifyMessageSent(String expectedText) {
        waitVisibility(messageSentInfoBy);
        assertEquals(messageSentInfoBy, expectedText);
        return this;
    }

    // Verify No Recipients Error
    public NewMessagePopupPage verifyNoRecipientsError(String expectedText) {
        waitVisibility(errorMessageInfoBy);
        assertEquals(errorMessageInfoBy, expectedText);

        return this;
    }

    // Verify Message Saved As A Draft
    public NewMessagePopupPage verifyMessageSavedAsADraft(String expectedText) {
        waitVisibility(messageSavedAsADraftInfoBy);
        assertEquals(messageSavedAsADraftInfoBy, expectedText);
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
        Assert.assertEquals(driver.findElement(closeMaxMessagePopupButtonBy).getAttribute("data-tooltip"), expectedText);
        return this;
    }

    // Verify Message Popup Is Min
    public NewMessagePopupPage verifyMessagePopupIsMin(String expectedText) {
        waitVisibility(resMinMessagePopupButtonBy);
        Assert.assertEquals(driver.findElement(resMinMessagePopupButtonBy).getAttribute("data-tooltip"), expectedText);
        return this;
    }

    // Verify Message Popup Is Res
    public NewMessagePopupPage verifyMessagePopupIsRes(String expectedTextMin, String expectedTextMax) {
        waitVisibility(minMessagePopupButtonBy);
        Assert.assertEquals(driver.findElement(minMessagePopupButtonBy).getAttribute("data-tooltip"), expectedTextMin);
        waitVisibility(maxMessagePopupButtonBy);
        Assert.assertEquals(driver.findElement(maxMessagePopupButtonBy).getAttribute("data-tooltip"), expectedTextMax);
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

    // Verify Text Is Bold
    public NewMessagePopupPage verifyTextIsBold(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        Assert.assertEquals(driver.findElement(messageTextAreaBy).getTagName(), expectedText);
        driver.switchTo().defaultContent();
        return this;
    }

    // Verify Text Is Italic
    public NewMessagePopupPage verifyTextIsItalic(String expectedText) {
        waitVisibility(messageTextFrameBy);
        driver.switchTo().frame(driver.findElement(messageTextFrameBy));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        Assert.assertEquals(driver.findElement(messageTextAreaBy).getTagName(), expectedText);
        driver.switchTo().defaultContent();
        return this;
    }
}