import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Keyboard extends Component {
	Keyboard(){
		super();
		cost = 0.0;
		imagePath = "keyboards";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	Keyboard(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "keyboards";
	}
	
	public static ArrayList<Keyboard> genKBS(String filepath) throws FileNotFoundException{
		ArrayList<Keyboard> KBS = new ArrayList<Keyboard>();
		for (String s : Component.getInventoryList(filepath)) {
			KBS.add(new Keyboard(s.split(",")));
		}	
	return KBS;
	}
}
