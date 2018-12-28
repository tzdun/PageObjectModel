package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.InvalidAccountNamePM;

public class InvalidAccountNameTC extends BaseTestTC {
    private InvalidAccountNamePM testData = new InvalidAccountNamePM();

    @Test(priority = 1)
    public void invalidAccountName() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(testData.getAccountName())
                .enterPassword(testData.getPassword())
                .acceptCookies()
                .clickLogInWithFail()
                .verifyInvalidLoginOrPassword(testData.getInvalidLoginOrPasswordError());
    }
}