package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpPage extends BasePage {

    //*********Constructor*********
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    private By logInButtonBy = By.xpath("//a[@href='//int.pl/#/login']");
    private By titleBy = By.tagName("title");

    public By getLogInButtonBy() {
        return logInButtonBy;
    }

    public By getTitleBy() {
        return titleBy;
    }
}
