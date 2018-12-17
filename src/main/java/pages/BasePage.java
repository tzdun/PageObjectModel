package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 20 && !result) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
                result = true;
                break;
            } catch(Exception e) {
                System.out.println((attempts+1) + ": error: czekam na element: " + elementBy);
            }
            attempts++;
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
}