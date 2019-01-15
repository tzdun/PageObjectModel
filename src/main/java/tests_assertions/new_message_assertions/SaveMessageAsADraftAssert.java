package tests_assertions.new_message_assertions;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class SaveMessageAsADraftAssert extends NewMessagePopupPage{
    public SaveMessageAsADraftAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Message Saved As A Draft
    public NewMessagePopupPage saveMessageAsADraftAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageSavedAsADraftInfoBy());
        try {
            assertEquals(getMessageSavedAsADraftInfoBy(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
