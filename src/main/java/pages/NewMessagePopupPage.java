package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private By messageSubjectInputBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//input[@placeholder=\"Temat:\"]");
    private By messageTextFrameBy = By.xpath("//iframe[@title]");
    private By sendMessageButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[contains(text(),'Wyślij')]");
    private By attachFileButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[@ng-click='fileUploadClick()']");
    private By closeMessagePopupPageButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//*[@data-tooltip='Zamknij']");
    private By messageSentBy = By.xpath("//*[contains(text(),'Wiadomość wysłana')]");
    private By attachmentsAddedBy = By.xpath("//*[contains(text(),'Załączniki zostały dodane.')]");
    private By errorMessageBy = By.xpath("//div[@class='notification-message']");

    // *********Page Methods*********
    // Enter Message To Input Field
    public NewMessagePopupPage enterMessageToField(String messageTo) {
        writeText(messageToInputBy, messageTo);
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
    public NewMessagePopupPage clickAttachFileButton() {
        click(attachFileButtonBy);
        StringSelection ss = new StringSelection("C:\\Users\\rb26508\\Desktop\\Test\\Test.bmp");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        // native key strokes for CTRL, V and ENTER keys
        try {
            Thread.sleep(1000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            System.out.println("Problem z robotem.");
        }

        return this;
    }

    // Click Close Button
    public InboxPage clickCloseMessagePopupPageButton() {
        click(closeMessagePopupPageButtonBy);
        return new InboxPage(driver);
    }

    // Verify Attachment Added
    public NewMessagePopupPage verifyAttachementsAdded(String expectedText) {
        waitVisibility(attachmentsAddedBy);
        assertEquals(attachmentsAddedBy, expectedText);
        return this;
    }

    // Verify Message Sent
    public NewMessagePopupPage verifyMessageSent(String expectedText) {
        waitVisibility(messageSentBy);
        assertEquals(messageSentBy, expectedText);
        return this;
    }

    // Verify No Recipients Error
    public NewMessagePopupPage verifyNoRecipientsError(String expectedText) {
        waitVisibility(errorMessageBy);
        assertEquals(errorMessageBy, expectedText);

        return this;
    }
}