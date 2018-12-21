package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private final String PRINT_SCREEN_PATH = "C:\\Users\\rb26508\\PageObjectModel\\reports\\";

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
             } catch(Exception e) {
                System.out.println("Error: czekam na element: " + elementBy);
                e.printStackTrace();
                printScreen(driver);
            }
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        if(driver.findElement(elementBy).getText()!="")
            driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    //PrintScreen
    public void printScreen(WebDriver driver){
        File dir = new File(PRINT_SCREEN_PATH + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        dir.mkdir();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(dir.toString() + "\\" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}