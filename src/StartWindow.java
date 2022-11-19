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
		middleButtons[0] = new JButton(new ImageIcon("images/processors/default.jpg"));
	
		// TODO this is a temporary for loop below, need to implement rest like above
		for(int i = 1; i < 9; i++)
		{
			middleButtons[i] = new JButton("temp");
		}
		
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
			if(e.getSource() == finalButton)
			{
				//TODO
				System.out.println(Main.myBuild.getCPU().modelName);
			}
			/*
			 * processor
			 */
			else if(e.getSource() == middleButtons[0])
			{
				new ComponentSelector(Main.myBuild.getCPUList(),Main.myBuild);
			}
			
			//TODO
		}
	}
}