package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public By getValidLoginBy() {
        return validLoginBy;
    }

    public By getNewEmailBy() {
        return newEmailBy;
    }
}