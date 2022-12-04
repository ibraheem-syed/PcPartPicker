import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Processor specs class, holds info about individual processors
 * Will need to instantiate many times for each processor type
 * NOT the back-end method for processors
 */

public class Memory extends Component {
	public String memoryType;
	
	Memory(){
		super();
		cost = 0.0;
		memoryType = "DEFAULT";
		imagePath = "memory";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	Memory(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		memoryType = specs[4];
		imagePath = "memory";

	}
	
	public static ArrayList<Memory> genRAMS(String filepath) throws FileNotFoundException{
		ArrayList<Memory> RAMS = new ArrayList<Memory>();
		for (String s : Component.getInventoryList(filepath)) {
			RAMS.add(new Memory(s.split(",")));
		}	
	return RAMS;
	}
}
