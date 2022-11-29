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
	
	
	enum formFactor { DEFAULT,ITX,MATX,ATX };
	enum pinCount { DEFAULT,PGA1331,LGA1700,LGA1718 }
	enum ram { DEFAULT,DDR4,DDR5 }
	
	private formFactor formF;
	private pinCount pinC;
	private ram ddrX;
	
	public void setFormF(formFactor formF) {
		this.formF = formF;
	}

	public void setPinC(pinCount pinC) {
		this.pinC = pinC;
	}

	public void setDdrX(ram ddrX) {
		this.ddrX = ddrX;
	}

	public formFactor getFormF() {
		return formF;
	}

	public pinCount getPinC() {
		return pinC;
	}

	public ram getDdrX() {
		return ddrX;
	}

	private Processor CPU;
	private Motherboard MB;
	private Memory RAM;
	private ArrayList<Processor> cpuInventory;
	private ArrayList<Motherboard> mbInventory;
	private ArrayList<Memory> ramInventory;
	
	SystemConfig()throws FileNotFoundException {
		formF = formFactor.DEFAULT;
		pinC = pinCount.DEFAULT;
		ddrX = ram.DEFAULT;
		
		cpuInventory = Processor.genCPUS("datasheets/processors.csv");
		mbInventory = Motherboard.genMBS("datasheets/motherboards.csv");
		ramInventory = Memory.genRAMS("datasheets/memory.csv");
	}
	
	public Processor getCPU() {
		return CPU;
	}

	public void setCPU(Processor cpu) {
		CPU = cpu;
	}
	
	public ArrayList<Processor> getCPUList() 
	{
		return cpuInventory;
	}
	
	
	public Motherboard getMB() {
		return MB;
	}

	public void setMB(Motherboard mb) {
		MB = mb;
	}
	
	public ArrayList<Motherboard> getMBList() 
	{
		return mbInventory;
	}
	
	public Memory getRAM() {
		return RAM;
	}

	public void setRAM(Memory ram) {
		RAM = ram;
	}
	
	public ArrayList<Memory> getRAMList() 
	{
		return ramInventory;
	}
}
