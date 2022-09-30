package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practice_POJO_SerDes.EmployeeDetails;

public class Deserialization {

	@Test
	public void DeserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		//step 1: create object of object mapper
		ObjectMapper obj= new ObjectMapper();
		
		//step 2: read tha values from object mapper class
		EmployeeDetails emp = obj.readValue(new File(".\\Emp.json"), EmployeeDetails.class);
		
		//step 3: access the value using reference
		System.out.println(emp.getEmail());
		emp.setName("SDET");
	}
}
