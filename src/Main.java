import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		Processor myCPU = new Processor();
		System.out.println(myCPU.modelName);
		System.out.println(myCPU.manufacturer);
		System.out.println(myCPU.imagePath);
		System.out.println(myCPU.cost);
		System.out.println(myCPU.clockSpeed);
		System.out.println(myCPU.coreCount);
		System.out.println(myCPU.socketPinCount);
		
		File file = new File("datasheets/processors.txt");
		Scanner input = new Scanner(file);
		List<String> list = new ArrayList<String>();

		while (input.hasNextLine()) {
		    list.add(input.nextLine());
		}
		
		input.close();
		String entryOne = new String(list.get(0));
		String[] specs = entryOne.split(",");

		Processor myCPUtwo = new Processor(
				specs[0],
				specs[1],
				specs[2],
				Double.parseDouble(specs[3]),
				Double.parseDouble(specs[4]),
				Integer.parseInt(specs[5]),
				Integer.parseInt(specs[6])
				);
		
		System.out.println(myCPUtwo.modelName);
		System.out.println(myCPUtwo.manufacturer);
		System.out.println(myCPUtwo.imagePath);
		System.out.println(myCPUtwo.cost);
		System.out.println(myCPUtwo.clockSpeed);
		System.out.println(myCPUtwo.coreCount);
		System.out.println(myCPUtwo.socketPinCount);	
	
	}

}
