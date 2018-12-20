package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintScreen {
    public PrintScreen(AssertionError error, WebDriver driver) {
        error.printStackTrace();
        File dir = new File("C:\\Users\\rb26508\\PageObjectModel\\reports\\" + new SimpleDateFormat("yyyyMMdd").format(new Date()));
        dir.mkdir();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(dir.toString() + "\\" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
