package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests_assertions.login_tests.GoToHelpPageAS;
import tests_assertions.login_tests.InvalidLoginOrPasswordAS;
import tests_assertions.login_tests.ValidLoginAndPasswordAS;

import java.util.ArrayList;

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
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        driver.get(baseURL);
        return this;
    }

    //Go to Login Page
    public GoToHelpPageAS goToHelpPage() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        click(helpButtonBy);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        // change focus to new tab
        return new GoToHelpPageAS(driver.switchTo().window(newTab.get(1)));
    }

    //Input Account Name
    public HomePage fillInLoginField(String accountName) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Enter Account Name
        writeText(myAccountNameInputBy, accountName);
        return this;
    }

    //Input Password
    public HomePage fillInPasswordField(String password) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Enter Password
        writeText(passwordInputBy, password);
        return this;
    }

    //Accept Cookies
    public HomePage acceptCookies() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Click Cookies OK Button
        click(cookiesOKButtonBy);
        return this;
    }

    //Log In Not Successful
    public InvalidLoginOrPasswordAS clickLogInWithFail() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Click Login Button
        click(logInButtonBy);
        return new InvalidLoginOrPasswordAS(driver);
    }

    //Log In Successful
    public ValidLoginAndPasswordAS clickLogInButtonWithPass() {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        //Click Login Button
        click(logInButtonBy);
        return new ValidLoginAndPasswordAS(driver);
    }

    //Verify Invalid Account Name
    public HomePage verifyInvalidLogin(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            assertEquals(errorMessageUsernameBy, expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public By getHelpButtonBy() {
        return helpButtonBy;
    }

    public By getMyAccountNameInputBy() {
        return myAccountNameInputBy;
    }

    public By getPasswordInputBy() {
        return passwordInputBy;
    }

    public By getCookiesOKButtonBy() {
        return cookiesOKButtonBy;
    }

    public By getLogInButtonBy() {
        return logInButtonBy;
    }

    public By getErrorMessageUsernameOrPasswordBy() {
        return errorMessageUsernameOrPasswordBy;
    }

    public By getErrorMessageUsernameBy() {
        return errorMessageUsernameBy;
    }
}