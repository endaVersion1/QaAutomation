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
         // Set an implicit wait for the driver
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //maximize window
         driver.manage().window().maximize();
        
         // Open the website
         driver.get("http://www.blazingchat.com");
    }

    @Test
    public void testLogIn()
    {
       //Creating a webElement
        WebElement loginButton  = driver.findElement(By.id("button_login"));
        //Interacting with web elment
        loginButton .click();

        WebElement userProfilePicture = driver.findElement(By.cssSelector("img[alt='User Profile Picture']"));
        WebElement firstNameInput  = driver.findElement(By.cssSelector("input[placeholder='first name']"));
        WebElement lastNameInput =driver.findElement(By.cssSelector("input[placeholder='last name']"));
        WebElement emailInput =driver.findElement(By.cssSelector("input[placeholder='email address']"));
        WebElement aboutMeInput  = driver.findElement(By.cssSelector("input[placeholder='about me']"));
        WebElement saveButton  = driver.findElement(By.cssSelector("button.btn.btn-primary['Save']"));

         // Get the placeholder text of the input element
        String placeholderFirstNameText = firstNameInput.getAttribute("placeholder");


        //verify the profile
        Assert.assertTrue(userProfilePicture.isDisplayed(), "User Profile Picture is not visible.");
        Assert.assertTrue(placeholderFirstNameText.contains("mario"), "Placeholder text does not contain 'mario'");


    }


    @Test
    public void testContactList(){
        // Open the website and Login

        //Select Contact List

        //Verify a list of contacts appear
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
