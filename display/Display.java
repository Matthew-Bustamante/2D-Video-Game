package display;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * 
 * @author Matthew-Bustamante
 * Display class that creates the window display of the game
 */
public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	/**
	 * Display Constructor
	 * @param title
	 * @param width
	 * @param height
	 */
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	
	/**
	 * Creates new JFram Display
	 */
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	/**
	 * Returns the canvas
	 * @return canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}
	
	/**
	 * returns the frame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}

