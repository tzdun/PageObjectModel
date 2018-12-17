package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelpPage extends BasePage{

    //*********Constructor*********
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By logInButton = By.xpath("//a[@href='//int.pl/#/login']");
    By titleBy = By.tagName("title");

    //*********Page Methods*********

    public HomePage clickLogInButton (){

        //Click LogIn Button
        click(logInButton);
        return new HomePage(driver);
    }

    // Verify Help Page
    public HelpPage verifyHelpPage(String expectedText) {
        waitVisibility(logInButton);
        Assert.assertEquals(driver.findElement(titleBy).getAttribute("innerText"), expectedText);

        return this;
    }
}
