package engine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* Containers for game areas*/
	
	public Window(int width, int height, String title, SnakeGame game) {
		
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(height, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
		game.start();
	}
	
	/*Add a new graphics zone*/
	public void addZone(Rectangle r) {
		
	}
	public void removeZone(Rectangle r) {
		
	}
	
}