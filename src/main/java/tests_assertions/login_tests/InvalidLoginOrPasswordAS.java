package tests_assertions.login_tests;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class InvalidLoginOrPasswordAS extends HomePage {
    public InvalidLoginOrPasswordAS(WebDriver driver) {
        super(driver);
    }

    //Verify Invalid Login Or Password
    public HomePage invalidLoginOrPasswordAssertion(String expectedText) {
        System.out.println("step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            assertEquals(getErrorMessageUsernameOrPasswordBy(), expectedText);
        } catch (AssertionError e) {
            e.printStackTrace();
            printScreen(driver);
            throw e;
        }
        return this;
    }
}
