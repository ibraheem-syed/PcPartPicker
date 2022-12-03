import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Graphics extends Component {
	Graphics(){
		super();
		cost = 0.0;
		imagePath = "graphics";
	}
	
	//Processor(String man, String mod, String img, String price, String ddr){
	Graphics(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		imagePath = "graphics";
	}
	
	public static ArrayList<Graphics> genGPUS(String filepath) throws FileNotFoundException{
		ArrayList<Graphics> GPUS = new ArrayList<Graphics>();
		for (String s : Component.getInventoryList(filepath)) {
			GPUS.add(new Graphics(s.split(",")));
		}	
	return GPUS;
	}
}
