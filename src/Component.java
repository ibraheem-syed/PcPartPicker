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
		modelName = "model";
		imageName = "image.jpg";
		cost = 0.0;
	}
	
	Component(String man, String mod, String img, String price)
	{
		manufacturer = man;
		modelName = mod;
		imageName = img;
		cost = Double.valueOf(price);
	}
	
	public String getImageName()
	{
		return imageName;
	}
	
	public String getImagePath()
	{
		return imagePath;
	}
}
