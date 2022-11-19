import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Back-end class for PC parts
 * Contains all data on what currently selected PC parts are
 * Make one instance of this class only
 * Is essentially a "main" class
 */

public class SystemConfig 
{
	/*
	 * List of currently selected objects
	 */
	private Processor CPU;
	private ArrayList<Processor> cpuInventory;
	
	SystemConfig()throws FileNotFoundException {
		cpuInventory = Processor.genSkus("datasheets/processors.csv");
	}
	
	public Processor getCPU() {
		return CPU;
	}

	public void setCPU(Processor cPU) {
		CPU = cPU;
	}
	
	public ArrayList<Processor> getCPUList() 
	{
		return cpuInventory;
	}
}
