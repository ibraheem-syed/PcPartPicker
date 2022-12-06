import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CalculateTotal extends JFrame{
	
	private JLabel cpuLabel = new JLabel();
	private JLabel mbLabel = new JLabel();
	private JLabel ramLabel = new JLabel();
	
	private JLabel caseLabel = new JLabel();
	private JLabel psuLabel = new JLabel();
	private JLabel gpuLabel = new JLabel();
	
	private JLabel hddLabel = new JLabel();
	private JLabel kbLabel = new JLabel();
	private JLabel mouseLabel = new JLabel();
	
	private String imgPath = new String();
	private ImageIcon compIcon = new ImageIcon();
	
	private class selectButtonListener implements ActionListener {
				
		public void actionPerformed(ActionEvent e) 
		{  
		
			  
		}
	      
	}
	
	CalculateTotal(){
		
		setSize(800,960);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Final Config");
		setResizable(false);
	    setLayout(null);
	    setLocationRelativeTo(null);
		setVisible(true);
    	    	
    	imgPath = "images/" + Main.myBuild.getCPU().getImagePath() + "/" + Main.myBuild.getCPU().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    cpuLabel.setSize(75,75);
	    cpuLabel.setLocation(25,20);
    	cpuLabel.setIcon(compIcon); 
    	add(cpuLabel);
    	
    	imgPath = "images/" + Main.myBuild.getMB().getImagePath() + "/" + Main.myBuild.getMB().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    mbLabel.setSize(75,75);
	    mbLabel.setLocation(25,120);
    	mbLabel.setIcon(compIcon); 
    	add(mbLabel);

    	imgPath = "images/" + Main.myBuild.getRAM().getImagePath() + "/" + Main.myBuild.getRAM().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    ramLabel.setSize(75,75);
	    ramLabel.setLocation(25,220);
    	ramLabel.setIcon(compIcon); 
    	add(ramLabel);
    	
    	imgPath = "images/" + Main.myBuild.getCase().getImagePath() + "/" + Main.myBuild.getCase().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
		caseLabel.setSize(75,75);
		caseLabel.setLocation(25,320);
		caseLabel.setIcon(compIcon); 
    	add(caseLabel);
    	
    	imgPath = "images/" + Main.myBuild.getPowerSupply().getImagePath() + "/" + Main.myBuild.getPowerSupply().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    psuLabel.setSize(75,75);
	    psuLabel.setLocation(25,420);
    	psuLabel.setIcon(compIcon); 
    	add(psuLabel);
    	
    	imgPath = "images/" + Main.myBuild.getGPU().getImagePath() + "/" + Main.myBuild.getGPU().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    gpuLabel.setSize(75,75);
	    gpuLabel.setLocation(25,520);
    	gpuLabel.setIcon(compIcon); 
    	add(gpuLabel);
    	
    	imgPath = "images/" + Main.myBuild.getStorage().getImagePath() + "/" + Main.myBuild.getStorage().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
		hddLabel.setSize(75,75);
		hddLabel.setLocation(25,620);
		hddLabel.setIcon(compIcon); 
    	add(hddLabel);
    	
    	imgPath = "images/" + Main.myBuild.getKeyboard().getImagePath() + "/" + Main.myBuild.getKeyboard().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    kbLabel.setSize(75,75);
	    kbLabel.setLocation(25,720);
    	kbLabel.setIcon(compIcon); 
    	add(kbLabel);
    	
    	imgPath = "images/" + Main.myBuild.getMouse().getImagePath() + "/" + Main.myBuild.getMouse().getImageName();
		compIcon = ImgScale.newIcon(imgPath,75);	
	    mouseLabel.setSize(75,75);
	    mouseLabel.setLocation(25,820);
    	mouseLabel.setIcon(compIcon); 
    	add(mouseLabel);
		
	}
	
	public static boolean defaultCheck() {
		return (
		Main.myBuild.getCPU().modelName.equals("DEFAULT") &&
		Main.myBuild.getMB().modelName.equals("DEFAULT") &&
		Main.myBuild.getRAM().modelName.equals("DEFAULT") &&
		
		Main.myBuild.getCase().modelName.equals("DEFAULT") &&
		Main.myBuild.getPowerSupply().modelName.equals("DEFAULT") &&
		Main.myBuild.getGPU().modelName.equals("DEFAULT") &&
		
		Main.myBuild.getStorage().modelName.equals("DEFAULT") &&
		Main.myBuild.getKeyboard().modelName.equals("DEFAULT") &&
		Main.myBuild.getMouse().modelName.equals("DEFAULT")
		);
	}
}
