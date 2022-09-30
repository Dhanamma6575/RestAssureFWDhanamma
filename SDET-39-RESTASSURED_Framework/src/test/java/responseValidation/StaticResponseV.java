package responseValidation;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseV {

	@Test
	public void staticvalidation()
	{
	   //step 1: create prerequisites
		baseURI = "http://localhost";
		port =8084;
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "xyz");
		obj.put("projectName", "SDET-39-online1");
		obj.put("status","Completed");
		obj.put("teamSize", 12);
		
		String expData = "SDET-39-online1";
		
		//step 2: send the request
		Response resp = given()
		   .body(obj)
		   .contentType(ContentType.JSON)
	    .when()
	       .post("/addProject");
		
		//step 3: validate the response
		String actData = resp.jsonPath().get("projectName");
		Assert.assertEquals(actData, expData);
		resp.then().log().all();
	}
	
}