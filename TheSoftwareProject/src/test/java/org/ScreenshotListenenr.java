package org;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class ScreenshotListener implements ITestListener {

    private static WebDriver driver;

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            try {
                File src = screenshotTaker.getScreenshotAs(OutputType.FILE);
                String dest = "screenshots/" + result.getName() + ".png";
                Files.copy(src.toPath(), Paths.get(dest));
                System.out.println("Screenshot saved for failed test: " + dest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

