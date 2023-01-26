package game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * UIImageButton class that inherits from the UIObject class.
 * Draws a button to the main menu that allows for the user to click on to start the game
 * 
 * @author Matthew-Bustamante
 *
 */
public class UIImageButton extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;
	
	/**
	 * UIImageButton constructor
	 * @param x position (float)
	 * @param y position (float)
	 * @param width (int)
	 * @param height (int)
	 * @param images (BufferedImage)
	 * @param ClickListner Object (ClickListener)
	 */
	public UIImageButton(float x, float y, int width, int height, BufferedImage [] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	/**
	 * Tick method for animations
	 */
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Renders buton images to the screen
	 */
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		}
		else {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		}
		
	}

	@Override
	/**
	 * calls the onClick method in the ClickListner class
	 */
	public void onClick() {
		clicker.onClick();
		
	}
	
	
}
