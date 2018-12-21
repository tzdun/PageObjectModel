package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpPage extends BasePage{

    //*********Constructor*********
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    private By logInButton = By.xpath("//a[@href='//int.pl/#/login']");
    private By titleBy = By.tagName("title");

    //*********Page Methods*********
    //Click LogIn Button
    public HomePage clickLogInButton (){
        click(logInButton);
        return new HomePage(driver);
    }

    // Verify Help Page
    public HelpPage verifyHelpPage(String expectedText){
        waitVisibility(logInButton);
        try {
            Assert.assertEquals(driver.findElement(titleBy).getAttribute("innerText"), expectedText);
        }
        catch(AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
