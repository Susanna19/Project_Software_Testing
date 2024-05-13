package org;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest{

/*
increasing the quantity of the product in the cart by pushing the plus button,
then I check if the total amount has increased as well
thus the test has passed
 */
    @Test
    public void increasingAmount(){
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        CartPage cartPage = new CartPage(driver);
        int x = cartPage.checkoutAmount();
        cartPage.increaseQuantity();
        int y = cartPage.checkoutAmount();
        Assert.assertTrue(x < y, "The update was successful");
    }

    /*
    same logic here, before decreasing the quantity of the product I save the total amount to be paid, then I decrease the quantity
    and check the new total amount to be paid if it is bigger than the previous one then the test has passed
    however if the number of the product is 1, you should not be able to decrease it
     */
    @Test
    public void decreasingAmount() {
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        CartPage cartPage = new CartPage(driver);
        int x = cartPage.checkoutAmount();
        cartPage.decreaseQuantity();
        int y = cartPage.checkoutAmount();
        if (x == 1) {
            Assert.assertTrue(x == y, "The amount is 1, thus it did not change");
        } else {
            Assert.assertTrue(x > y, "The update was successful");
        }
    }


    /*
   This test should have been correct however as I tried the website does not update
   the amount manually changed, so it is the websites fault
    */
    @Test
    public void updatingQuantityManually(){
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        CartPage cartPage = new CartPage(driver);
        int x = cartPage.checkoutAmount();
        cartPage.updateQuantityManually("10");
        int y = cartPage.checkoutAmount();
        Assert.assertTrue(x < y, "The update was successful");
    }
}
