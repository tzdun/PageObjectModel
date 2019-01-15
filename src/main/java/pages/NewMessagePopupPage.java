package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tests_assertions.new_message_assertions.*;

public class NewMessagePopupPage extends BasePage {

    //region *********Constructor*********
    public NewMessagePopupPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region *********Web Elements*********
    private By messageToInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[1]");
    private By ccInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[2]");
    private By bccInputBy = By.xpath("(//*[contains(text(),'Nowa wiadomość')]/../..//input)[3]");
    private By messageSubjectInputBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//input[@placeholder=\"Temat:\"]");
    private By sendMessageButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//button[contains(text(),'Wyślij')]");
    private By uploadFileBy = By.xpath("//div[@ng-if='uploader']/input[@options='{url: uploadUrl}']");
    private By uploadImageBy = By.xpath("//div[@ng-if='uploader']/input[@options='{isInline: true, url: inlineUploadUrl}']");
    private By closeNewMessagePopupButtonBy = By.xpath("//*[@nxt-title='Nowa wiadomość']//*[@data-tooltip='Zamknij']");
    private By messageSentInfoBy = By.xpath("//*[contains(text(),'Wiadomość wysłana')]");
    private By attachmentsAddedInfoBy = By.xpath("//*[contains(text(),'Załączniki zostały dodane.')]");
    private By errorMessageInfoBy = By.xpath("//div[@class='notification-message']");
    private By messageOptionsButtonBy = By.xpath("(//*[contains(text(),'Napisz z innego')]/../..//*[@data-tooltip = 'Opcje wiadomości'])[last()]");
    private By saveMessageAsADraftButtonBy = By.xpath("(//*[contains(text(),'Napisz z innego')]/../..//*[contains(text(),'Zapisz jako robocze')])[last()]");
    private By messageSavedAsADraftInfoBy = By.xpath("//*[contains(text(),'Wiadomość zapisana w folderze Robocze')]");
    private By minMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Minimalizuj']");
    private By resMinMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Przywróć okno wiadomości']");
    private By maxMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Pełny ekran']");
    private By closeMaxMessagePopupButtonBy = By.xpath("//*[@data-tooltip='Zamknij pełny ekran']");
    private By ccButtonBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//*[text()='DW']");
    private By bccButtonBy = By.xpath("//*[contains(text(),'Nowa wiadomość')]/../..//*[text()='UDW']");
    private By boldButtonBy = By.xpath("//button[@data-tooltip='Pogrubienie']/..");
    private By italicButtonBy = By.xpath("//button[@data-tooltip='Kursywa']");
    private By underlineButtonBy = By.xpath("//button[@data-tooltip='Podkreślenie']");
    private By fontColorButtonBy = By.xpath("//button[@data-tooltip='Kolor tekstu']/i");
    private By redFontColorButtonBy = By.xpath("//div[@style='background-color: #F90000']");
    private By blackFontColorButtonBy = By.xpath("//div[@style='background-color: #000000']");
    private By styleAndSizeButtonBy = By.xpath("//button[@data-tooltip='Rodzaj i wielkość czcionki']");
    private By georgiaFontBy = By.xpath("//span[text()='Georgia']");
    private By hugeFontBy = By.xpath("//span[text()='Wielki']");
    private By listAndAlignmentTextButtonBy = By.xpath("//button[@data-tooltip='Tworzenie list i wyrównanie tekstu']");
    private By numericListBy = By.xpath("//span[text()='Lista numerowana']");
    private By pointedListBy = By.xpath("//span[text()='Lista punktowa']");
    private By leftAlignmentBy = By.xpath("//span[text()='Do lewej']");
    private By centerAlignmentBy = By.xpath("//span[text()='Do środka']");
    private By rightAlignmentBy = By.xpath("//span[text()='Do prawej']");
    private By mailContentStationeryButtonBy = By.xpath("//button[@data-tooltip='Papeterie']");
    private By mailContentStationeryOptionBy = By.xpath("//img[@src='https://o.iplsc.com/n/st/thumb_56.png']");
    private By mailContentStationeryResetBy = By.xpath("//img[@src='https://o.iplsc.com/n/st/empty.png']");
    private By emoticonButtonBy = By.xpath("//button[@data-tooltip='Wstaw emotikonę']");
    private By emoticonOptionBy = By.xpath("//img[@src='https://o.iplsc.com/n/js/tinymce/plugins/emoticons/img/smiley-cool.gif']");
    private By messageTextFrameBy = By.xpath("//iframe[@title]");
    //endregion

    //region *********Getters*********
    public By getMessageTextFrameBy() {
        return messageTextFrameBy;
    }

    public By getMessageSentInfoBy() {
        return messageSentInfoBy;
    }

    public By getAttachmentsAddedInfoBy() {
        return attachmentsAddedInfoBy;
    }

    public By getErrorMessageInfoBy() {
        return errorMessageInfoBy;
    }

    public By getMessageSavedAsADraftInfoBy() {
        return messageSavedAsADraftInfoBy;
    }

    public By getMinMessagePopupButtonBy() {
        return minMessagePopupButtonBy;
    }

    public By getResMinMessagePopupButtonBy() {
        return resMinMessagePopupButtonBy;
    }

    public By getMaxMessagePopupButtonBy() {
        return maxMessagePopupButtonBy;
    }

    public By getCloseMaxMessagePopupButtonBy() {
        return closeMaxMessagePopupButtonBy;
    }

    public By getBoldButtonBy() {
        return boldButtonBy;
    }

    public By getFontColorButtonBy() {
        return fontColorButtonBy;
    }
    //endregion

    //region *********Page Methods*********
    // Click Message Text Frame
    public InsertEmoticonAssert clickMessageTextFrame() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(getMessageTextFrameBy());
        return new InsertEmoticonAssert(driver);
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

    // Enter Message To Input Field
    public NewMessagePopupPage enterMessageToField(String messageTo) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        writeText(messageToInputBy, messageTo);
        return this;
    }

    // Enter CC Input Field
    public NewMessagePopupPage enterCCInputField(String ccRecipient) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        writeText(ccInputBy, ccRecipient);
        return this;
    }

    // Enter BCC Input Field
    public NewMessagePopupPage enterBCCInputField(String bccRecipient) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        writeText(bccInputBy, bccRecipient);
        return this;
    }

    // Enter Message Subject Input Field
    public NewMessagePopupPage enterMessageSubjectField(String messageSubject) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        writeText(messageSubjectInputBy, messageSubject);
        return this;
    }

    // Click Send Button With Pass
    public MessageSentAssert clickSendButtonWithPass() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(sendMessageButtonBy);
        return new MessageSentAssert(driver);
    }

    // Click Send Button With Fail
    public SendEmailWithoutRecipientAssert clickSendButtonWithFail() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(sendMessageButtonBy);
        return new SendEmailWithoutRecipientAssert(driver);
    }

    // Attach File
    public AttachFileAndInsertImageAssert
    attachFile(String pathToLocalFile) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(uploadFileBy);
        driver.findElement(uploadFileBy).sendKeys(pathToLocalFile);
        return new AttachFileAndInsertImageAssert(driver);
    }

    // KeyPress Ctrl + A
    public NewMessagePopupPage keyPress_Ctrl_A() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getMessageTextFrameBy());
        driver.switchTo().frame(driver.findElement(getMessageTextFrameBy()));
        By messageTextAreaBy = By.xpath("//body");
        driver.findElement(messageTextAreaBy).sendKeys(Keys.LEFT_CONTROL + "a");
        driver.switchTo().defaultContent();
        return this;
    }

    // Click Close Button
    public InboxPage clickCloseNewMessagePopupButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(closeNewMessagePopupButtonBy);
        return new InboxPage(driver);
    }

    // Click Message Options Button
    public NewMessagePopupPage clickMessageOptionsButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(messageOptionsButtonBy);
        return this;
    }

    // Click Save Message As A Draft Button
    public SaveMessageAsADraftAssert clickSaveMessageAsADraftButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(saveMessageAsADraftButtonBy);
        return new SaveMessageAsADraftAssert(driver);
    }

    // Click Min Message Popup Button
    public ResizePopupAssert clickMinMessagePopupButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(minMessagePopupButtonBy);
        return new ResizePopupAssert(driver);
    }

    // Click Max Message Popup Button
    public ResizePopupAssert clickMaxMessagePopupButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(maxMessagePopupButtonBy);
        return new ResizePopupAssert(driver);
    }

    // Click Close Max Message Popup Button
    public NewMessagePopupPage clickCloseMaxMessagePopupButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(closeMaxMessagePopupButtonBy);
        return this;
    }

    // Click Res Min Message Popup Button
    public ResizePopupAssert clickResMinMessagePopupButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(resMinMessagePopupButtonBy);
        return new ResizePopupAssert(driver);
    }

    // Click CC Message Button
    public NewMessagePopupPage clickCCButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(ccButtonBy);
        return this;
    }

    // Click BCC Message Button
    public NewMessagePopupPage clickBCCButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(bccButtonBy);
        return this;
    }


    // Click Bold Button
    public BoldFontAssert clickBoldButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(boldButtonBy);
        return new BoldFontAssert(driver);
    }

    // Click Italic Button
    public ItalicFontAssert clickItalicButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(italicButtonBy);
        return new ItalicFontAssert(driver);
    }

    // Click Style And Size Button
    public NewMessagePopupPage clickFontStyleAndSizeButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(styleAndSizeButtonBy);
        return this;
    }

    // Click Georgia Font
    public FontColorAndStyleAssert clickGeorgiaFontStyle() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(georgiaFontBy);
        return new FontColorAndStyleAssert(driver);
    }

    // Click Huge Font
    public FontSizeAssert clickHugeFontSize() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(hugeFontBy);
        return new FontSizeAssert(driver);
    }

    // Click Underline Button
    public UnderlineFontAssert clickUnderlineButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(underlineButtonBy);
        return new UnderlineFontAssert(driver);
    }

    // Click Font Color Button
    public NewMessagePopupPage clickFontColorButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(fontColorButtonBy);
        return this;
    }

    // Click Red Font Color Button
    public FontColorAndStyleAssert clickRedFontColorButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(redFontColorButtonBy);
        return new FontColorAndStyleAssert(driver);
    }

    // Click Black Font Color Button
    public NewMessagePopupPage clickBlackFontColorButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(blackFontColorButtonBy);
        return this;
    }

    // Click List And Alignment Text Button
    public NewMessagePopupPage clickListAndAlignTextButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(listAndAlignmentTextButtonBy);
        return this;
    }

    // Click Numeric List Option
    public ListTextAssert clickNumericListOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(numericListBy);
        return new ListTextAssert(driver);
    }

    // Click Point List Option
    public ListTextAssert clickPointListOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(pointedListBy);
        return new ListTextAssert(driver);
    }

    // Click Left Alignment Option
    public AlignTextAssert clickLeftAlignOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(leftAlignmentBy);
        return new AlignTextAssert(driver);
    }

    // Click Center Alignment Option
    public AlignTextAssert clickCenterAlignOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(centerAlignmentBy);
        return new AlignTextAssert(driver);
    }

    // Click Right Alignment Option
    public AlignTextAssert clickRightAlignOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(rightAlignmentBy);
        return new AlignTextAssert(driver);
    }

    // Click Stationery Button
    public NewMessagePopupPage clickStationeryButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(mailContentStationeryButtonBy);
        return this;
    }

    // Click Stationery Option
    public TextStationeryAssert clickStationeryOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(mailContentStationeryOptionBy);
        return new TextStationeryAssert(driver);
    }

    // Click Stationery Reset Option
    public NewMessagePopupPage clickStationeryResetOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(mailContentStationeryResetBy);
        return this;
    }

    // Insert Image
    public AttachFileAndInsertImageAssert insertImage(String pathToLocalFile) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(uploadImageBy);
        driver.findElement(uploadImageBy).sendKeys(pathToLocalFile);
        return new AttachFileAndInsertImageAssert(driver);
    }

    // Click Emoticon Button
    public NewMessagePopupPage clickEmoticonButton() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(emoticonButtonBy);
        return this;
    }

    // Click Emoticon Option
    public InsertEmoticonAssert clickEmoticonOption() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(emoticonOptionBy);
        return new InsertEmoticonAssert(driver);
    }
    //endregion
}