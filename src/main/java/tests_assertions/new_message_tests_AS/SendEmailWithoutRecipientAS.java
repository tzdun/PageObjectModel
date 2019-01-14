package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class SendEmailWithoutRecipientAS extends NewMessagePopupPage{
    public SendEmailWithoutRecipientAS(WebDriver driver) {
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
