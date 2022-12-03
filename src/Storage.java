import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Storage extends Component {
	Storage(){
		super();
		cost = 0.0;
		imagePath = "storage";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	Storage(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "storage";
	}
	
	public static ArrayList<Storage> genHDDS(String filepath) throws FileNotFoundException{
		ArrayList<Storage> HDDS = new ArrayList<Storage>();
		for (String s : Component.getInventoryList(filepath)) {
			HDDS.add(new Storage(s.split(",")));
		}	
	return HDDS;
	}
}
