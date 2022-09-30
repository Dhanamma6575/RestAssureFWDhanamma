package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseValidation {

	@Test
	public void dynamicResponsevalidation()
	{
		//step 1: create prerequisites
		baseURI = "localhost";
		port =8084;
		
		String expData = "TY_PROJ_2402";
		
		//step 2: send the request
		Response resp = when()
				.get("/projects");
		
		//step 3: validate the response
		boolean flag = false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list)
		{
			if(actData.equalsIgnoreCase(expData));
			{
				System.out.println(actData);
			flag = true;  //flag rising
			break;
			}
		}
		Assert.assertTrue(flag);
	}
	
}
