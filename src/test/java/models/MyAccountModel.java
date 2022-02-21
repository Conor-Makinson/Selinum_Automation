package models;// Page URL: http://automationpractice.com/index.php?controller=my-account

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class MyAccountModel extends PageObject {
    public MyAccountModel(WebDriver driver) {
        super(driver);
    }

    public final String EXPECTED_USERNAME = "Conor Makinson";

    @FindBy(linkText = EXPECTED_USERNAME)
    private WebElement userNameElement;

    @FindBy(css = "#header_logo > a")
    private WebElement homePageLink;

    public void isOnPage() {
        Assert.assertTrue(userNameElement.isDisplayed());
    }

    public void goToHomePage() {
        this.homePageLink.click();
    }


}