import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Creates main window present when program first launched
 * Call constructor to do this, no other methods necessary
 */

@SuppressWarnings("serial")
public class StartWindow extends JFrame
{
	/*
	 * GUI objects necessary for start window creation
	 */
	JPanel[] middlePanels;
	JButton[] middleButtons;
	JLabel runningTotal;
	JPanel northPanel;
	JPanel southPanel;
	JPanel centerPanel;
	JButton finalButton;
	JButton temp;
	JFrame incomplete = new JFrame();
	JButton close = new JButton();
	JLabel error = new JLabel();
	
	private static String currentComp;
	
	public static String getCurrentComp() {
		return currentComp;
	}

	/*
	 * Constructor creates main window
	 */
	public StartWindow()
	{
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PC Part Picker");
		
	    setResizable(false);
	    setLayout(null);
	    setLocationRelativeTo(null);
	
		setLayout(new BorderLayout());
			
		// Code for the top of borderPanel
		runningTotal = new JLabel ("Running Total: $0");
		northPanel = new JPanel ();
		northPanel.add(runningTotal);
		add(northPanel,BorderLayout.NORTH);
		
		// Code for button at bottom
		finalButton = new JButton("Calculate Total");
		finalButton.addActionListener(new ButtonListener());
		finalButton.setActionCommand("CALC");
		southPanel = new JPanel ();
		southPanel.add(finalButton);
		add(southPanel,BorderLayout.SOUTH);
		
		// Code for center borderPanel
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 3));
		
		middlePanels = new JPanel[9];
		middleButtons = new JButton[9];
		for(int i = 0; i < 9; i++)
		{
			middlePanels[i] = new JPanel();
			centerPanel.add(middlePanels[i]);
		}
		
		/*
		 * adding images to every button
		 */

		middleButtons[0] = new JButton("CPU",ImgScale.newIcon("images/" + Main.myBuild.getCPU().imagePath + "/" + Main.myBuild.getCPU().imageName,100));
		middleButtons[0].setActionCommand("CPU");
		middleButtons[0].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[0].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[1] = new JButton("MB",ImgScale.newIcon("images/" + Main.myBuild.getMB().imagePath + "/" + Main.myBuild.getMB().imageName,100));
		middleButtons[1].setActionCommand("MB");
		middleButtons[1].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[1].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[2] = new JButton("RAM",ImgScale.newIcon("images/" + Main.myBuild.getRAM().imagePath + "/" + Main.myBuild.getRAM().imageName,100));
		middleButtons[2].setActionCommand("RAM");
		middleButtons[2].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[2].setHorizontalTextPosition(SwingConstants.CENTER);
				
		middleButtons[3] = new JButton("CASE",ImgScale.newIcon("images/" + Main.myBuild.getCase().imagePath + "/" + Main.myBuild.getCase().imageName,100));
		middleButtons[3].setActionCommand("CASE");
		middleButtons[3].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[3].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[4] = new JButton("PSU",ImgScale.newIcon("images/" + Main.myBuild.getPowerSupply().imagePath + "/" + Main.myBuild.getPowerSupply().imageName,100));
		middleButtons[4].setActionCommand("PSU");
		middleButtons[4].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[4].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[5] = new JButton("GPU",ImgScale.newIcon("images/" + Main.myBuild.getGPU().imagePath + "/" + Main.myBuild.getGPU().imageName,100));
		middleButtons[5].setActionCommand("GPU");
		middleButtons[5].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[5].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[6] = new JButton("HDD",ImgScale.newIcon("images/" + Main.myBuild.getStorage().imagePath + "/" + Main.myBuild.getStorage().imageName,100));
		middleButtons[6].setActionCommand("HDD");
		middleButtons[6].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[6].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[7] = new JButton("KB", ImgScale.newIcon("images/" + Main.myBuild.getKeyboard().imagePath + "/" + Main.myBuild.getKeyboard().imageName,100));
		middleButtons[7].setActionCommand("KB");
		middleButtons[7].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[7].setHorizontalTextPosition(SwingConstants.CENTER);
		
		middleButtons[8] = new JButton("MOUSE",ImgScale.newIcon("images/" + Main.myBuild.getMouse().imagePath + "/" + Main.myBuild.getMouse().imageName,100));
		middleButtons[8].setActionCommand("MOUSE");
		middleButtons[8].setVerticalTextPosition(SwingConstants.BOTTOM);
		middleButtons[8].setHorizontalTextPosition(SwingConstants.CENTER);
		
		for(int i = 0; i < 9; i++)
		{
			middleButtons[i].addActionListener(new ButtonListener());
			middlePanels[i].add(middleButtons[i]);
		}
		
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	/*
	 * ActionListener for all buttons in main window
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			/*
			 * done, should calculate
			 */
			currentComp = e.getActionCommand();
			switch(currentComp) {
			case "CPU":
				new ComponentSelector(Main.myBuild.getCPUList(),Main.myBuild);
				break;
			case "MB":
				new ComponentSelector(Main.myBuild.getMBList(),Main.myBuild);
				break;

			case "RAM":
				new ComponentSelector(Main.myBuild.getRAMList(),Main.myBuild);
				break;
				
			case "CASE":
				new ComponentSelector(Main.myBuild.getCaseList(),Main.myBuild);
				break;
				
			case "GPU":
				new ComponentSelector(Main.myBuild.getGPUList(),Main.myBuild);
				break;
				
			case "PSU":
				new ComponentSelector(Main.myBuild.getPowerSupplyList(),Main.myBuild);
				break;
				
			case "HDD":
				new ComponentSelector(Main.myBuild.getStorageList(),Main.myBuild);
				break;
			case "MOUSE":
				new ComponentSelector(Main.myBuild.getMouseList(),Main.myBuild);
				break;
			case "KB":
				new ComponentSelector(Main.myBuild.getKeyboardList(),Main.myBuild);
				break;
			case "CALC":
				if(!CalculateTotal.defaultCheck()) {
					dispose();
					new CalculateTotal();
				}
				
				else {
					error.setText("Configuration is incomplete"); 
					error.setVerticalTextPosition(JLabel.TOP);
				    error.setHorizontalAlignment(SwingConstants.CENTER);
				    error.setSize(300,50);				
					close.setActionCommand("CLOSE");
					close.addActionListener(new ButtonListener());
					close.setText("CLOSE");
					close.setBounds(100,50,100,25);
					incomplete.add(error);
					incomplete.add(close);
					incomplete.setSize(300,140);
					incomplete.setTitle("Incomplete");
					incomplete.setResizable(false);
					incomplete.setLayout(null);
					incomplete.setLocationRelativeTo(null);
					incomplete.setVisible(true);
				}
				break;
			case "CLOSE":
				incomplete.dispose();
			}

		}
	}
}