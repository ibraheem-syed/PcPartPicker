import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Main file, sets up other relevant classes
 */

public class Main 
{
	/*
	 * myBuild contains many important functions & lots of relevant data
	 * Can access this with myBuild.___
	 */
	static SystemConfig myBuild;
	static StartWindow buildWindow;
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException 
	{
		myBuild = new SystemConfig();
		
		// creates main window
		buildWindow = new StartWindow();
		
	}
}
