package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmployeeDetails;


public class serialization {

	@Test
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		//step 1:create object of POJO class
		EmployeeDetails emp= new EmployeeDetails("dhanamma s m",123459, "TY123", "danu@gmail.com", true);
		
		//step 2:create object of object Mapper from jackson
		ObjectMapper obj=new ObjectMapper();
		
		//step 3:write value method and provide the file path
		obj.writeValue(new File(".\\Emp1.json"),emp);
	}
	
	
}
