package tests_assertions.new_message_tests_AS;

import org.openqa.selenium.WebDriver;
import pages.NewMessagePopupPage;

public class InsertImageAS extends NewMessagePopupPage {
    public InsertImageAS(WebDriver driver) {
        super(driver);
    }

    // Verify Attach File
    public NewMessagePopupPage verifyAttachFile(String expectedText) {
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
