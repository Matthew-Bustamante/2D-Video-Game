package game.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * UIObject abstract class.
 * Serves as a template to add buttons to the main menu.
 * @author Sethrekar
 *
 */
public  abstract class UIObject {
	
	protected float x, y;
	protected int width,height;
	protected Rectangle bounds;
	protected boolean hovering = false;
	
	/**
	 * UIObject Constructor
	 * @param x position
	 * @param y position
	 * @param object width
	 * @param object height
	 */
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int) x, (int) y, width, height);
	}
	
	/**
	 * abstract tick method to allow for animations or movement
	 */
	public abstract void tick();
	
	/**
	 * abstract renders UIObjects to the screen
	 * @param Graphics Object (Graphics)
	 */
	public abstract void render(Graphics g);
	
	/**
	 * abstract onClick method that checks when UIObjects get clicked on
	 */
	public abstract void onClick();
	
	/**
	 * Checks if the user's mouse is hovering over a UIObject
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(), e.getY())) {
			hovering = true;
		}
		else {
			hovering = false;
		}
	}
	
	/**
	 * Checks when the user releases a mouse button on a UIObject
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void onMouseRelease(MouseEvent e) {
		if(hovering) {
			onClick();
		}
	}
	
	//Getters and Setters
	
	/**
	 * Returns the x position of an UIObject
	 * @return x position (float)
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * sets the x position of a UIObject to a new value
	 * @param new x position (float)
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * returns the y position of a UIObject to a new value
	 * @return y position (float)
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * sets the y position of a UIObejct to a new value
	 * @param new y position (float)
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Returns the width of a UIObject
	 * @return UIObject width (int)
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * sets the width of a UIObject to a new value
	 * @param new width (int)
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * returns the height of a UIObject
	 * @return UIObject height (int)
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * sets the height of a UIObject to a new value
	 * @param new height (int)
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * returns boolean if mouse is hovering
	 * @return true if mouse is hovering.
	 * False if mouse is not hovering
	 */
	public boolean isHovering() {
		return hovering;
	}
	
	/**
	 * Sets the hovering variable to true or false
	 * @param set true if UIObject is being hovered on. 
	 * Set to false if UIObject is not being hovered on.
	 */
	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	
	
}
