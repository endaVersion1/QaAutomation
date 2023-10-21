package com.blazinchat;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisualRegression {
    private WebDriver driver;
    private Eyes eyes;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Initialize the Eyes SDK
        eyes = new Eyes();
        eyes.setApiKey("zOjE51dXy6haYt31xaI2e3KETIvIP6pnSOXlLez106sHM110");
    }

    @Test
    public void testVisualRegression() {
        // Open the website
        driver.get("https://www.warhammer-community.com");

        // Start the visual regression test
        eyes.open(driver, "Warhammer Community", "Home Page", new RectangleSize(800, 600));

        // Perform visual checks on the page
        eyes.checkWindow("Home Page");

        // Close the visual regression test
        eyes.closeAsync();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();

        // Abort the Eyes test if it's still running
        eyes.abortIfNotClosed();
    }
    
}
