package basicCRUDoperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void createProtectTest()
	{
		//step 1: create the prerequisites necessary
		JSONObject obj= new JSONObject();
		obj.put("createdBy", "Dhanamma s m");
		obj.put("projectName", "SDET-39");
		obj.put("status","On Going");
		obj.put("teamSize", 20);
		
		//step 2: send the request
		 RequestSpecification request = RestAssured.given();
		 
		 request.body(obj);
		 request.contentType(ContentType.JSON);
		 
		  Response resp = request.post("http://localhost:8084/addProject");
		  
		//step 3: validate the response
		  System.out.println(resp.getContentType());
		  System.out.println(resp.getStatusCode());
		  System.out.println(resp.getStatusLine());
		  
		  System.out.println(resp.asString());
		  System.out.println(resp.asPrettyString());
		  System.out.println(resp.prettyPrint());
		  System.out.println(resp.prettyPeek());
		
	}
}
