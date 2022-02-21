import models.LoginPageModel;
import models.MyAccountModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

// Utilities for non-page specific account operations

public class AccountUtils {

    public static void login(WebDriver driver) {
        driver.get(DriverUtils.BASE_URL);
        LoginPageModel loginPageModel = new LoginPageModel(driver);
        MyAccountModel myAccountModel = new MyAccountModel(driver);
        loginPageModel.enterValidEmail();
        loginPageModel.enterValidPassword();
        loginPageModel.pressSubmitButton();
        DriverUtils.waitForTextVisible(driver, myAccountModel.EXPECTED_USERNAME, 5);
    }
    public static void loginAndReturnToHomePage(WebDriver driver) {
        MyAccountModel myAccountModel = new MyAccountModel(driver);
        login(driver);
        myAccountModel.goToHomePage();
        DriverUtils.waitForLoad(driver);

    }
}


