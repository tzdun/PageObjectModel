package tests.login_tests;

import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTestTC;
import tests_property_managers.InvalidAccountNamePM;

public class InvalidAccountNameTC extends BaseTestTC {

    private static class TestData {
        private static InvalidAccountNamePM testDataPM = new InvalidAccountNamePM();
        private static String accountName = testDataPM.getAccountName();
        private static String password = testDataPM.getPassword();
        private static String invalidLoginOrPasswordError = testDataPM.getInvalidLoginOrPasswordError();
    }

    @Test(priority = 1)
    public void invalidAccountName() {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToHomePage()
                .enterAccountName(TestData.accountName)
                .enterPassword(TestData.password)
                .acceptCookies()
                .clickLogInWithFail()
                .verifyInvalidLoginOrPassword(TestData.invalidLoginOrPasswordError);
    }
}