package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tests_property_managers.BasePropertyManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTestTC {
    public WebDriver driver;
    private String propertyFilePath = "src/main/resources/webDriver/webDriverSettings";
    private String chromeDriver;
    private String chromeDriverFilePath;

    @BeforeMethod
    public void setup (Method testMethod) {
        System.out.println("Setup for TC method: " + testMethod.getName() + ".");
        //Create a Chrome driver. All test classes use this.
        setWebDriverProperty(this.propertyFilePath);
        System.setProperty(chromeDriver, chromeDriverFilePath);
        driver = new ChromeDriver();

        //Maximize Window
        driver.manage().window().maximize();
        System.out.println("Setup is done.");
    }

    @AfterMethod
    public void teardown (Method testMethod) {
        driver.quit();
        System.out.println("TC method: " + testMethod.getName() + " is finished.");
        System.out.println("------------------------------------------------------");
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