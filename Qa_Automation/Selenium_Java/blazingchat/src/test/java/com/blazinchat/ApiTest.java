package  com.blazinchat;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void testApi() {
        RestAssured.baseURI = "https://catfact.ninja/fact";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/");

        
     // Retrieve the body of the Response
    	ResponseBody body = response.getBody();    
        System.out.println("Response Body is: " + body.asString());
 }
}