package Authantication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void bearerToken()
	{
		baseURI = "https://api.github.com";
		
		JSONObject jobj= new JSONObject();
		jobj.put("name", "SDET-39-REST");
		jobj.put("description", "HybridFw");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/user/repos")
		.then().log().all();
	}
}
