import models.CartSummaryModel;
import models.HomePageModel;
import models.LoginPageModel;
import models.MyAccountModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", DriverUtils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Submit a valid login")
    public static void submitValidLogin() {
       //arrange

        MyAccountModel myAccountModel = new MyAccountModel(driver);
        //act
        AccountUtils.login(driver);
        //assert
        DriverUtils.waitForTextVisible(driver, myAccountModel.EXPECTED_USERNAME, 20);
        myAccountModel.isOnPage();
    }

    @Test(testName = "Submit a invalid email")
    public static void submitInvalidEmail() {
        //arrange
        driver.get(DriverUtils.BASE_URL);
        LoginPageModel loginPageModel = new LoginPageModel(driver);
        //act
        loginPageModel.enterInvalidEmail();
        loginPageModel.enterValidPassword();
        loginPageModel.pressSubmitButton();
        //assert
        loginPageModel.isEmailErrorDisplayed();
    }

    @Test(testName = "Submit a invalid password")
    public static void submitInvalidPassword() {
        //arrange
        driver.get(DriverUtils.BASE_URL);
        LoginPageModel loginPageModel = new LoginPageModel(driver);
        //act
        loginPageModel.enterValidEmail();
        loginPageModel.enterInvalidPassword();
        loginPageModel.pressSubmitButton();
        //assert
        loginPageModel.isAuthenticationErrorDisplayed();
    }

    @Test(testName = "Purchase a Blouse")
    public static void purchaseABlouse() {
        //arrange
        driver.get(DriverUtils.HOME_PAGE);
        HomePageModel homePageModel = new HomePageModel(driver);
        CartSummaryModel cartSummaryModel = new CartSummaryModel(driver);
        //act
        AccountUtils.loginAndReturnToHomePage(driver);
        homePageModel.hoverOverBlouse();
        homePageModel.addBlouseToCartButton();
        DriverUtils.waitForElementById(driver, "layer_cart", 20);
        homePageModel.checkout();
        DriverUtils.waitForElementById(driver, "order_step", 5);
        cartSummaryModel.isOnFirstStep();
        cartSummaryModel.validateProductSKU("SKU : demo_2");
        cartSummaryModel.clickProceedToCheckout(1);
        cartSummaryModel.isOnThirdStep();
        cartSummaryModel.clickProceedToCheckout(3);
        cartSummaryModel.isOnFourthStep();
        cartSummaryModel.acceptTOS();
        cartSummaryModel.clickProceedToCheckout(4);
        cartSummaryModel.isOnFifthStep();
        cartSummaryModel.clickPayByWire();
        cartSummaryModel.validatePrice("$30.16");
        cartSummaryModel.clickConfirmOrder();
        //assert
        cartSummaryModel.validateOrderComplete();


    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}