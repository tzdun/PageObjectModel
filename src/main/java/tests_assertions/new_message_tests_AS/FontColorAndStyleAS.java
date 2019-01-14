package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class FontColorAndStyleAS extends NewMessagePopupPage{
    public FontColorAndStyleAS(WebDriver driver) {
        super(driver);
    }

    // Verify Font Color And Style
    public FontColorAndStyleAS fontColorAndStyleAssertion(String expectedText) {
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

    // Verify Font Button Color
    public NewMessagePopupPage fontButtonColorAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            Assert.assertEquals(driver.findElement(getFontColorButtonBy()).getAttribute("style"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
