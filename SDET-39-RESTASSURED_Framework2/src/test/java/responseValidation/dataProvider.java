package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOLibraries.projectLibraries;
import io.restassured.http.ContentType;

public class dataProvider {

	@Test(dataProvider="getData")
	public void dataProvider(String createBy,String projectName,String status,int teamSize)
	{
		baseURI = "http://localhost";
		port = 8084;
		
		Random ran= new Random();
		int random = ran.nextInt();
		
		projectLibraries plib= new projectLibraries(createBy, projectName, status, teamSize);
		
		
	given()
	.body(plib)
	.contentType(ContentType.JSON)
	
	//Actions
	.when()
	.post("/addProject");
	
	//validation
//	.then().log().all();
	}
	
	
	@DataProvider(name="getData")
	public Object[][] dataprovider()
	{
		Object[][] data = new Object[10][4];
		data[0][0]="dhanamma";
		data[0][1]="dell-";
		data[0][2]="completed";
		data[0][3]=12;
		
		data[1][0]="nagini";
		data[1][1]="apple";
		data[1][2]="completed";
		data[1][3]=12;
		
		data[2][0]="dhanamma";
		data[2][1]="HCL";
		data[2][2]="completed";
		data[2][3]=12;
		
		data[3][0]="dhanamma";
		data[3][1]="HP";
		data[3][2]="startde";
		data[3][3]=12;
		
		data[4][0]="vaiju";
		data[4][1]="dell";
		data[4][2]="completed";
		data[4][3]=12;
		
		data[5][0]="shree";
		data[5][1]="dell";
		data[5][2]="completed";
		data[5][3]=12;
		
		data[6][0]="nagini";
		data[6][1]="dell";
		data[6][2]="completed";
		data[6][3]=12;
		
		data[7][0]="dhanamma";
		data[7][1]="IBM";
		data[7][2]="completed";
		data[7][3]=22;
		
		data[8][0]="Ayush";
		data[8][1]="dell";
		data[8][2]="completed";
		data[8][3]=12;
		
		data[9][0]="dhanamma";
		data[9][1]="hp";
		data[9][2]="on-going";
		data[9][3]=25;
		
		
		return data;
		
	}
}
