package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewMessagePopupPage;

public class ResizePopupAS extends NewMessagePopupPage{
    public ResizePopupAS(WebDriver driver) {
        super(driver);
    }

    // Verify Message Popup Is Max
    public NewMessagePopupPage resizePopupMinOrMaxAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getCloseMaxMessagePopupButtonBy());
        try {
            switch(expectedText) {
                case "Zamknij pełny ekran":
                    Assert.assertEquals(driver.findElement(getCloseMaxMessagePopupButtonBy()).getAttribute("data-tooltip"), expectedText);
                    break;
                case "Przywróć okno wiadomości":
                    Assert.assertEquals(driver.findElement(getResMinMessagePopupButtonBy()).getAttribute("data-tooltip"), expectedText);
                    break;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    // Verify Message Popup Is Res
    public NewMessagePopupPage resizePopupResAssertion(String expectedTextMin, String expectedTextMax) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMinMessagePopupButtonBy());
        try {
            Assert.assertEquals(driver.findElement(getMinMessagePopupButtonBy()).getAttribute("data-tooltip"), expectedTextMin);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        waitVisibility(getMaxMessagePopupButtonBy());
        try {
            Assert.assertEquals(driver.findElement(getMaxMessagePopupButtonBy()).getAttribute("data-tooltip"), expectedTextMax);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
