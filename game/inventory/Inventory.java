package game.inventory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import display.graphics.Assets;
import game.Handler;
import game.items.Item;

/**
 * Inventory class that keeps track of how many items a player has picked up
 * @author Matthew-Bustamante
 *
 */
public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 64;
	private int invY = 48;
	private int invWidth = 912/2;
	private int invHeight = 360/2;
	private int invListCenterX = invX +171;
	private int invListCenterY = invY / 2 + 5;
	
	/**
	 * Inventory constructor
	 * @param handler object (Handler)
	 */
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	/**
	 * Inventory tick method that checks if the user has the inventory open or not
	 */
	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I)) {
			active = !active;
		}
		if(!active) {
			return;
		}
		
		//Test code
		//System.out.println("INVENTORY WORKING");
		//for(Item i : inventoryItems) {
			//System.out.println(i.getName() + " " +i.getCount());
		//}
	}
	
	/**
	 * Renders the inventory to the screen
	 * @param graphics object (Graphics)
	 */
	public void render(Graphics g) {
		if(!active) {
			return;
		}
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
	}

	
	
	//Inventory methods
	
	/**
	 * Adds item to the inventory.
	 * Checks if the item added is already in the inventory if so increase the amount for that item.
	 * If the item added is a new item then it adds it to the inventory with count 1.
	 * @param item
	 */
	public void addItem(Item item) {
		for(Item i :inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//GETTERS SETTERS 
	/**
	 * Returns the game Handler object
	 * @return Handler object (Handler)
	 */
	public Handler getHandler() {
		return handler;
	}
	
	/**
	 * Sets the inventory to a Handler object
	 * @param handler object (Handler)
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	
}
