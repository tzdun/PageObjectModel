package tests_assertions.login_assertions;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class InvalidLoginOrPasswordAssert extends HomePage {
    public InvalidLoginOrPasswordAssert(WebDriver driver) {
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
