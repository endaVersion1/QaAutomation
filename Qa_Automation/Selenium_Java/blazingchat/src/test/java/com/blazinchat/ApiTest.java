package  com.blazinchat;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiTest {
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
         // Open the website
         driver.get("https://jsonplaceholder.typicode.com/posts");

         RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testApiGetPosts() {
        Response response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .when()
            .get("/posts"); // Replace with the actual endpoint

        // Retrieve the body of the Response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        driver.get("https://jsonplaceholder.typicode.com/posts/1");
        WebElement postDetails = driver.findElement(By.cssSelector(".token-string"));
        String actualText = postDetails.getText();
        // Perform the assertion
        Assert.assertEquals("new body Test", actualText);


 }


  @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}