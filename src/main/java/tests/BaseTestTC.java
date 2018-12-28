package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestTC {
    public WebDriver driver;

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rb26508\\Downloads\\Potrzebne\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
        System.out.println("Koniec testu...");
    }

}