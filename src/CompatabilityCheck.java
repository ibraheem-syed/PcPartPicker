import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CompatabilityCheck extends JFrame {
	
	static JFrame f = new JFrame();
	static JButton reset = new JButton();
	static JButton cancel = new JButton();
	static JLabel error = new JLabel();
	
	public static void cpu(Processor proc) {
		String imgPath = "images/" + Main.myBuild.getCPU().imagePath + "/" + Main.myBuild.getCPU().imageName;	
		if(
			Main.myBuild.getMB().socketPinCount.equals("DEFAULT") ||
			Main.myBuild.getMB().socketPinCount.equals(proc.socketPinCount)
		)
		{
			Main.myBuild.setCPU(proc);
			imgPath = "images/" + proc.imagePath + "/" + proc.imageName;	
			Main.buildWindow.middleButtons[0].setIcon(ImgScale.newIcon(imgPath,100));
		}
		else {
			Main.myBuild.setCompatError(proc.modelName + " not compatible with current config");
			CompatibilityCheck();
		}
		
	}
	
	public static void mb(Motherboard mobo) {
		String imgPath = "images/" + Main.myBuild.getMB().imagePath + "/" + Main.myBuild.getMB().imageName;
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
			Main.buildWindow.middleButtons[1].setIcon(ImgScale.newIcon(imgPath,100));
		}
		
		else {
			Main.myBuild.setCompatError(mobo.modelName + " not compatible with current config");
			CompatibilityCheck();
		}

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
			Main.buildWindow.middleButtons[2].setIcon(ImgScale.newIcon(imgPath,100));
			
		}
			
		else {
			Main.myBuild.setCompatError(ddr.modelName + " not compatible with current config");
			CompatibilityCheck();
		}

	}
	
	private static class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			
	    	  switch(e.getActionCommand()) {
	    	  case "RESET":
	    		  Main.myBuild.setCPU(new Processor());
	    		  Main.myBuild.setMB(new Motherboard());
	    		  Main.myBuild.setRAM(new Memory());
	    		  Main.buildWindow.middleButtons[0].setIcon(ImgScale.newIcon("images/" + Main.myBuild.getCPU().imagePath + "/" + Main.myBuild.getCPU().imageName,100));
	    		  Main.buildWindow.middleButtons[1].setIcon(ImgScale.newIcon("images/" + Main.myBuild.getMB().imagePath + "/" + Main.myBuild.getMB().imageName,100));
	    		  Main.buildWindow.middleButtons[2].setIcon(ImgScale.newIcon("images/" + Main.myBuild.getRAM().imagePath + "/" + Main.myBuild.getRAM().imageName,100));	    		  
	    		  break;
	    	  case "CANCEL":
	    		  break;
	    	  }    	  
	    	  
	    	  Main.buildWindow.runningTotal.setText("Running Total: $" + String.format("%.2f", Main.myBuild.getRunningTotal()));
	    	  f.dispose();
		}
	}
	
	private static void CompatibilityCheck() {
		
		reset.setText("Reset");
	    reset.setBounds(100,120,100,40);
	    reset.addActionListener(new ButtonListener());
	    reset.setActionCommand("RESET");
	    
		cancel.setText("Cancel");
	    cancel.setBounds(400,120,100,40);
	    cancel.addActionListener(new ButtonListener());
	    cancel.setActionCommand("CANCEL");
	   	    
	    error.setText(Main.myBuild.getCompatError());
	    error.setVerticalTextPosition(JLabel.TOP);
	    error.setHorizontalTextPosition(JLabel.CENTER);
	    
	    error.setText(Main.myBuild.getCompatError());
	    error.setSize(600,100);
	    error.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    f.setLayout(new GridBagLayout());
	    
	    f.add(reset);
	    f.add(cancel);
	    f.add(error);
		
		f.setSize(600,240);
		f.setTitle("Compatbility Check");
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);		
	}

}
