package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static org.junit.Assert.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LoginRequestPojo;
import pojo.LoginResponsePojo;
import utilities.Reusables;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import TestData.TestDataBuild;

public class loginStepDefinition extends Reusables {
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	LoginResponsePojo loginResp;
	String token;
	TestDataBuild data = new TestDataBuild();
	
	@Given("user has the payload of login api with {string} and {string}")
	public void user_has_the_payload_login(String userEmail, String userPassword) throws IOException {			
		//constructs payload and stores it in requestSpecification object res
		res=given().spec(requestSpecification())
		.body(data.loginPayload(userEmail,userPassword));	   
	}
	
	@Given("user calls the login api with post request")
	public void user_calls_the_login_api_with_post_request() {
		//API call is done and response is obtained as string
		response=res.when().post("/auth/login").then().spec(responseSpecification(200)).extract().response();
		
		//convert response as pojo object
		loginResp=response.as(LoginResponsePojo.class);

	}
	
	@When("user gets response code {int}")
	public void user_gets_response_code(int responseCode) {
	   assertEquals(response.getStatusCode(),responseCode);
	}
	
	@Then("response body has token")
	public void response_body_has_token() {
		token= loginResp.getToken();
	    assertTrue(!token.isEmpty());
		
	}
	


}
