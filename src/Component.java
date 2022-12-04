import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Abstract class containing fields present in all computer part types
 * Extend this class whenever making a new type of component (specs info)
 */

public abstract class Component
{
	public String manufacturer;
	public String modelName;
	public String imageName;
	public String imagePath;
	public Double cost;

	
	Component()
	{	
		manufacturer = "manufacturer";
		modelName = "DEFAULT";
		imageName = "default.png";
		cost = 0.0;
	}
	
	Component(String man, String mod, String img, String price)
	{
		manufacturer = man;
		modelName = mod;
		imageName = img;
		cost = Double.valueOf(price);
	}
	
	public static ArrayList<String> getInventoryList (String filepath) throws FileNotFoundException{
		File file = new File(filepath);
		Scanner input = new Scanner(file);
		ArrayList<String> compInventory = new ArrayList<String>();
		while (input.hasNextLine()) {
			compInventory.add(input.nextLine());
		}	
		input.close();
		return compInventory;
	}
	
	
	public String getImageName()
	{
		return imageName;
	}
	
	public String getImagePath()
	{
		return imagePath;
	}
	
	public Double getCost()
	{
		return cost;
	}
}
