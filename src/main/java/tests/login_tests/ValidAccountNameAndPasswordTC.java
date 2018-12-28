package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.ValidAccountNameAndPasswordPM;

public class ValidAccountNameAndPasswordTC extends BaseTestTC {
    private ValidAccountNameAndPasswordPM testData = new ValidAccountNameAndPasswordPM();
    @Test (priority = 2)
    public void validAccountNameAndPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(testData.getAccountName())
                .enterPassword(testData.getPassword())
                .acceptCookies()
                .clickLogInWithPass()
                .verifyValidLogin(testData.getValidLoginAndPasswordAssert())
                .logOut();
    }
}