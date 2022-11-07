import java.awt.*;  
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 

public class ComponentSelector extends JFrame {
	final static Integer DIM_MAX = 300;
	private Integer selectedIdx;
	private ArrayList<? extends Component> compArrList;
	
	private String compImgPath;
	private JButton selectButton = new JButton();
	private JFrame f = new JFrame();
	private JList cList = new JList();
	private JLabel imgLabel;
	
	private class selectButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  System.out.println("you clicked something!");
	      }
	}
	
	private class selectListener implements ListSelectionListener {

		public ArrayList<? extends Component> listenComps;
		
		selectListener(ArrayList<? extends Component> listenComps){
			this.listenComps = listenComps;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent ev) {
	        boolean adjust = ev.getValueIsAdjusting();
	        if (!adjust) {
	        	JList list = (JList) ev.getSource();
	        	selectedIdx = list.getSelectedIndex();
	        	System.out.println(listenComps.get(selectedIdx).modelName);
	        	System.out.println(listenComps.get(selectedIdx).imagePath);
	        	String newImg = "images/processors/" + listenComps.get(selectedIdx).imagePath;
	        	System.out.println(newImg);
	    		BufferedImage compImg = null;
	    	    try { compImg = ImageIO.read(new File(newImg)); }
	    	    catch (IOException e) { e.printStackTrace(); }
	    	    Integer x,y,width, height = null;
	    	    Double ratio = null;
	    	    if(compImg.getHeight() > compImg.getWidth()) {
	    	    	ratio = DIM_MAX/Double.valueOf(compImg.getHeight());
	    	    }
	    	    else { ratio = DIM_MAX/Double.valueOf(compImg.getWidth()); }
	    	    width = (int)(ratio * compImg.getWidth());
	    	    height = (int)(ratio * compImg.getHeight());
	    	    x = (450 - width)/2;
	    	    y = (400 - height)/2;
	        
	    	    Image compScaled = compImg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
	        	
	    	    imgLabel.setBounds(x,y,width,height);
	        	imgLabel.setIcon(new ImageIcon(compScaled));        	

	        }
	        else {       }
		
		}
		
	}
	
	private static ImageIcon newIcon(String filepath) {

		return null;
	}
	
	private static JLabel genImgLabel(String filepath) {
		JLabel compImgLabel = new JLabel();
		BufferedImage compImg = null;
	    try { compImg = ImageIO.read(new File(filepath)); }
	    catch (IOException e) { e.printStackTrace(); }
	    Integer x,y,width, height = null;
	    Double ratio = null;
	    if(compImg.getHeight() > compImg.getWidth()) {
	    	ratio = DIM_MAX/Double.valueOf(compImg.getHeight());
	    }
	    else { ratio = DIM_MAX/Double.valueOf(compImg.getWidth()); }
	    width = (int)(ratio * compImg.getWidth());
	    height = (int)(ratio * compImg.getHeight());
	    x = (450 - width)/2;
	    y = (400 - height)/2;
    
	    Image compScaled = compImg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
	    compImgLabel.setIcon(new ImageIcon(compScaled));
	    compImgLabel.setBounds(x,y,width,height);
	    
		return compImgLabel;
	}
	
	private static JList<String> genCompList(ArrayList<? extends Component> compArrList) {
	    
      	DefaultListModel<String> defaultList= new DefaultListModel<>();
	    for (Component  i : compArrList ) {
	    	defaultList.addElement("$" + String.format("%.2f", i.cost)+ 
	    			" - " + i.manufacturer + ", " + i.modelName);
	    }
	    JList<String> compList = new JList<>(defaultList);  
		return compList;
	}
	
 
	ComponentSelector(ArrayList<? extends Component> cArrList, SystemConfig myConfig) {  
		compArrList = cArrList;
		compArrList.sort((o1, o2) -> o1.cost.compareTo(o2.cost));
		compImgPath = "images/processors/default.jpg";
	    	   
	    selectButton.setText("Select");
	    selectButton.setBounds(550,325,100,50);
	      
	    cList = genCompList(compArrList);
	    cList.setBounds(450,50,300,250);
	    cList.addListSelectionListener(new selectListener(compArrList));
	    
	    imgLabel = genImgLabel(compImgPath);
	    
        f.add(cList);
	    f.add(imgLabel);
	    f.add(selectButton);

	    f.setSize(800,400);  
	    f.setResizable(false);
	    f.setLayout(null);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);  

	}
	
}
