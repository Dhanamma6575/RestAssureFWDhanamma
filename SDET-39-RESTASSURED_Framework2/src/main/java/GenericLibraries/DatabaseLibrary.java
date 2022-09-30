package GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


/**
 * This class contains of generic methods related to database
 * @author Dhanamma
 *
 */
public class DatabaseLibrary {

	Driver driverRef;
	Connection conn;
	/**
	 * This method will establish the connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		 conn = DriverManager.getConnection(IConstantsLibrary.dbURL, IConstantsLibrary.dbuserName, IConstantsLibrary.dbpassword); 
	}
	
	/**
	 * This method will close database connection
	 * @throws SQLException 
	 */
	public void closeDB() throws SQLException
	{
		conn.close();
	}
	
	/**
	 * This method will execute the query ,fetch the data and verify in the data in databse with excData from caller 
	 * @param query
	 * @param columnindex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryandReturnData(String query,int columnindex, String expData) throws SQLException
	{
		ResultSet result = conn.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String atcData = result.getString(columnindex);
			if(expData.equalsIgnoreCase(atcData))
			{
				 flag = true;
				break;	
			}
		}
		
		if(flag)
		{
			System.out.println("The data is verified");
			return expData;
		}
		else
		{
			System.out.println("The data is not verifies");
			return " ";
		}
		
	}
	
	
}
