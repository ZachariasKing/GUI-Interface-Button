package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Generally, when we want to build a GUI, we will need to build an instance of frame.
//If we extend JFrame, the TryClickMe class becomes it's own unique frame with it's own unique
//contents.
public class TryClickMe extends JFrame{
	
	//The buttons that provide function to our GUI
	private JButton buttonCounter, buttonReset;
	//The label displaying the number of clicks
	private JLabel labelCount;
	//The counter that increments each time we click the counter button
	private int clicks = 0;
	
	/**
	 * Constructor for the TryClickMe class
	 */
	public TryClickMe() {
		createView();
		
		setTitle("Click Me");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void createView() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		labelCount = new JLabel();
		labelCount.setPreferredSize(new Dimension(200, 30));
		panel.add(labelCount);
		updateCounter();
		
		buttonCounter = new JButton("Click Me");
		buttonCounter.addActionListener(new ButtonCounterActionListener());
		panel.add(buttonCounter);
		
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clicks = 0;
				updateCounter();
			}
		});
		panel.add(buttonReset);
	}

	private void updateCounter() {
		labelCount.setText("Clicked " + clicks + " times");
		
	}

	public static void main(String[] args) {
		//This will register this frame into a GUI thread
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TryClickMe().setVisible(true);;
			}
		});
		
	}
	
	private class ButtonCounterActionListener implements ActionListener{

		//This method occurs every time the button is clicked
		@Override
		public void actionPerformed(ActionEvent e) {
			clicks++;
			updateCounter();
		}
		
	}

}
