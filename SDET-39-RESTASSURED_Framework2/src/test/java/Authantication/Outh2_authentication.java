package Authantication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Outh2_authentication {

	@Test
	public void outh_2authentication()
	{
		//step 1: generate the access Token - Post
		baseURI = "http://coop.apps.symfonycasts.com";
		
		 Response resp = given()
			.formParam("client_id", "SDET-39-online")
			.formParam("client_secret", "6e3c942cc6ef0aa46ca0193a8e0199ec")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://example.com")
			.formParam("code","authorization_code")
		.when()
		    .post("/token");
        
		
		//step 2: capture the access token
		String token = resp.jsonPath().get("access_token");
		 System.out.println(token);
		
		//step 3  use it for other endpoints
		 given()
		 .pathParam("USER_ID", 3855)
		 .auth()
		 .oauth2(token)
		 .when()
		 .post("/api/{USER_ID}/chickens-feed")
		 .then().log().all();
	}
}
