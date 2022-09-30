package basicCRUDoperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	public void delete()
	{
		//step 1: create pre requisites
		
		//step 2: send the request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1602");
		
		//step 3: validate the response
		System.out.println(resp.getStatusCode());
	}
}
