package org;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    /*
    so i am not pretty sure in what is the problem, but this test passes when i debug it and go line by line
    but fails when i just run it on its own
     */
    @Test
    public void successfulSearch() {
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        homePage.performSearch("cola");
        Assert.assertTrue(homePage.isCatalogVisible(), "Search is done!");
    }

    /*
    same here
     */
    @Test
    public void noSearchResults(){
        driver.get("https://www.sas.am/en/");
        HomePage homePage = new HomePage(driver);
        homePage.login();
        homePage.performSearch("aghhahaga");
        Assert.assertFalse(homePage.isCatalogVisible(), "No products");
    }


}
