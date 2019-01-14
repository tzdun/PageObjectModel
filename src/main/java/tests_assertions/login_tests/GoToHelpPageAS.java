package tests_assertions.login_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HelpPage;

public class GoToHelpPageAS extends HelpPage {
    public GoToHelpPageAS(WebDriver driver) {
        super(driver);
    }

    // Verify Help Page
    public HelpPage goToHelpPageAssert(String expectedText){
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        waitVisibility(getLogInButtonBy());
        try {
            Assert.assertEquals(driver.findElement(getTitleBy()).getAttribute("innerText"), expectedText);
        }
        catch(AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
        }
        return this;
    }
}
