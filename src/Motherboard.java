import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Processor specs class, holds info about individual processors
 * Will need to instantiate many times for each processor type
 * NOT the back-end method for processors
 */

public class Motherboard extends Component {
	public Integer socketPinCount;
	public String memoryType;
	public String formFactor;
	
	Motherboard(){
		super();
		cost = 0.0;
		socketPinCount = 462;
		formFactor = "ATX";
		imagePath = "motherboards";
	}
	
	//Processor(String man, String mod, String img, String price, String pins, String mem, String ff){
	Motherboard(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		socketPinCount = Integer.valueOf(specs[4]);
		memoryType = specs[5];
		formFactor = specs[6];
		imagePath = "motherboards";

	}
	
	public static ArrayList<Motherboard> genMBS(String filepath) throws FileNotFoundException{
		ArrayList<Motherboard> MBS = new ArrayList<Motherboard>();
		for (String s : Component.getInventoryList(filepath)) {
			MBS.add(new Motherboard(s.split(",")));
		}	
	return MBS;
	}
}
