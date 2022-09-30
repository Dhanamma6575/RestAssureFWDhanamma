package basicCRUDoperations;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllprojectsTest {

	@Test
	public void getAllProject()
	{
		//step 1: create pre reqisites
		
		//step 2: send the request
		Response resp = RestAssured.get("http://localhost:8084/Projects");
		
		//step 3: validate the response
		int expStatus = 404;
		 int actualStatus = resp.getStatusCode();
		 System.out.println(actualStatus);
		Assert.assertEquals(actualStatus, expStatus);
	}
}
