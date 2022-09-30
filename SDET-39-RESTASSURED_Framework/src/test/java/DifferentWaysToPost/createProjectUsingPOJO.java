package DifferentWaysToPost;

import org.testng.annotations.Test;

import POJOLibraries.projectLibraries;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createProjectUsingPOJO {

	@Test
	public void createProjectUsingPOJO()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int random=ran.nextInt();
		
		//create pre requisites
		projectLibraries plib = new projectLibraries("gini","xylem","created", 12);
		
		//send request and validate
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all();
		
	}
}
