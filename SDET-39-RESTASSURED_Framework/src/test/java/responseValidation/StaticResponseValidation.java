package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponse()
	{
		//prerequisites
		String expData = "TY_PROJ_1002";
		baseURI = "http://localhost";
		port = 8084;
		
		//axction
		Response resp = when()
				.get("projects");
		
		//validation
		String actData = resp.jsonPath().get("[1].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		
		resp.then().log().all();
		
		
	}
	
}
