package game.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.graphics.Assets;
import game.Handler;

/**
 * Item class that allows for items to be created.
 * Items have a texture, animations if needed and can be drop from entities in the game
 * @author Matthew-Bustamante
 *
 */
public class Item {
	
	//Handler
	
	public static Item[] items = new Item [256];
	public static Item woodItem = new Item(Assets.wood, "Wood", 0);
	
	//Class
	public static final int ITEMWIDTH = 32, ITEMHEIGHT =32, PICKED_UP = -1;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected int x, y, count;
	
	/**
	 * Item constructor
	 * @param texture (BufferedImage)
	 * @param item name
	 * @param item id (int)
	 */
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		items[id] = this;
	}
	
	/**
	 * Tick method for items. Used for animations or items that want to move
	 */
	public void tick() {
		
	}
	
	/**
	 * Renders the item to the screen.  
	 * method returns if texture can't be found
	 * @param Graphics object
	 */
	public void render(Graphics g) {
		if(handler == null) {
			return;
		}
		render(g,(int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()));
	}
	
	/**
	 * Second render method that renders item to the screen
	 * @param Graphics Object (Graphics)
	 * @param x position (int)
	 * @param y position (int)
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	/**
	 * Sets Item x and y position on screen
	 * @param x position (int)
	 * @param y position (int)
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a new item 
	 * @param x position (int)
	 * @param y position (int)
	 * @return Item Object
	 */
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	//GETTERS and SETTERS
	
	/**
	 * Returns the Handler object
	 * @return Handler Object (Handler)
	 */
	public Handler getHandler() {
		return handler;
	}
	
	/**
	 * Sets the Handler Object
	 * @param Handler Object (Handler)
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * Returns item texture
	 * @return item texture (BufferedImage)
	 */
	public BufferedImage getTexture() {
		return texture;
	}
	
	/**
	 * Sets item texture to a new texture
	 * @param item texture (BufferedImage)
	 */
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
	/**
	 * Returns the x position of an item
	 * @return x position (int)
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * sets the item x position to a new x position
	 * @param new x position (int)
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * returns the item y position
	 * @return item y position (int)
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * sets the item y position to a new y position
	 * @param new y position (int)
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * returns the amount of a certain type of item.
	 * For example if you have 5 wood items it returns 5
	 * @return amount of a certain type of item (int)
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * sets the amount of a certain type of item to a new amount
	 * @param new amount
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Returns the item id
	 * @return item id (int)
	 */
	public int getId() {
		return id;
	}

	
}
