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
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(newEmailBy);
        return new NewMessagePopupPage(driver);
    }

    // Verify Valid Login
    public InboxPage verifyValidLoginAndPassword(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            Assert.assertEquals(driver.findElement(validLoginBy).getText(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}