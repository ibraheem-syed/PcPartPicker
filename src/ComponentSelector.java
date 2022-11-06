import java.awt.*;  
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 

public class ComponentSelector extends JFrame {
	final Integer DIM_MAX = 300;
	

	ComponentSelector(ArrayList<? extends Component> compArrList) {  
		
		compArrList.sort((o1, o2) -> o1.cost.compareTo(o2.cost));
		
	    JFrame f=new JFrame();
	    JLabel compLabel = new JLabel();
	    String compImgPath = "images/default.jpg";
//	    String compImgPath = "images/processors/12gen-i5.jpg";
	    BufferedImage compImg = null;
	    try { compImg = ImageIO.read(new File(compImgPath)); }
	    catch (IOException e) { e.printStackTrace(); }
	    Integer width, height = null;
	    Double ratio = null;
	    if(compImg.getHeight() > compImg.getWidth()) {
	    	ratio = DIM_MAX/Double.valueOf(compImg.getHeight());
	    }
	    else { ratio = DIM_MAX/Double.valueOf(compImg.getWidth()); }
	    
	    System.out.println(ratio);
	    width = (int)(ratio * compImg.getWidth());
	    height = (int)(ratio * compImg.getHeight());
	    System.out.println(width);
	    System.out.println(height);

	    Image compScaled = compImg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
	    compLabel.setIcon(new ImageIcon(compScaled));
	    compLabel.setBounds(50,50,width,height);
	    
		DefaultListModel<String> compList= new DefaultListModel<>();
	    for (Component  i : compArrList ) {
	    	compList.addElement("$" + String.format("%.2f", i.cost)+ " - " + i.manufacturer + ", " + i.modelName);

	    }
	    
        JList<String> list = new JList<>(compList);
        list.setBounds(425,25,350,350);
	    f.add(list);
	    f.add(compLabel);

	    f.setSize(800,400);  
	    f.setLayout(null);
	    f.setLocationRelativeTo(null);
	    f.setVisible(true);  
	    
	    System.out.println(compList.get(5));
	    System.out.println(compArrList.get(5).modelName);
	}
	
}
