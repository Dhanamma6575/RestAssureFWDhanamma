package GenericLibraries;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * This class will contains basic configuration annotations
 * @author iresh udda
 *
 */
public class BaseAPIClass {

	public DatabaseLibrary dblib = new DatabaseLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public RestAssuredLibrary rlib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bcConfig() throws SQLException
	{
		
		dblib.connectToDB();
		Reporter.log("=====db connection successfull====", true);
		
	     baseURI = IConstantsLibrary.appURL;
	      port = IConstantsLibrary.appPort;
	     
	}
	
	@AfterSuite
	public void asConfig() throws SQLException 
	{
		dblib.closeDB();
		Reporter.log("====db closed====",true);
		
	}
	
}
