
public class Component {
	public String manufacturer;
	public String modelName;
	public String imagePath;
	public Double cost;
	
	Component(){
		manufacturer = null;
		modelName = null;
		imagePath = "default.jpg";
		cost = 0.0;
	}
	
	Component(String man, String mod, String img, String price){
		manufacturer = man;
		modelName = mod;
		imagePath = img;
		cost = Double.valueOf(price);
	}
	
}
