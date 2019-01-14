package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests_assertions.new_message_tests_AS.InsertEmoticonAS;

public class TextFrameWidget extends BasePage {
    public TextFrameWidget(WebDriver driver) {
        super(driver);
    }

    // *********Web Elements*********
    private By messageTextFrameBy = By.xpath("//iframe[@title]");

    // Click Message Text Frame
    public InsertEmoticonAS clickMessageTextFrame() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(getMessageTextFrameBy());
        return new InsertEmoticonAS(driver);
    }

    // Enter Message Text Area Field
    public NewMessagePopupPage fillInMessageTextArea(String messageText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageTextFrameBy());
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaBy = By.xpath("//body");
        writeText(messageTextAreaBy, messageText);
        driver.switchTo().defaultContent();
        return new NewMessagePopupPage(driver);
    }

    public By getMessageTextFrameBy() {
        return messageTextFrameBy;
    }
}
