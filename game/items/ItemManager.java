package game.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import game.Handler;

/**
 * ItemManager class that manages Items in the game.
 * ItemManager removes items from the screen if the player consumes or adds item to inventory.
 * ItemManager adds items to the screen when an entity drops an item.
 * ItemManager keeps track of the amount of items on the screen.
 * @author Matthew-Bustamante
 *
 */
public class ItemManager {
	
	private Handler handler;
	private ArrayList<Item> items;
	
	/**
	 * ItemManager constructor
	 * @param Handler Object
	 */
	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	/**
	 * Checks searches items ArrayList and ticks all items.
	 * Also removes items from items ArrayList when item is picked up by the player.
	 */
	public void tick() {
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPickedUp()) {
				it.remove();
			}
		}
	}
	
	
	/**
	 * Renders all items in the items ArrayList to the screen
	 * @param Graphics Object (Graphics)
	 */
	public void render(Graphics g) {
		for(Item i : items) {
			i.render(g);
		}
	}
	
	/**
	 * adds an item to the items ArrayList
	 * @param Item Object (Item)
	 */
	public void addItem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}
	
	//GETTERS and SETTERS
	
	/**
	 * Returns the Handler Object
	 * @return Handler Object (Handler)
	 */
	public Handler getHandler() {
		return handler;
	}
	
	/**
	 * Sets Handler object to a new Handler Obejct
	 * @param Handler Object
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
