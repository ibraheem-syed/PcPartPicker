import java.awt.BorderLayout;
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
		runningTotal = new JLabel ("Running Total: ");
		northPanel = new JPanel ();
		northPanel.add(runningTotal);
		add(northPanel,BorderLayout.NORTH);
		
		// Code for button at bottom
		finalButton = new JButton("Calculate Total");
		finalButton.addActionListener(new ButtonListener());
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

		middleButtons[0] = new JButton(ImgScale.newIcon("images/" + Main.myBuild.getCPU().imagePath + "/" + Main.myBuild.getCPU().imageName,100));
		middleButtons[0].setActionCommand("CPU");
		middleButtons[1] = new JButton(ImgScale.newIcon("images/" + Main.myBuild.getMB().imagePath + "/" + Main.myBuild.getMB().imageName,100));
		middleButtons[1].setActionCommand("MB");
		middleButtons[2] = new JButton(ImgScale.newIcon("images/" + Main.myBuild.getRAM().imagePath + "/" + Main.myBuild.getRAM().imageName,100));
		middleButtons[2].setActionCommand("RAM");
				
		middleButtons[3] = new JButton(ImgScale.newIcon("images/" + Main.myBuild.getCase().imagePath + "/" + Main.myBuild.getCase().imageName,100));
		middleButtons[3].setActionCommand("CASE");
		middleButtons[4] = new JButton("PSU");
		middleButtons[4].setActionCommand("PSU");
		middleButtons[5] = new JButton("GPU");
		middleButtons[5].setActionCommand("GPU");
		
		middleButtons[6] = new JButton("HDD");
		middleButtons[6].setActionCommand("HDD");
		middleButtons[7] = new JButton("KB");
		middleButtons[7].setActionCommand("KB");
		middleButtons[8] = new JButton("MOUSE");
		middleButtons[8].setActionCommand("MOUSE");
		
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
			/*
			case "MOUSE":
				new ComponentSelector(Main.myBuild.getMouseList(),Main.myBuild);
				break;
			case "KEYBOARD":
				new ComponentSelector(Main.myBuild.getKeyboardList(),Main.myBuild);
				break;
			case "PSU":
				new ComponentSelector(Main.myBuild.getPowerSupplyList(),Main.myBuild);
				break;
			case "HDD
			*/
			}
		
//			if( == finalButton)
//			{
//				//TODO
//				System.out.println(Main.myBuild.getCPU().modelName);
//			}

		}
	}
}