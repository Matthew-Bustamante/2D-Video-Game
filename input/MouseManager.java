package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.ui.UIManager;

/**
 * MouseManager Class that manages mouse inputs from the user
 * @author Matthew-Bustamante
 *
 */
public class MouseManager implements MouseListener, MouseMotionListener{
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	/**
	 * MouseManager Constructor
	 */
	public MouseManager() {
		
	}
	
	/**
	 * Sets the UIManager
	 * @param UIManager object (UIManager)
	 */
	public void setUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	//Getters
	
	/**
	 * checks if the left mouse button is pressed
	 * @return True if left mouse button is press.
	 * Returns False if left mouse button is not pressed
	 */
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	/**
	 * checks if the right mouse button is pressed
	 * @return True if right mouse button is pressed
	 * Returns False if left mouse button is not pressed
	 */
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	/**
	 * returns the x position of the mouse
	 * @return x position (int)
	 */
	public int getMouseX() {
		return mouseX;
	}
	
	/**
	 * returns the y position of the mouse
	 * @return y position (int)
	 */
	public int getMouseY() {
		return mouseY;
	}
	
	//Implemented methods

	
	/**
	 * @Override
	 * Checks if the mouse is being dragged by the user
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @Override
	 * checks if the mouse was moved by the user
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null) {
			uiManager.onMouseMove(e);
		}
	}

	
	/**
	 * @Override
	 * checks a if the user clicked something with the mouse
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @Override
	 * checks if a UIbutton is being pressed by the user
	 * @param MouseEvent object (MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}
		
	}

	
	/**
	 * @Override
	 * checks if the mouse got released on the mouse
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}
		
		if(uiManager != null) {
			uiManager.onMouseRelease(e);
		}
		
	}

	
	/**
	 * @Override
	 * Checks if a mouse has entered a screen
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @Override
	 * Checks if a mouse has left a screen
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
