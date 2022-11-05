import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PcPartPicker extends JFrame 
{
	JPanel[] middlePanels;
	JButton[] middleButtons;
	JLabel runningTotal;
	JPanel northPanel;
	JPanel southPanel;
	JPanel centerPanel;
	JButton finalButton;
	JButton temp;
	public PcPartPicker()
	{
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PC Part Picker");
	
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
		
		for(int i = 0; i < 9; i++)
		{
			middleButtons[i] = new JButton(new ImageIcon("tate.PNG"));
			middlePanels[i].add(middleButtons[i]);
		}
		
		add(centerPanel,BorderLayout.CENTER);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			if (e.getSource() == finalButton)
			{
				System.out.println("testd");
			}
		}
	}
}
