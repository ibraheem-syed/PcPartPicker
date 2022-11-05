
public class Processor extends Component {
	public Double clockSpeed;
	public Integer coreCount;
	public Integer socketPinCount;
	
	Processor(){
		manufacturer = "manufacturer";
		modelName = "model name";
		imagePath = "path/image.jpg";
		cost = 0.0;
		clockSpeed = 1000.0;
		coreCount = 8;
		socketPinCount = 775;
	}
	
	Processor(String man, String mod, String img, Double price, Double clock, Integer cores, Integer pins){
		manufacturer = man;
		modelName = mod;
		imagePath = img;
		cost = price;
		clockSpeed = clock;
		coreCount = cores;
		socketPinCount = pins;
	}
}
