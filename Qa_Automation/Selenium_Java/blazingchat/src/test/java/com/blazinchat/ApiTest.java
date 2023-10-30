package  com.blazinchat;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApiTest {
    private WebDriver driver;
    @Test
    public void testApiGetContacts() {
        //Login

        //Select Contacts

        //Set UP Api Call
        RestAssured.baseURI = "https://blazingchatwebapi.azurewebsites.net";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/contacts/getvisiblecontacts?startIndex=0&count=17");

        
     // Retrieve the body of the Response
    	ResponseBody body = response.getBody();    
        System.out.println("Response Body is: " + body.asString());
 }

 @Test
 public void testPostAddUser(){
    // Open the website
       driver.get("http://www.blazingchat.com");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       //Creating a webElement
        WebElement element = driver.findElement(By.id("button_login"));
        //Interacting with web elment
        element.click();
 }
}