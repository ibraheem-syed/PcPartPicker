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
	private Mouse MOUSE;
	private Keyboard KB;
	private PowerSupply PSU;
	private Storage HDD;
	private Graphics GPU;
	private ArrayList<Processor> cpuInventory;
	private ArrayList<Motherboard> mbInventory;
	private ArrayList<Memory> ramInventory;
	private ArrayList<Case> chassisInventory;
	private ArrayList<Mouse> mouseInventory;
	private ArrayList<Keyboard> keyboardInventory;
	private ArrayList<PowerSupply> powerInventory;
	private ArrayList<Storage> storageInventory;
	private ArrayList<Graphics> gpuInventory;
	
	SystemConfig()throws FileNotFoundException {
		cpuInventory = Processor.genCPUS("datasheets/processors.csv");
		mbInventory = Motherboard.genMBS("datasheets/motherboards.csv");
		ramInventory = Memory.genRAMS("datasheets/memory.csv");
		chassisInventory = Case.genCASES("datasheets/cases.csv");
		mouseInventory = Mouse.genMICE("datasheets/mice.csv");
		keyboardInventory = Keyboard.genKBS("datasheets/keyboards.csv");
		powerInventory = PowerSupply.genPSUS("datasheets/powersupplies.csv");
		storageInventory = Storage.genHDDS("datasheets/storages.csv");
		gpuInventory = Graphics.genGPUS("datasheets/gpus.csv");
		
		CPU = new Processor();
		MB = new Motherboard();
		RAM = new Memory();
		CHASSIS = new Case();
		MOUSE = new Mouse();
		KB = new Keyboard();
		PSU = new PowerSupply();
		HDD = new Storage();
		GPU = new Graphics();
	}
	
	public Double getRunningTotal() {
		return CPU.getCost() + MB.getCost() + RAM.getCost() +
				CHASSIS.getCost() + MOUSE.getCost() + KB.getCost() +
				PSU.getCost() + HDD.getCost() + GPU.getCost();
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

	public ArrayList<Mouse> getMouseList() {
		return mouseInventory;
	}
	
	public ArrayList<Keyboard> getKeyboardList() {
		return keyboardInventory;
	}
	
	public ArrayList<PowerSupply> getPowerSupplyList() {
		return powerInventory;
	}
	
	public ArrayList<Storage> getStorageList() {
		return storageInventory;
	}
	
	public ArrayList<Graphics> getGPUList() {
		return gpuInventory;
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
	
	public Mouse getMouse() {
		return MOUSE;
	}
	
	public void setMouse(Mouse m) {
		MOUSE = m;
	}
	
	public Keyboard getKeyboard() {
		return KB;
	}
	
	public void setKeyboard(Keyboard k) {
		KB = k;
	}
	
	public PowerSupply getPowerSupply() {
		return PSU;
	}
	
	public void setPowerSupply(PowerSupply ps) {
		PSU = ps;
	}
	
	public Storage getStorage() {
		return HDD;
	}
	
	public void setStorage(Storage s) {
		HDD = s;
	}
	
	public Graphics getGPU() {
		return GPU;
	}
	
	public void setGPU(Graphics g) {
		GPU = g;
	}
}
