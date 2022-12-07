import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ComponentSelector extends JFrame {
	final static Integer DIM_MAX = 300;
	final static Integer X_MAX = 450;
	final static Integer Y_MAX = 400;
	
	private Integer selectedIdx = 0;
	private ArrayList<? extends Component> compArrList;
	
	private String compImgPath;
	private JButton selectButton = new JButton();
	public JFrame f = new JFrame();
	private JList<String> cList = new JList<String>();
	private static JLabel imgLabel = new JLabel() ;
	
	private static void setIcon(String filepath) {
		ImageIcon icon = ImgScale.newIcon(filepath, DIM_MAX);
		Integer x = (X_MAX - icon.getIconWidth())/2;
		Integer y = (Y_MAX - icon.getIconHeight())/2;
	    imgLabel.setSize(icon.getIconWidth(),icon.getIconHeight());
	    imgLabel.setLocation(x,y);
    	imgLabel.setIcon(icon);  
	}
	
	private class selectButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) 
	      {    	  
	    	  String imgPath;
	    	  switch(StartWindow.getCurrentComp()) {
		    	  case "CPU":
		    		  CompatabilityCheck.cpu((Processor) compArrList.get(selectedIdx));
		    		  break;
		    	  case "MB":
		    		  CompatabilityCheck.mb((Motherboard) compArrList.get(selectedIdx));
		    		  break;
		    	  case "RAM":
		    		  CompatabilityCheck.ram((Memory) compArrList.get(selectedIdx));
		    		  break;
		    	  case "CASE":
		    		  Case myCase = (Case)compArrList.get(selectedIdx);
		    		  Main.myBuild.setCase(myCase);
		              imgPath = "images/" + myCase.imagePath + "/" + myCase.imageName;
		              Main.buildWindow.middleButtons[3].setIcon(ImgScale.newIcon(imgPath,100));
		    		  break;
		    	  case "PSU":
		    		  PowerSupply PSU = (PowerSupply)compArrList.get(selectedIdx);
		    		  Main.myBuild.setPowerSupply(PSU);
		              imgPath = "images/" + PSU.imagePath + "/" + PSU.imageName;
		              Main.buildWindow.middleButtons[4].setIcon(ImgScale.newIcon(imgPath,100)); 
		    		  break;
		    	  case "GPU":
		    		  Graphics GPU = (Graphics)compArrList.get(selectedIdx);
		    		  Main.myBuild.setGPU(GPU);
		              imgPath = "images/" + GPU.imagePath + "/" + GPU.imageName;
		              Main.buildWindow.middleButtons[5].setIcon(ImgScale.newIcon(imgPath,100)); 
		    		  break;
		    	  case "HDD":
		    		  Storage HDD = (Storage)compArrList.get(selectedIdx);
		    		  Main.myBuild.setStorage(HDD);
		              imgPath = "images/" + HDD.imagePath + "/" + HDD.imageName;
		              Main.buildWindow.middleButtons[6].setIcon(ImgScale.newIcon(imgPath,100)); 
		              break;
		    	  case "MOUSE":
		    		  Mouse mouse = (Mouse)compArrList.get(selectedIdx);
		    		  Main.myBuild.setMouse(mouse);
		              imgPath = "images/" + mouse.imagePath + "/" + mouse.imageName;
		              Main.buildWindow.middleButtons[8].setIcon(ImgScale.newIcon(imgPath,100)); 
		              break;
		    	  case "KB":
		    		  Keyboard keyboard = (Keyboard)compArrList.get(selectedIdx);
		    		  Main.myBuild.setKeyboard(keyboard);
		    		  imgPath = "images/" + keyboard.imagePath + "/" + keyboard.imageName;
		    		  Main.buildWindow.middleButtons[7].setIcon(ImgScale.newIcon(imgPath,100));
		    		  break;
		    	  
	    	  }   
	    	  Main.buildWindow.runningTotal.setText("Running Total: $" + String.format("%.2f", Main.myBuild.getRunningTotal()));
	    	  f.dispose();
	      }
	}
	
	private class selectListener implements ListSelectionListener {

		@SuppressWarnings("unused")
		public ArrayList<? extends Component> listenComps;
		
		selectListener(ArrayList<? extends Component> listenComps){
			this.listenComps = listenComps;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent ev) {
	        boolean adjust = ev.getValueIsAdjusting();
	        if (!adjust) {
	        	JList<?> list = (JList<?>) ev.getSource();
	        	selectedIdx = list.getSelectedIndex();
	        	String newImg = "images/" + compArrList.get(selectedIdx).getImagePath() + "/"+ compArrList.get(selectedIdx).getImageName();
	        	setIcon(newImg);
	        }
	        else {       }
		}
	}
	
	private static JList<String> genCompList(ArrayList<? extends Component> compArrList) {
	    
      	DefaultListModel<String> defaultList= new DefaultListModel<>();
	    for (Component  i : compArrList ) {
	    	defaultList.addElement("$" + String.format("%.2f", i.cost)+ 
	    			" - " + i.manufacturer + ", " + i.modelName);
	    }
	    JList<String> compList = new JList<>(defaultList);
	    compList.setSelectedIndex(0);
		return compList;
	}
 
	ComponentSelector(ArrayList<? extends Component> cArrList, SystemConfig myConfig) {  
		compArrList = cArrList;
		compArrList.sort((o1, o2) -> o1.cost.compareTo(o2.cost));
		compImgPath = "images/" + compArrList.get(0).getImagePath() + "/"+ compArrList.get(0).getImageName();
		selectButton.addActionListener(new selectButtonListener());
	    selectButton.setText("Select");
	    selectButton.setBounds(550,325,100,50);
	      
	    cList = genCompList(compArrList);
	    cList.setBounds(450,50,300,250);
	    cList.addListSelectionListener(new selectListener(compArrList));
	    
	    setIcon(compImgPath);
	    
        f.add(cList);
	    f.add(imgLabel);
	    f.add(selectButton);

	    f.setSize(800,440);  
	    f.setResizable(false);
	    f.setLayout(null);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);  
	}
	
}
