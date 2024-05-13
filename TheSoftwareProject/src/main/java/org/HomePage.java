package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {
    private By login_button = By.cssSelector(Locator_Constants.LOGIN_BUTTON);
    private By userName = By.xpath(Locator_Constants.USERNAME);
    private By passWord = By.xpath(Locator_Constants.PASSWORD);
    private By loginbutton = By.xpath(Locator_Constants.LOGINBUTTON);

    private By searchBox = By.xpath(Locator_Constants.SEARCH_BOX);
    private By searchButton = By.cssSelector(Locator_Constants.SEARCH_BUTTON);
private By searchResults = By.xpath(Locator_Constants.SEARCH_RESULTS);
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login() {
       driver.findElement(login_button).click();
        driver.findElement(userName).click();
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys("susannavardanian2002@gmail.com");
        driver.findElement(passWord).click();
        driver.findElement(passWord).sendKeys("19042002s");
        driver.findElement(loginbutton).click();
    }

    public void performSearch(String searchText){
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(searchText);
        driver.findElement(searchButton).click();
    }

public boolean isCatalogVisible(){
    return !findAll(searchResults).isEmpty();
}
}
