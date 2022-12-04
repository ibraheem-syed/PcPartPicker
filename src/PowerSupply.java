import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PowerSupply extends Component{

	PowerSupply(){
		super();
		cost = 0.0;
		imagePath = "power";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	PowerSupply(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "power";

	}
	
	public static ArrayList<PowerSupply> genPSUS(String filepath) throws FileNotFoundException{
		ArrayList<PowerSupply> PSUS = new ArrayList<PowerSupply>();
		for (String s : Component.getInventoryList(filepath)) {
			PSUS.add(new PowerSupply(s.split(",")));
		}	
	return PSUS;
	}
}
