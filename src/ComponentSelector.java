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
	public Integer selectedIdx;
	
	private class selectButtonListener implements ActionListener {
	      public void actionPerformed(ActionEvent e)
	      { 
	    	  System.out.println("you clicked something!");
	      }
	}
	
	private class selectListener implements ListSelectionListener {

		public ArrayList<? extends Component> listenComps;
		
		selectListener(ArrayList<? extends Component>  listenComps){
			this.listenComps = listenComps;
		}
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
	        boolean adjust = e.getValueIsAdjusting();
	        if (!adjust) {
	        	JList list = (JList<?>) e.getSource();
	        	selectedIdx = list.getSelectedIndex();
	        	System.out.println(listenComps.get(selectedIdx).modelName);
	        }
	        else {       }
		
		}
		
	}
	
	public static JLabel genImgLabel(String filepath) {
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
 
	ComponentSelector(ArrayList<? extends Component> compArrList) {  
		
		compArrList.sort((o1, o2) -> o1.cost.compareTo(o2.cost));
		
	    JFrame f=new JFrame();
	    JLabel compLabel = new JLabel();
	    JButton selectButton = new JButton("Select");
	    String compImgPath = "images/default.jpg";
	   	    
	    selectButton.setBounds(550,325,100,50);
      
		DefaultListModel<String> compList= new DefaultListModel<>();
	    for (Component  i : compArrList ) {
	    	compList.addElement("$" + String.format("%.2f", i.cost)+ " - " + i.manufacturer + ", " + i.modelName);

	    }
	    
        JList<String> list = new JList<>(compList);      
        list.setBounds(450,50,300,250);
        list.addListSelectionListener(new selectListener(compArrList));
        
	    f.add(list);
//	    f.add(compLabel);
	    f.add(genImgLabel(compImgPath));
	    f.add(selectButton);

	    f.setSize(800,400);  
	    f.setResizable(false);
	    f.setLayout(null);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);  

	}
	
}
