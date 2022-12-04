import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImgScale {
	
	public static Image scale(String filepath, Integer max) {
		BufferedImage compImg = null;
		Integer width, height = null;
		Double ratio = null;
	    try { compImg = ImageIO.read(new File(filepath)); }
	    catch (IOException e) { e.printStackTrace(); }   	    
	    if(compImg.getHeight() > compImg.getWidth()) {
	    	ratio = max/Double.valueOf(compImg.getHeight());
	    }
	    else { ratio = max/Double.valueOf(compImg.getWidth()); }
	    width = (int)(ratio * compImg.getWidth());
	    height = (int)(ratio * compImg.getHeight());
	    Image scaledImg = compImg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
	 return scaledImg;
	}   
	
	public static ImageIcon newIcon(String filepath, Integer max){
		Image scaled = ImgScale.scale(filepath, max);
		ImageIcon icon = new ImageIcon(scaled);
		return icon;
	}
}
