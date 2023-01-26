package game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import game.Handler;

/**
 * UIManager class that manages the UIObjects on the main menu using an ArrayList
 * @author Matthew-Bustamante
 *
 */
public class UIManager {
	
	private Handler handler;
	private ArrayList<UIObject>objects;
	
	/**
	 * UIManager constructor
	 * @param Handler Object (Handler)
	 */
	public UIManager(Handler handler) {
		this.setHandler(handler);
		objects = new ArrayList<UIObject>();
	}
	
	/**
	 * Ticks the UI objects on the screen
	 */
	public void tick() {
		for(UIObject o : objects) {
			o.tick();
		}
	}
	
	/**
	 * Renders the UIObjects to the Screen
	 * @param Graphics Object (Graphics)
	 */
	public void render(Graphics g) {
		for(UIObject o : objects) {
			o.render(g);
		}
	}
	
	/**
	 * Checks when the mouse moves over UIObjects
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	
	/**
	 * Checks when a mouse button is released over UIObjects
	 * @param MouseEvent Object (MouseEvent)
	 */
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	
	/**
	 * Adds a UIObject to the objects ArrayList
	 * @param UIObject object (UIObject)
	 */
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	/**
	 * Removes a UIObject from the objects ArrayList
	 * @param UIObject object (UIObject)
	 */
	public void removeObejct(UIObject o) {
		objects.remove(o);
	}
	
	/**
	 * Returns the Handler Object
	 * @return Handler Object (Handler)
	 */
	public Handler getHandler() {
		return handler;
	}
	
	/**
	 * Sets a new Handler Object to UIManager
	 * @param Handler Object (Handler)
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
