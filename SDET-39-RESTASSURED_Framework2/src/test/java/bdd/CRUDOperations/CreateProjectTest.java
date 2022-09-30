package bdd.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {

	@Test
	public void createproject()
	{
		baseURI = "http://localhost";
		port=8084;
		
		//create pre requisites
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "Shree s m");
		obj.put("projectName", "SDET-39");
		obj.put("status","On Going");
		obj.put("teamSize", 12);
		
		//send the request
		given()
		   .body(obj)
		   .contentType(ContentType.JSON)
	    .when()
	       .post("/addProject")
       .then()
           .assertThat().statusCode(201)
		   .log().all();
		   
		   //validate the response
	}
}
;