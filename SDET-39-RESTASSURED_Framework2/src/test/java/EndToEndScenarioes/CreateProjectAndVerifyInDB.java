package EndToEndScenarioes;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibraries.BaseAPIClass;
import GenericLibraries.EndPointLibrary;
import POJOLibraries.projectLibraries;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectAndVerifyInDB extends  BaseAPIClass{

	@Test
	public void createproject () throws SQLException
	{
		//step 1: create prerequisites
		projectLibraries plib = new projectLibraries("dhanamma","SDET39"+jlib.getRandomNumber(),"completed",20);
		
		//step 2: send the post request
		 Response resp = given()
		           .body(plib)
		           .contentType(ContentType.JSON)
		           .when()
		           .post(EndPointLibrary.createProject);
		 
		 //step 3: capture the project ID
		 String expData = rlib.getJsonData(resp, "projectId");
		 System.out.println(expData);
		 
		 //step 4: verify the project ID in database
		 String query = "select * from project";
		 String actData = dblib.executeQueryandReturnData(query,1 , expData);
		 Assert.assertEquals(actData, expData);
	}
}
