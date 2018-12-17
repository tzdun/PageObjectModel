package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class InboxPage extends BasePage {

    // *********Constructor*********
    public InboxPage(WebDriver driver) {
        super(driver);
    }

    // *********Web Elements*********
    By validLoginBy = By.xpath("//span[@class='icon-add']");
    By errorMessageBy = By.xpath("//div[@class='notification-message']");
    By newEmailBy = By.xpath("//a[contains(.,'Nowa')]");
    By emailToBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[1]");
    By subjectBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//input[@placeholder=\"Temat:\"]");
    By frameBy = By.xpath("//iframe[@title]");
    By sendButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[contains(text(),'Wyślij')]");
    By messageSentBy = By.xpath("//*[contains(text(),'Wiadomość wysłana')]");
    By notificationMessageBy = By.xpath("//*[@class='notification-message']");
    By closeButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//*[@data-tooltip='Zamknij']");
    By attachementButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[@ng-click='fileUploadClick()']");
    By attachementsAddedBy = By.xpath("//*[contains(text(),'Załączniki zostały dodane.')]");

    // *********Page Methods*********
    public InboxPage sendNewEmail(String emailTo, String subject, String text) {
        try {
            // Click New Message
            click(newEmailBy);
            // Enter Email To
            writeText(emailToBy, emailTo);

            // Enter Subject
            writeText(subjectBy, subject);
            // Enter Text
            waitVisibility(frameBy);
            driver.switchTo().frame(driver.findElement(frameBy));
            By textBy = By.xpath("//body");
            writeText(textBy, text);
            driver.switchTo().defaultContent();
            addAttachement();
            waitVisibility(attachementsAddedBy);
            waitVisibility(sendButtonBy);
            click(sendButtonBy);
            waitVisibility(closeButtonBy);
            click(closeButtonBy);
            // waitVisibility(messageSentBy);
        } catch (Exception e) {
            System.out.println("Error z metody sendNewEmail: " + e);
        }

        return this;
    }

    // Click New Message
    public InboxPage clickNewMessageButton() {
        click(newEmailBy);
        return this;
    }

    // Click Send Button
    public InboxPage clickSendButton() {
        click(sendButtonBy);

        return this;
    }

    // Click Attachement Button
    public InboxPage addAttachement() {
        waitVisibility(attachementButtonBy);
        click(attachementButtonBy);
	/*	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        StringSelection ss = new StringSelection("C:\\Users\\rb26508\\Desktop\\Test\\Test.bmp");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // native key strokes for CTRL, V and ENTER keys
        try {
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

    // Verify Valid Login
    public InboxPage verifyValidLogin(String expectedText) {
        assertEquals(validLoginBy, expectedText);

        return this;
    }

    // Verify No Recipients Error
    public InboxPage verifyNoRecipientsError(String expectedText) {
        waitVisibility(errorMessageBy);
        assertEquals(errorMessageBy, expectedText);

        return this;
    }

    // Verify Message Sent
    public InboxPage verifyMessageSent(String expectedText) {
        waitVisibility(notificationMessageBy);
        assertEquals(messageSentBy, expectedText);

        return this;
    }

}