package tests_assertions.new_message_assertions;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class MessageSentAssert extends NewMessagePopupPage{
    public MessageSentAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Message Sent
    public NewMessagePopupPage messageSentAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageSentInfoBy());
        try {
            assertEquals(getMessageSentInfoBy(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
