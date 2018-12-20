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
    public HelpPage verifyHelpPage(String expectedText) {
        waitVisibility(logInButton);
        try {
            Assert.assertEquals(driver.findElement(titleBy).getAttribute("innerText"), expectedText);
        }
        catch(AssertionError e) {
            e.printStackTrace();
            File dir = new File("C:\\Users\\rb26508\\PageObjectModel\\reports\\" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
            dir.mkdir();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(dir.toString()+"\\"+new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+".png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return this;
    }
}
