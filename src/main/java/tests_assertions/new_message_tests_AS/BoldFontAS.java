package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class BoldFontAS extends NewMessagePopupPage{
    public BoldFontAS(WebDriver driver) {
        super(driver);
    }

    // Bold Font Assertion
    public BoldFontAS boldFontAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clickMessageTextFrame();
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaBy = By.xpath("//*[contains(text(),'Czcionka')]");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaBy).getTagName(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        clickMessageTextFrame();
        return this;
    }

    // Verify Bold Button Is Pressed
    public NewMessagePopupPage boldFontButtonPressedAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            Assert.assertEquals(driver.findElement(getBoldButtonBy()).getAttribute("aria-pressed"), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
