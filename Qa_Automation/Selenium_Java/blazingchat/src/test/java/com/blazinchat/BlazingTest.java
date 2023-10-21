package com.blazinchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.gson.JsonElement;


public class BlazingTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
         //maximize window
         driver.manage().window().maximize();
    }

    @Test
    public void testOpenLogIn()
    {
       // Open the website
       driver.get("http://www.blazingchat.com");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       //Creating a textbox webElement
        WebElement element = driver.findElement(By.id("button_login"));
        //Using sendKeys to write in the textbox
        element.click();
       
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
