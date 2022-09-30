package Authantication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class BasicAuthantication {

	@Test
	public void basicAuthantication()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}
	
	@Test
	public void digestiveAuthentication()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}
	
	@Test
	public void preemptiveAuthentication()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("/login")
		.then().log().all();
	}
}
