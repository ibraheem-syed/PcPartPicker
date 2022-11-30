import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CompatabilityCheck extends JFrame {
	
	public static void mb(Motherboard mobo) {
		if(
			Main.myBuild.getFormF() != SystemConfig.formFactor.DEFAULT &&
			Main.myBuild.getPinC()  != SystemConfig.pinCount.DEFAULT &&
			Main.myBuild.getDdrX()  != SystemConfig.ram.DEFAULT
		  ) {
			  System.out.println(Main.myBuild.getFormF());
			  System.out.println(Main.myBuild.getPinC());
			  System.out.println(Main.myBuild.getDdrX());
		}
	}
	
	public static void cpu(Processor proc) {
		if(Main.myBuild.getPinC() != SystemConfig.pinCount.DEFAULT) {
			System.out.println(Main.myBuild.getPinC());
		}
	}
	
	public static void ram(Memory ddr) {
		if(Main.myBuild.getDdrX() != SystemConfig.ram.DEFAULT) {
			System.out.println(Main.myBuild.getDdrX());
		}
	}

}
