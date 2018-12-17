package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://int.pl";

    //*********Web Elements*********
    By helpButtonBy = By.xpath("//*[contains(text(),'Pomoc')]");
    By myAccountNameInputBy = By.id("emailId");
    By passwordInputBy = By.id("passwordId");
    By cookiesOKButtonBy = By.xpath("//a[contains(text(),'Dowiedz się więcej')]/../span");
    By logInButtonBy = By.xpath("//*[contains(text(),'loguję się')]");
    By errorMessageUsernameOrPasswordBy = By.xpath("//div[@ng-if='error']");
    By errorMessageUsernameBy = By.xpath("//span[contains(@ng-show,'error.pattern')]");

    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToHomePage (){
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public HelpPage goToHelpPage (){
        click(helpButtonBy);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // change focus to new tab
        return new HelpPage(driver.switchTo().window(newTab.get(1)));
    }

    public HomePage loginToEmailBox (String username, String password){
        //Enter Username(Email)
        writeText(myAccountNameInputBy,username);
        //Enter Password
        writeText(passwordInputBy, password);
        return this;
    }

    public HomePage acceptCookies (){
        //Click Cookies OK Button
        click(cookiesOKButtonBy);
        return this;
    }

    public HomePage clickLogInForNotOK (){
        //Click Login Button
        click(logInButtonBy);
        return this;
    }

    public InboxPage clickLogInForOK (){
        //Click Login Button
        click(logInButtonBy);
        return new InboxPage(driver);
    }

    public HomePage verifyInvalidLoginOrPasword (String expectedText){
        //Verify Username Or Password Condition
        assertEquals(errorMessageUsernameOrPasswordBy, expectedText);
        return this;
    }

    public HomePage verifyInvalidLogin (String expectedText){
        //Verify Username Or Password Condition
        assertEquals(errorMessageUsernameBy, expectedText);
        return this;
    }

}