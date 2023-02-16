package game.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import display.graphics.Assets;
import display.graphics.Text;
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
	private int invListCenterX = 161;
	private int invListCenterY = 151;
	private int invListSpacing = 30;
	
	private int invImageX = 452, invImageY = 82, invImageWidth = 64, invImageHeight = 64;
	private int invCountX = 452;
	private int invCountY = 172;
	
	private int selectedItem = 0;
	
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
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			selectedItem --;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			selectedItem ++;
		}
		
		if(selectedItem < 0) {
			selectedItem = inventoryItems.size() - 1;
		}
		else if(selectedItem >= inventoryItems.size()) {
			selectedItem = 0;
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
		
		//Text.drawString(g, ">Wood<" ,invListCenterX, invListCenterY, false, Color.WHITE, Assets.font28);
		int len = inventoryItems.size();
		if(len == 0) {
			return;
		}
		
		for(int i = -5; i <6; i++) {
			if(selectedItem + i < 0 || selectedItem + i >= len) {
				continue;
			}
			if(i == 0) {
			Text.drawString(g, ">" + inventoryItems.get(selectedItem + i).getName(), invListCenterX, invListCenterY + i * invListSpacing, false, Color.YELLOW, Assets.font28);
	
			}
			else {
			Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, invListCenterY + i * invListSpacing, false, Color.WHITE, Assets.font28);

			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, false, Color.BLACK, Assets.font28);
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

	public boolean isActive() {
		return active;
	}

	
}
