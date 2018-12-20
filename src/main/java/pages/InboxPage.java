package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
        try {
            Assert.assertEquals(validLoginBy, expectedText);
        } catch (AssertionError e) {
            new PrintScreen(e, driver);
        }
        return this;
    }
}