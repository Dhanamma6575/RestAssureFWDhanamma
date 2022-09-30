package RequestChaining;

import org.testng.annotations.Test;

import POJOLibraries.projectLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAndGetProject {

	@Test
	public void createAndGetproject()
	{
		Random ran= new Random();
		//step 1: create prerequisites for POST
		baseURI ="http://localhost";
		port = 8084;
		
		projectLibraries plib = new projectLibraries("dhanu","Amdocs"+ran.nextInt(100),"created",12);
		
		//step 2: send the POST request
		 Response resp = given()
		                .body(plib)
		                .contentType(ContentType.JSON)
		                .when()
		                .post("/addProject");
		 //step 3: capture the projectId writting JSON path
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		
		//step 4: send the get request with projectId
		given()
			.pathParam("pid", proId)
		.when()
			.get("/projects/{pid}")
			//.get("/projects/"+proId")
		.then()
		.assertThat().statusCode(200).log().all();
		
	}
}
