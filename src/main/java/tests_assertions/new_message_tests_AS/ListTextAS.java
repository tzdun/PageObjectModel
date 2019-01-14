package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class ListTextAS extends NewMessagePopupPage{
    public ListTextAS(WebDriver driver) {
        super(driver);
    }

    // Verify Numeric List
    public NewMessagePopupPage verifyNumericList(String liExpectedText, String olExpectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clickMessageTextFrame();
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaLiBy = By.xpath("//*[contains(text(),'Czcionka')]");
        By messageTextAreaOlBy = By.xpath("//*[contains(text(),'Czcionka')]/..");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaLiBy).getTagName(), liExpectedText);
            Assert.assertEquals(driver.findElement(messageTextAreaOlBy).getTagName(), olExpectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        clickMessageTextFrame();
        return this;
    }

    // Verify Pointed List
    public NewMessagePopupPage verifyPointedList(String liExpectedText, String ulExpectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        clickMessageTextFrame();
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaLiBy = By.xpath("//*[contains(text(),'Czcionka')]");
        By messageTextAreaOlBy = By.xpath("//*[contains(text(),'Czcionka')]/..");
        try {
            Assert.assertEquals(driver.findElement(messageTextAreaLiBy).getTagName(), liExpectedText);
            Assert.assertEquals(driver.findElement(messageTextAreaOlBy).getTagName(), ulExpectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        driver.switchTo().defaultContent();
        clickMessageTextFrame();
        return this;
    }

}
