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
	private String compatError;
	private Processor CPU;
	private Motherboard MB;
	private Memory RAM;
	private Case CHASSIS;
	private ArrayList<Processor> cpuInventory;
	private ArrayList<Motherboard> mbInventory;
	private ArrayList<Memory> ramInventory;
	private ArrayList<Case> chassisInventory;
	
	SystemConfig()throws FileNotFoundException {
		cpuInventory = Processor.genCPUS("datasheets/processors.csv");
		mbInventory = Motherboard.genMBS("datasheets/motherboards.csv");
		ramInventory = Memory.genRAMS("datasheets/memory.csv");
		chassisInventory = Case.genCases("datasheets/cases.csv");
		
		CPU = new Processor();
		MB = new Motherboard();
		RAM = new Memory();
		CHASSIS = new Case();
	}
	
	public void setCompatError(String error) {
		compatError = error;
	}
	
	public String getCompatError() {
		return compatError;
	}
	
	public ArrayList<Motherboard> getMBList() {
		return mbInventory;
	}
	
	public ArrayList<Memory> getRAMList() {
		return ramInventory;
	}
	
	public ArrayList<Processor> getCPUList() {
		return cpuInventory;
	}
	
	public ArrayList<Case> getCaseList() {
		return chassisInventory;
	}
		
	public Processor getCPU() {
		return CPU;
	}

	public void setCPU(Processor cpu) {
		CPU = cpu;
	}
	
	public Motherboard getMB() {
		return MB;
	}

	public void setMB(Motherboard mb) {
		MB = mb;
	}

	public Memory getRAM() {
		return RAM;
	}

	public void setRAM(Memory ram) {
		RAM = ram;
	}
	public Case getCase() {
		return CHASSIS;
	}
	
	public void setCase(Case c) {
		CHASSIS = c;
	}
}
