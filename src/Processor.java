import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Processor specs class, holds info about individual processors
 * Will need to instantiate many times for each processor type
 * NOT the back-end method for processors
 */

public class Processor extends Component {
	public Double clockSpeed;
	public Integer coreCount;
	public Integer socketPinCount;
	
	Processor(){
		super();
		cost = 0.0;
		clockSpeed = 1.0;
		coreCount = 8;
		socketPinCount = 775;
		imagePath = "processors";
	}
	
	//Processor(String man, String mod, String img, String price, String clock, String cores, String pins){
	Processor(String specs[]){
		super(specs[0],specs[1],specs[2],specs[3]);
		clockSpeed = Double.valueOf(specs[4]);
		coreCount = Integer.valueOf(specs[5]);
		socketPinCount = Integer.valueOf(specs[6]);
		imagePath = "processors";
	}
	
	public static ArrayList<Processor> genSkus (String filepath) throws FileNotFoundException{
		File file = new File(filepath);
		System.out.println(filepath);
		Scanner input = new Scanner(file);
		ArrayList<Processor> CPUS = new ArrayList<Processor>();
		while (input.hasNextLine()) {
		   CPUS.add(new Processor(input.nextLine().split(",")));
		    
		}	
		input.close();
		
		for(Processor i : CPUS) {
			System.out.println(i.manufacturer);
			System.out.println(i.modelName);
			System.out.println(i.cost);
			System.out.println(i.imagePath);
			System.out.println(i.clockSpeed);
			System.out.println(i.coreCount);
			System.out.println(i.socketPinCount);
			System.out.println();
		}
	return CPUS;
	}
}
