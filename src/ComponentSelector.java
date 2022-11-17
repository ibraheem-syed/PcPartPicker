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

public class ComponentSelector extends JFrame {
	private static final long serialVersionUID = 1L;
	final static Integer DIM_MAX = 300;
	final static Integer X_MAX = 450;
	final static Integer Y_MAX = 400;
	
	private Integer selectedIdx;
	private ArrayList<? extends Component> compArrList;
	
	private String compImgPath;
	private JButton selectButton = new JButton();
	private JFrame f = new JFrame();
	private JList<String> cList = new JList<String>();
	private static JLabel imgLabel = new JLabel() ;
	
	private static void newIcon(String filepath) {
		BufferedImage compImg = null;
		Integer x,y,width, height = null;
	    Double ratio = null;
	    try { compImg = ImageIO.read(new File(filepath)); }
	    catch (IOException e) { e.printStackTrace(); }   	    
	    if(compImg.getHeight() > compImg.getWidth()) {
	    	ratio = DIM_MAX/Double.valueOf(compImg.getHeight());
	    }
	    else { ratio = DIM_MAX/Double.valueOf(compImg.getWidth()); }
	    width = (int)(ratio * compImg.getWidth());
	    height = (int)(ratio * compImg.getHeight());
	    x = (X_MAX - width)/2;
	    y = (Y_MAX - height)/2;
 	    Image compScaled = compImg.getScaledInstance(width,height, Image.SCALE_SMOOTH); 	
	    imgLabel.setBounds(x,y,width,height);
    	imgLabel.setIcon(new ImageIcon(compScaled));  
		System.out.println(filepath);
	}
	
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
	        	JList<?> list = (JList<?>) ev.getSource();
	        	selectedIdx = list.getSelectedIndex();
//	        	System.out.println(listenComps.get(selectedIdx).modelName);
//	        	System.out.println(listenComps.get(selectedIdx).imagePath);
	        	String newImg = "images/" + compArrList.get(selectedIdx).getImagePath() + "/"+ compArrList.get(selectedIdx).getImageName();
//	        	System.out.println(newImg);	
	        	newIcon(newImg);
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
	    System.out.println(compImgPath);	   
	    selectButton.setText("Select");
	    selectButton.setBounds(550,325,100,50);
	      
	    cList = genCompList(compArrList);
	    cList.setBounds(450,50,300,250);
	    cList.addListSelectionListener(new selectListener(compArrList));
	    
	    newIcon(compImgPath);
	    
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
