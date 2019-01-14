package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class UnderlineFontAS extends NewMessagePopupPage{
    public UnderlineFontAS(WebDriver driver) {
        super(driver);
    }

    // Verify Text Is Underlined
    public NewMessagePopupPage underlineFontAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clickMessageTextFrame();
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        clickMessageTextFrame();
        return this;
    }
}
