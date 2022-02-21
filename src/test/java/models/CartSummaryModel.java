package models;// Page URL: http://automationpractice.com/index.php?controller=order

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartSummaryModel extends PageObject {
    public CartSummaryModel(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "order_step")
    private WebElement orderStep;

    @FindBy(css = "#order_step > li.step_current.first")
    private WebElement firstStep;

    @FindBy(css = "#order_step > li.step_current.third")
    private WebElement thirdStep;

    @FindBy(css = "#order_step > li.step_current.four")
    //Step step_current.four seems inconsistent with the existing convention.
    private WebElement fourthStep;

    @FindBy(css = "#order_step > li.step_current.last")
    //Step step_current.last also seems inconsistent with the existing convention.
    private WebElement fifthStep;

    @FindBy(css = "td.cart_description > small.cart_ref")
    private WebElement productSKU;

    @FindBy(id = "amount")
    private WebElement finalPrice;

    @FindBy(css = "a.button.btn.btn-default.standard-checkout.button-medium")
    private WebElement proceedToCheckout;

    @FindBy(css = "#center_column > form > p > button")
    private WebElement proceedToCheckout3; //Checkout button on step three uses a different CSS Selector.

    @FindBy(css = "#form > p > button")
    private WebElement proceedToCheckout4; //Checkout button on step four uses a different CSS Selector.

    @FindBy(id = "cgv")
    private WebElement TOSCheckbox;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    private WebElement payByWire;

    @FindBy(css = "#cart_navigation > button")
    private WebElement confirmOrder;

    @FindBy(css = "#center_column > div > p > strong")
    private WebElement orderCompleteMessage;

    public void isOnOrderPage() {
        Assert.assertTrue(orderStep.isDisplayed());
    }

    public void isOnFirstStep() {
        Assert.assertTrue(firstStep.isDisplayed());
    }

    public void isOnThirdStep() {
        Assert.assertTrue(thirdStep.isDisplayed());
    }

    public void isOnFourthStep() {
        Assert.assertTrue(fourthStep.isDisplayed());
    }

    public void isOnFifthStep() {
        Assert.assertTrue(fifthStep.isDisplayed());
    }


    public void validateProductSKU(String expectedSKU) {
        String actualSKU = productSKU.getText();
        Assert.assertTrue(actualSKU.equals(expectedSKU));

    }

    public void validatePrice(String expectedPrice) {
        String actualPrice = finalPrice.getText();
        Assert.assertTrue(actualPrice.equals(expectedPrice));

    }

    public void clickProceedToCheckout(int checkoutStep) {
        switch (checkoutStep) {
            case 1:
                this.proceedToCheckout.click();
                break;
            case 3: //case 2 skipped as step 2 is login
                this.proceedToCheckout3.click();
                break;
            case 4:
                this.proceedToCheckout4.click();
                break;
            default:
                Assert.assertTrue(false, "Unrecognised checkout step");
                break;
        }

    }

    public void clickPayByWire() {
        this.payByWire.click();
    }

    public void acceptTOS() {
        this.TOSCheckbox.click();
    }

    public void clickConfirmOrder() {
        this.confirmOrder.click();
    }

    public void validateOrderComplete() {
        Assert.assertTrue(orderCompleteMessage.getText().equals("Your order on My Store is complete."));
    }
}
