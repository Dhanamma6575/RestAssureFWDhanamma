package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ResponseTimeValidation {

	@Test
	public void responseTimeV()
	{
		//step 1:create prerequisites
		baseURI = "http://localhost";
		port =8084;
		//step 2: send the request
		when()
		.get("projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L));
		
		//System.out.println(resp.getTime());
		
		//step 3: validate response
	}
}
