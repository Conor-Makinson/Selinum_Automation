package models;// Page URL: http://automationpractice.com/index.php?controller=authentication&back=my-account

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPageModel extends PageObject {
    public LoginPageModel(WebDriver driver) {
        super(driver);
    }

    private final String VALID_EMAIL = "conor.makinson@yahoo.com";
    private final String VALID_PASSWORD = ".K3q8W6azR8qTeC";
    private final String INVALID_EMAIL = "conor.makinsonyahoo.com";
    private final String INVALID_PASSWORD = ".K3q8W6R8qTeC";
    public final String EMAIL_ERROR_MESSAGE = "Invalid email address.";
    public final String AUTHENTICATION_ERROR_MESSAGE = "Authentication failed.";
    @FindBy(id = "email")
    private WebElement emailElement;

    @FindBy(id = "passwd")
    private WebElement passwordElement;

    @FindBy(id = "SubmitLogin")
    private WebElement submit_button;


    public void enterValidEmail() {
        this.emailElement.sendKeys(VALID_EMAIL);
    }

    public void enterInvalidEmail() {
        this.emailElement.sendKeys(INVALID_EMAIL);
    }

    public void enterValidPassword() {
        this.passwordElement.sendKeys(VALID_PASSWORD);
    }

    public void enterInvalidPassword() {
        this.passwordElement.sendKeys(INVALID_PASSWORD);
    }

    public void pressSubmitButton() {
        this.submit_button.click();
    }

    public void isEmailErrorDisplayed() {
        String text = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
        Assert.assertEquals(text, EMAIL_ERROR_MESSAGE);
    }

    public void isAuthenticationErrorDisplayed() {
        String text = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li")).getText();
        Assert.assertEquals(text, AUTHENTICATION_ERROR_MESSAGE);
    }
}