import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CompatabilityCheck extends JFrame {
	
	public static void cpu(Processor proc) {
		String imgPath = "images/" + Main.myBuild.getCPU().imagePath + "/" + Main.myBuild.getCPU().imageName;	
		if(
			Main.myBuild.getMB().socketPinCount.equals("DEFAULT") ||
			Main.myBuild.getMB().socketPinCount.equals(proc.socketPinCount)
		)
			
		{
			Main.myBuild.setCPU(proc);
			imgPath = "images/" + proc.imagePath + "/" + proc.imageName;	
			System.out.println(Main.myBuild.getMB().socketPinCount);
		}
		else {
			
			CompatibilityCheck();
			System.out.println("doing nothing");

		}
		Main.buildWindow.middleButtons[0].setIcon(ImgScale.newIcon(imgPath,100));
	}
	
	public static void mb(Motherboard mobo) {
		String imgPath = "images/" + Main.myBuild.getMB().imagePath + "/" + Main.myBuild.getMB().imageName;
		System.out.println();
		System.out.println("MB Socket " + mobo.socketPinCount);
		System.out.println("CPU Socket " + Main.myBuild.getCPU().socketPinCount);
		if(
			(Main.myBuild.getCPU().socketPinCount.equals("DEFAULT") ||
			Main.myBuild.getCPU().socketPinCount.equals(mobo.socketPinCount)) 
			
			&&
			
			(Main.myBuild.getRAM().memoryType.equals("DEFAULT") ||
			Main.myBuild.getRAM().memoryType.equals(mobo.memoryType))
			
		)

		{
			Main.myBuild.setMB(mobo);
			imgPath = "images/" + mobo.imagePath + "/" + mobo.imageName;			
		}
		
		else {
			
			CompatibilityCheck();
			System.out.println("doing nothing");

		}

		Main.buildWindow.middleButtons[1].setIcon(ImgScale.newIcon(imgPath,100));
	}
	

	
	public static void ram(Memory ddr) {
		String imgPath = "images/" + Main.myBuild.getRAM().imagePath + "/" + Main.myBuild.getRAM().imageName;
		if (
			Main.myBuild.getMB().memoryType.equals("DEFAULT") ||
			Main.myBuild.getMB().memoryType.equals(ddr.memoryType)
		)
			
		{
			Main.myBuild.setRAM(ddr);
			imgPath = "images/" + ddr.imagePath + "/" + ddr.imageName;
		}
			
		else {
			
			CompatibilityCheck();
			System.out.println("doing nothing");

		}

		
		Main.buildWindow.middleButtons[2].setIcon(ImgScale.newIcon(imgPath,100));
	}
	

	public static void CompatibilityCheck() {
		System.out.println("not compatible");
	}
}
