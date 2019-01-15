package tests_assertions.new_message_assertions;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class SendEmailWithoutRecipientAssert extends NewMessagePopupPage{
    public SendEmailWithoutRecipientAssert(WebDriver driver) {
        super(driver);
    }

    // Verify No Recipients Error
    public NewMessagePopupPage sendEmailWithoutRecipientAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getErrorMessageInfoBy());
        try {
            assertEquals(getErrorMessageInfoBy(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
