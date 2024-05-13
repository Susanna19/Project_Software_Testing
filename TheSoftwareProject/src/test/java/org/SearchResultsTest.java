package org;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTest{

    /*
    here before sorting the products in low prices to high, I save the first products price that comes up after search
    then I push the button of the sort and compare the first product's price to the previous one's, if the latter is bigger
    then the test passed successfully
     */
    @Test
    public void sortingIncrease(){
        driver.get("https://www.sas.am/en/search/?SORTBY=RELEVANSE&q=cola");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        int a = searchResultPage.returnPrice();
        searchResultPage.sortByPriceLowToHigh();
        int b = searchResultPage.returnPrice();
        Assert.assertTrue(a >b, "The sorting works correctly");
    }

    /*
    same logic here, just with the previous product's price should be less than the one's after sorting
     */
    @Test
    public void sortingDecrease(){
        driver.get("https://www.sas.am/en/search/?SORTBY=RELEVANSE&q=cola");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        int a = searchResultPage.returnPrice();
        searchResultPage.sortByPriceHightoLow();
        int b = searchResultPage.returnPrice();
        Assert.assertTrue(a<b, "The sorting works correctly");
    }

    /*
    before adding the product to the cart I save the carts number of products
    then I add the product to the cat and check if the cat's number has updated
     */
    @Test
    public void addingToCart(){
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        driver.get("https://www.sas.am/en/search/?SORTBY=RELEVANSE&q=cola");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String oldamount = searchResultPage.returnCartNumber();
        searchResultPage.setAddToCart();
        String newAmount = searchResultPage.returnCartNumber();
        Assert.assertNotEquals(oldamount, newAmount);
    }


}
