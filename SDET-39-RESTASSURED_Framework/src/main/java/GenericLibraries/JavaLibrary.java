package GenericLibraries;

import java.util.Random;

/**
 * This class will contains generic methods related to java
 * @author Dhanamma
 *
 */
public class JavaLibrary {

	/**
	 * This method will return random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran =new Random();
		return ran.nextInt(200);
	}
}
