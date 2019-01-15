package tests_assertions.new_message_assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class TextStationeryAssert extends NewMessagePopupPage{
    public TextStationeryAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Stationery Option
    public NewMessagePopupPage textStationeryAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageTextFrameBy());
        try {
            driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
            Assert.assertEquals(driver.findElement(By.xpath("//body")).getAttribute("class"), expectedText);
            driver.switchTo().defaultContent();
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
