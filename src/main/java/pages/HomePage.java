package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String baseURL = "https://int.pl";

    //*********Web Elements*********
    private By helpButtonBy = By.xpath("//*[contains(text(),'Pomoc')]");
    private By myAccountNameInputBy = By.id("emailId");
    private By passwordInputBy = By.id("passwordId");
    private By cookiesOKButtonBy = By.xpath("//a[contains(text(),'Dowiedz się więcej')]/../span");
    private By logInButtonBy = By.xpath("//*[contains(text(),'loguję się')]");
    private By errorMessageUsernameOrPasswordBy = By.xpath("//div[@ng-if='error']");
    private By errorMessageUsernameBy = By.xpath("//span[contains(@ng-show,'error.pattern')]");

    //*********Page Methods*********
    //Go to Home Page
    public HomePage goToHomePage() {
        driver.get(baseURL);
        return this;
    }

    //Go to Login Page
    public HelpPage goToHelpPage() {
        click(helpButtonBy);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // change focus to new tab
        return new HelpPage(driver.switchTo().window(newTab.get(1)));
    }

    //Input Account Name
    public HomePage enterAccountName(String accountName) {
        //Enter Account Name
        writeText(myAccountNameInputBy, accountName);
        return this;
    }

    //Input Password
    public HomePage enterPassword(String password) {
        //Enter Password
        writeText(passwordInputBy, password);
        return this;
    }

    //Accept Cookies
    public HomePage acceptCookies() {
        //Click Cookies OK Button
        click(cookiesOKButtonBy);
        return this;
    }

    //Log In Not Successful
    public HomePage clickLogInWithFail() {
        //Click Login Button
        click(logInButtonBy);
        return this;
    }

    //Log In Successful
    public InboxPage clickLogInWithPass() {
        //Click Login Button
        click(logInButtonBy);
        return new InboxPage(driver);
    }

    //Verify Invalid Login Or Password
    public HomePage verifyInvalidLoginOrPassword(String expectedText) {
        try {
            assertEquals(errorMessageUsernameOrPasswordBy, expectedText);
        } catch (AssertionError e) {
            new PrintScreen(e, driver);
        }
        return this;
    }

    //Verify Invalid Account Name
    public HomePage verifyInvalidLogin(String expectedText) {
        try {
            assertEquals(errorMessageUsernameBy, expectedText);
        } catch (AssertionError e) {
            new PrintScreen(e, driver);
        }
        return this;
    }

}