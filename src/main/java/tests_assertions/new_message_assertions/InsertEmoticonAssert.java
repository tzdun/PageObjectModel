package tests_assertions.new_message_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class InsertEmoticonAssert extends NewMessagePopupPage{
    public InsertEmoticonAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Emoticon Option
    public NewMessagePopupPage insertEmoticonAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageTextFrameBy());
        try {
            driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
            Assert.assertEquals(driver.findElement(By.xpath("//body/img")).getAttribute("src"), expectedText);
            driver.switchTo().defaultContent();
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
