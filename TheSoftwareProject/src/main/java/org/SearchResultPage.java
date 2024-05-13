package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private By sortButtonIncrease= By.xpath(Locator_Constants.FILTER_BY_INCREASE);
    private By sortButtonDecrease = By.xpath(Locator_Constants.FILTER_BY_DECREASE);
    private By addToCart = By.xpath(Locator_Constants.ADD_TO_CART);

    private By productsinCart = By.xpath(Locator_Constants.CART_NUMBER);
    private By priceOfproduct = By.xpath(Locator_Constants.FIND_PRICE);

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void sortByPriceLowToHigh() {
        driver.findElement(sortButtonIncrease).click();
    }

    public void sortByPriceHightoLow(){
        driver.findElement(sortButtonDecrease).click();
    }

    public void setAddToCart(){
        driver.findElement(addToCart).click();
    }

    public int returnPrice(){
        String j = driver.findElement(priceOfproduct).getText();
        String digits = j.replaceAll("[^\\d]", "");
        int price = Integer.parseInt(digits);
        return price;
    }
    public String returnCartNumber(){
        String a = driver.findElement(productsinCart).getText();
        return a;
    }


}
