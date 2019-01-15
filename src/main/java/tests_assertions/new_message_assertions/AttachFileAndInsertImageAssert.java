package tests_assertions.new_message_assertions;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class AttachFileAndInsertImageAssert extends NewMessagePopupPage {
    public AttachFileAndInsertImageAssert(WebDriver driver) {
        super(driver);
    }

    // Verify Attach File
    public NewMessagePopupPage attachFileAndInsertImageAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getAttachmentsAddedInfoBy());
        try {
            assertEquals(getAttachmentsAddedInfoBy(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
