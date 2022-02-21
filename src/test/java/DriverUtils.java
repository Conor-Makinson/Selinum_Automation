import models.LoginPageModel;
import models.MyAccountModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Utilities designed for abstracting useful functions for the chrome driver

public class DriverUtils {
    final static String BASE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    final static String HOME_PAGE = "http://automationpractice.com/index.php";
    final static String CHROME_DRIVER_LOCATION = "chromedriver";

    public static void waitForTextVisible(WebDriver driver, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(text)));
    }

    public static void waitForPartialTextVisible(WebDriver driver, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(text)));
    }

    public static void waitForElementById(WebDriver driver, String text, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(text)));
    }

    public static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }



}