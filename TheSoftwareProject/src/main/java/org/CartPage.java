package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By increase_button = By.cssSelector(Locator_Constants.INCREASE_BUTTON);
    private By decrease_button = By.xpath(Locator_Constants.DECREASE_BUTTON);
    private By item_number = By.xpath(Locator_Constants.ITEM_NUMBER);
    private By cart_button = By.xpath(Locator_Constants.CART_BUTTON);
    private By total_amount = By.xpath(Locator_Constants.AMOUNT_TO_BE_PAID);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void updateQuantityManually(String quantity) {
driver.findElement(cart_button).click();
        driver.findElement(item_number).clear();
        driver.findElement(item_number).sendKeys(quantity);
    }

    public void increaseQuantity() {
        driver.findElement(increase_button).click();
    }

    public void decreaseQuantity() {
        driver.findElement(decrease_button).click();
    }

    public int getQuantity() {
        String a = driver.findElement(item_number).getText();
        int quantity = Integer.parseInt(a);
        return quantity;
    }

    public int checkoutAmount(){
        driver.findElement(cart_button).click();
        String j = driver.findElement(total_amount).getText();
        String digits = j.replaceAll("[^\\d]", "");
        int price = Integer.parseInt(digits);
        return price;
    }
}
