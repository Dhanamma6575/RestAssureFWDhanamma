package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createProjectusingHashMap {

	@Test
	public void createProjectusingHashMap()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		//create pre requisites
		HashMap map = new HashMap();
		map.put("createdBy", "vaiju");
		map.put("projectName","SEDT-39-online");
		map.put("status","completed");
		map.put("teatSize",12);
		
		//send the request and validate
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
}
