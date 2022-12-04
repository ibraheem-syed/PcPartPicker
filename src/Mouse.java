import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mouse extends Component {
	Mouse(){
		super();
		cost = 0.0;
		imagePath = "mice";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	Mouse(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "mice";
	}
	
	public static ArrayList<Mouse> genMICE(String filepath) throws FileNotFoundException{
		ArrayList<Mouse> MICE = new ArrayList<Mouse>();
		for (String s : Component.getInventoryList(filepath)) {
			MICE.add(new Mouse(s.split(",")));
		}	
	return MICE;
	}
}
