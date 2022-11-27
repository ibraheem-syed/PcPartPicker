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
	    	  Integer idx = 0;
	    	  String imgPath = "images/" + compArrList.get(selectedIdx).imagePath + "/" + compArrList.get(selectedIdx).imageName;
	    	  switch(StartWindow.getCurrentComp()) {
		    	  case "CPU":
		    		  Main.myBuild.setCPU((Processor) compArrList.get(selectedIdx));
		    		  idx = 0;
		    		  break;
		    	  case "MB":
		    		  Main.myBuild.setMB((Motherboard) compArrList.get(selectedIdx));
		    		  idx = 1;
		    		  break;
		    	  case "RAM":
		    		  Main.myBuild.setRAM((Memory) compArrList.get(selectedIdx));
		    		  idx = 2;
		    		  break;
	    	  }
	    	  Main.buildWindow.middleButtons[idx].setIcon(ImgScale.newIcon(imgPath,100));
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
