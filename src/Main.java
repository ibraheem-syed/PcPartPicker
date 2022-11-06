import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File file = new File("datasheets/processors.csv");
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
		
		new ComponentSelector(CPUS);

	}

}
