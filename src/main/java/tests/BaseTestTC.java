package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;

public class BaseTestTC {
    public WebDriver driver;
    private String propertyFilePath = "src/main/resources/webDriver/webDriverSettings";
    private String chromeDriver;
    private String chromeDriverFilePath;

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        setWebDriverProperty(this.propertyFilePath);
        System.setProperty(chromeDriver, chromeDriverFilePath);
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
        System.out.println("Koniec testu...");
    }

    public void setWebDriverProperty(String propertyPathFile){
        BasePropertyManager basePropertyManager = new BasePropertyManager(propertyPathFile);
        setChromeDriver(basePropertyManager.getProperties().getProperty("chromeDriver"));
        setChromeDriverFilePath(basePropertyManager.getProperties().getProperty("chromeDriverFilePath"));
    }

    public void setChromeDriver(String chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void setChromeDriverFilePath(String chromeDriverFilePath){
        try {
            this.chromeDriverFilePath = new File(chromeDriverFilePath).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}