package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest{
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platformName", "MAC");
        capabilities.setCapability("version", "latest");
        URL url = new URL("https://susannavardanian_WUFHZN:yhMY4CQcqySMBsci2sTV@hub.browserstack.com/wd/hub");
        driver = new RemoteWebDriver(url, capabilities);
        driver.manage().window().maximize();
        ScreenshotListener.setDriver(driver);
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}