import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		SystemConfig myBuild = new SystemConfig();

		ArrayList<Processor> CPUS = Processor.genSkus("datasheets/processors.csv");

		new ComponentSelector(CPUS,myBuild);

	}

}
