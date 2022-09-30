package basicCRUDoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	{
		//step 1:create pre requisites
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Dhanamma");
		obj.put("projectName", "SDET-39");
		obj.put("status","completed");
		obj.put("teamSize", 20);
		
		//step 2: send the request
		RequestSpecification req = RestAssured.given();
		
		req.body(obj);
		
		req.contentType(ContentType.JSON);
		
		Response res = req.put("http://localhost:8084/projects/TY_PROJ_1802");
		//step 3: variable the response
		System.out.println(res.getStatusCode());
		
	}
}
