import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CalculateTotal extends JFrame{
	
	private JLabel cpuLabel = new JLabel();
	private JLabel cpuMakeModelPrice = new JLabel();
	
	private JLabel mbLabel = new JLabel();
	private JLabel mbMakeModelPrice = new JLabel();
	
	private JLabel ramLabel = new JLabel();
	private JLabel ramMakeModelPrice = new JLabel();

	private JLabel caseLabel = new JLabel();
	private JLabel caseMakeModelPrice = new JLabel();
	
	private JLabel psuLabel = new JLabel();
	private JLabel psuMakeModelPrice = new JLabel();

	private JLabel gpuLabel = new JLabel();
	private JLabel gpuMakeModelPrice = new JLabel();
	
	private JLabel hddLabel = new JLabel();
	private JLabel hddMakeModelPrice = new JLabel();
	
	private JLabel kbLabel = new JLabel();
	private JLabel kbMakeModelPrice = new JLabel();
	
	private JLabel mouseLabel = new JLabel();
	private JLabel mouseMakeModelPrice = new JLabel();
	
	private JLabel totalPrice = new JLabel();
	
	private String imgPath = new String();
	private ImageIcon compIcon = new ImageIcon();
	
	JButton close = new JButton();
	
	private class closeButtonListener implements ActionListener {
				
		public void actionPerformed(ActionEvent e) 
		{  
			switch(e.getActionCommand()) {
			case "CLOSE":
				dispose();
				break;
			}
		}
	      
	}
	
	CalculateTotal(){
		
		setSize(525,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Final Config");
		setResizable(true);
	    setLayout(null);
	    setLocationRelativeTo(null);
		setVisible(true);
    	    	
    	imgPath = "images/" + Main.myBuild.getCPU().getImagePath() + "/" + Main.myBuild.getCPU().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);
	    cpuLabel.setSize(50,50);
	    cpuLabel.setLocation(25,20);
    	cpuLabel.setIcon(compIcon);

    	cpuMakeModelPrice.setText(Main.myBuild.getCPU().manufacturer + " - " + Main.myBuild.getCPU().modelName + " - $" + String.format("%.2f",Main.myBuild.getCPU().cost));
	    cpuMakeModelPrice.setSize(300,50);
	    cpuMakeModelPrice.setLocation(200,20);
	    cpuMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	  	
    	add(cpuLabel);
    	add(cpuMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getMB().getImagePath() + "/" + Main.myBuild.getMB().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    mbLabel.setSize(50,50);
	    mbLabel.setLocation(25,80);
    	mbLabel.setIcon(compIcon); 
    	
    	mbMakeModelPrice.setText(Main.myBuild.getMB().manufacturer + " - " + Main.myBuild.getMB().modelName + " - $" + String.format("%.2f",Main.myBuild.getMB().cost));
	    mbMakeModelPrice.setSize(300,50);
	    mbMakeModelPrice.setLocation(200,80);
	    mbMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	
    	add(mbLabel);
    	add(mbMakeModelPrice);

    	imgPath = "images/" + Main.myBuild.getRAM().getImagePath() + "/" + Main.myBuild.getRAM().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    ramLabel.setSize(50,50);
	    ramLabel.setLocation(25,140);
    	ramLabel.setIcon(compIcon); 
    	
    	ramMakeModelPrice.setText(Main.myBuild.getRAM().manufacturer + " - " + Main.myBuild.getRAM().modelName + " - $" + String.format("%.2f",Main.myBuild.getRAM().cost));
	    ramMakeModelPrice.setSize(300,75);
	    ramMakeModelPrice.setLocation(200,140);
	    ramMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	
    	add(ramLabel);
    	add(ramMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getCase().getImagePath() + "/" + Main.myBuild.getCase().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
		caseLabel.setSize(50,50);
		caseLabel.setLocation(25,200);
		caseLabel.setIcon(compIcon); 
		
		caseMakeModelPrice.setText(Main.myBuild.getCase().manufacturer + " - " + Main.myBuild.getCase().modelName + " - $" + String.format("%.2f",Main.myBuild.getCase().cost));
		caseMakeModelPrice.setSize(300,75);
		caseMakeModelPrice.setLocation(200,200);
		caseMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
    	add(caseLabel);
    	add(caseMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getPowerSupply().getImagePath() + "/" + Main.myBuild.getPowerSupply().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    psuLabel.setSize(50,50);
	    psuLabel.setLocation(25,260);
    	psuLabel.setIcon(compIcon); 
    	
    	psuMakeModelPrice.setText(Main.myBuild.getPowerSupply().manufacturer + " - " + Main.myBuild.getPowerSupply().modelName + " - $" + String.format("%.2f",Main.myBuild.getPowerSupply().cost));
    	psuMakeModelPrice.setSize(300,75);
    	psuMakeModelPrice.setLocation(200,260);
    	psuMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);

    	add(psuLabel);
    	add(psuMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getGPU().getImagePath() + "/" + Main.myBuild.getGPU().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    gpuLabel.setSize(50,50);
	    gpuLabel.setLocation(25,320);
    	gpuLabel.setIcon(compIcon); 
    	
    	gpuMakeModelPrice.setText(Main.myBuild.getGPU().manufacturer + " - " + Main.myBuild.getGPU().modelName + " - $" + String.format("%.2f",Main.myBuild.getGPU().cost));
	    gpuMakeModelPrice.setSize(300,75);
	    gpuMakeModelPrice.setLocation(200,320);
	    gpuMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	
    	add(gpuLabel);
    	add(gpuMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getStorage().getImagePath() + "/" + Main.myBuild.getStorage().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
		hddLabel.setSize(50,50);
		hddLabel.setLocation(25,380);
		hddLabel.setIcon(compIcon); 
		
		hddMakeModelPrice.setText(Main.myBuild.getStorage().manufacturer + " - " + Main.myBuild.getStorage().modelName + " - $" + String.format("%.2f",Main.myBuild.getStorage().cost));
		hddMakeModelPrice.setSize(300,75);
		hddMakeModelPrice.setLocation(200,380);
		hddMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
    	add(hddLabel);
    	add(hddMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getKeyboard().getImagePath() + "/" + Main.myBuild.getKeyboard().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    kbLabel.setSize(50,50);
	    kbLabel.setLocation(25,440);
    	kbLabel.setIcon(compIcon); 
    	
    	kbMakeModelPrice.setText(Main.myBuild.getKeyboard().manufacturer + " - " + Main.myBuild.getKeyboard().modelName + " - $" + String.format("%.2f",Main.myBuild.getKeyboard().cost));
	    kbMakeModelPrice.setSize(300,75);
	    kbMakeModelPrice.setLocation(200,440);
	    kbMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	
    	add(kbLabel);
    	add(kbMakeModelPrice);
    	
    	imgPath = "images/" + Main.myBuild.getMouse().getImagePath() + "/" + Main.myBuild.getMouse().getImageName();
		compIcon = ImgScale.newIcon(imgPath,50);	
	    mouseLabel.setSize(50,50);
	    mouseLabel.setLocation(25,500);
    	mouseLabel.setIcon(compIcon); 
    	
    	mouseMakeModelPrice.setText(Main.myBuild.getMouse().manufacturer + " - " + Main.myBuild.getMouse().modelName + " - $" + String.format("%.2f",Main.myBuild.getMouse().cost));
    	mouseMakeModelPrice.setSize(300,75);
    	mouseMakeModelPrice.setLocation(200,500);
    	mouseMakeModelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    	
    	add(mouseLabel);
    	add(mouseMakeModelPrice);
    	
		close.setActionCommand("CLOSE");
		close.addActionListener(new closeButtonListener());
		close.setText("CLOSE");
		close.setBounds(300,600,125,25);
		
		add(close);
		
		totalPrice.setText("Total Price - $" + String.format("%.2f",Main.myBuild.getRunningTotal()));
		totalPrice.setBounds(100,600,150,25);
		
		add(totalPrice);

	}
	
	public static boolean defaultCheck() {
		return (
		Main.myBuild.getCPU().modelName.equals("DEFAULT") ||
		Main.myBuild.getMB().modelName.equals("DEFAULT") ||
		Main.myBuild.getRAM().modelName.equals("DEFAULT") ||
		Main.myBuild.getCase().modelName.equals("DEFAULT") ||
		Main.myBuild.getPowerSupply().modelName.equals("DEFAULT") ||
		Main.myBuild.getGPU().modelName.equals("DEFAULT") ||
		Main.myBuild.getStorage().modelName.equals("DEFAULT") ||
		Main.myBuild.getKeyboard().modelName.equals("DEFAULT") ||
		Main.myBuild.getMouse().modelName.equals("DEFAULT")
		);
	}
}
;