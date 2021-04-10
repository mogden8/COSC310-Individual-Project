package assignment2;

import javax.swing.JFrame;

import javax.swing.JFrame;

/*
 * Creates window which everything will be added to
 * Constructor takes width and height of the screen as
 */

public class Window {
	
	public Window(int w, int h) {
		JFrame frame = new JFrame("Gym Helpline");
		Contents c = new Contents(w, h);
		
		frame.add(c);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
	}

}