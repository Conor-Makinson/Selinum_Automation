package models;// Page URL: http://automationpractice.com/index.php

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageModel extends PageObject {
    public HomePageModel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement add_blouse_to_cart;

    @FindBy(css = "li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
    private WebElement blouse_image;

    @FindBy(id = "layer_cart")
    private WebElement cart_popup;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    private WebElement checkout_button;

    public void hoverOverBlouse() {
        Actions action = new Actions(driver);
        action.moveToElement(blouse_image).perform();
    }

    public void addBlouseToCartButton() {
        this.add_blouse_to_cart.click();
    }

    public boolean isCartSuccessBoxDisplayed() {
        return cart_popup.isDisplayed();
    }

    public void checkout() {
        this.checkout_button.click();
    }
}
