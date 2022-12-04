import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Processor specs class, holds info about individual processors
 * Will need to instantiate many times for each processor type
 * NOT the back-end method for processors
 */

public class Processor extends Component {
	public Double clockSpeed;
	public Integer coreCount;
	public String socketPinCount;
	
	Processor(){
		super();
		cost = 0.0;
		clockSpeed = 1.0;
		coreCount = 8;
		socketPinCount = "DEFAULT";
		imagePath = "processors";
	}
	
	//Processor(String man, String mod, String img, String price, String clock, String cores, String pins){
	Processor(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		clockSpeed = Double.valueOf(specs[4]);
		coreCount = Integer.valueOf(specs[5]);
		socketPinCount = specs[6];
		imagePath = "processors";
	}
	
	public static ArrayList<Processor> genCPUS(String filepath) throws FileNotFoundException{
		ArrayList<Processor> CPUS = new ArrayList<Processor>();
		for (String s : Component.getInventoryList(filepath)) {
			CPUS.add(new Processor(s.split(",")));
		}	
	return CPUS;
	}
}
