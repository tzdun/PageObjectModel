package tests_assertions.login_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.InboxPage;

public class ValidLoginAndPasswordAS extends InboxPage {
    public ValidLoginAndPasswordAS(WebDriver driver) {
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
