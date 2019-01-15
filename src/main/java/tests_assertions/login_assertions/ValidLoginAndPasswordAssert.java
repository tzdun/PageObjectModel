package tests_assertions.login_assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InboxPage;

public class ValidLoginAndPasswordAssert extends InboxPage {
    public ValidLoginAndPasswordAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Valid Login
    public InboxPage validLoginAndPasswordAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            Assert.assertEquals(driver.findElement(getValidLoginBy()).getText(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
