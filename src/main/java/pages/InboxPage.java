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
    private By validLoginBy = By.xpath("//span[@class='icon-add']");
    private By newEmailBy = By.xpath("//a[contains(.,'Nowa')]");

    // *********Page Methods*********
    // Click New Message
    public NewMessagePopupPage clickNewMessageButton() {
        click(newEmailBy);
        return new NewMessagePopupPage(driver);
    }

    // Verify Valid Login
    public InboxPage verifyValidLogin(String expectedText) {
        assertEquals(validLoginBy, expectedText);
        return this;
    }
}