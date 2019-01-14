package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class MessageSentAS extends NewMessagePopupPage{
    public MessageSentAS(WebDriver driver) {
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
