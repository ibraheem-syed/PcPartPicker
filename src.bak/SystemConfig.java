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
	private Motherboard MB;
	private Memory RAM;
	private Case chassis;
	//private Mouse mouse;
	//private Keyboard keyboard;
	//private PowerSupply power;
	//private Storage storage;
	//private Graphics gpu;
	private ArrayList<Processor> cpuInventory;
	private ArrayList<Motherboard> mbInventory;
	private ArrayList<Memory> ramInventory;
	private ArrayList<Case> chassisInventory;
	//private ArrayList<Mouse> mouseInventory;
	//private ArrayList<Keyboard> keyboardInventory;
	//private ArrayList<PowerSupply> powerInventory;
	//private ArrayList<Storage> storageInventory;
	//private ArrayList<Graphics> gpuInventory;
	
	SystemConfig() throws FileNotFoundException {
		cpuInventory = Processor.genCPUS("datasheets/processors.csv");
		mbInventory = Motherboard.genMBS("datasheets/motherboards.csv");
		ramInventory = Memory.genRAMS("datasheets/memory.csv");
		chassisInventory = Case.genCases("datasheets/cases.csv");
		//mouseInventory = Mouse.genMouses("datasheets/mice.csv");
		//keyboardInventory = Keyboard.genKeyboards("datasheets/keyboards.csv");
		//powerInventory = PowerSupply.genPowerSupplies("datasheets/powersupplies.csv");
		//storageInventory = Storage.getStorages("datasheets/storages.csv");
		//gpuInventory = Graphics.getGPUS("datasheets/gpus.csv");
		
		CPU = new Processor();
		MB = new Motherboard();
		RAM = new Memory();
		chassis = new Case();
		//mouse = new Mouse();
		//keyboard = new Keyboard();
		//power = new PowerSupply();
		//storage = new Storage();
		//gpu = new Graphics();
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
	
	/*
	
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
	
	*/
		
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
		return chassis;
	}
	
	public void setCase(Case c) {
		chassis = c;
	}
	
	/*
	
	public Mouse getMouse() {
		return mouse;
	}
	
	public void setMouse(Mouse m) {
		mouse = m;
	}
	
	public Keyboard getKeyboard() {
		return keyboard;
	}
	
	public void setKeyboard(Keyboard k) {
		keyboard = k;
	}
	
	public PowerSupply getPowerSupply() {
		return power;
	}
	
	public void setPowerSupply(PowerSupply ps) {
		power = ps;
	}
	
	public Storage getStorage() {
		return storage;
	}
	
	public void setStorage(Storage s) {
		storage = s;
	}
	
	public Graphics getGPU() {
		return mouse;
	}
	
	public void setGPU(Graphics g) {
		gpu = g;
	}

*/
}
