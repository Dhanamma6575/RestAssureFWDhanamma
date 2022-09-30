package DifferentWaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createProjectUsingJSONObject {

	@Test
	public void createProjectusingJsonObject()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int random=ran.nextInt();
		
		//create pre requisites
				JSONObject obj=new JSONObject();
				obj.put("createdBy", "Sumitra s m");
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
	}
}
