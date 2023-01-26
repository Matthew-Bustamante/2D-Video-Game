package worlds;

import java.awt.Graphics;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Tree;
import game.Game;
import game.Handler;
import game.items.ItemManager;
import tiles.Tile;
import utils.Utils;

/**
 * World class that loads in a world.
 * Draws entities into the world and draws tiles to the screen.
 * @author Sethrekar
 *
 */
public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entities
	private EntityManager entityManager;
	
	//Item
	private ItemManager itemManager;
	
	/**
	 * World constructor
	 * @param handler Object (Handler)
	 * @param world file path (string)
	 */
	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new Tree(handler, 500, 280));
		entityManager.addEntity(new Tree(handler, 200, 250));
		entityManager.addEntity(new Tree(handler, 500, 550));
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		itemManager = new ItemManager(handler);
	}
	
	
	/**
	 * ticks everything in the world
	 */
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
	/**
	 * renders everything in the world
	 * @param g
	 */
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHIEGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHIEGHT + 1);
		
		for(int y = yStart;y < yEnd; y++) {
			for(int x = xStart; x < xEnd;x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int) (y * Tile.TILEHIEGHT - handler.getGameCamera().getyOffset()));
				
			}
		}
		
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
	}
	
	/**
	 * Retrieves ids from a text file and puts them in a 2D array
	 * @param x position (int)
	 * @param y position (int)
	 * @return 2D array of tile ids (Tile)
	 */
	public Tile getTile (int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	/**
	 * loads world
	 * @param world file path (String)
	 */
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y< height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width + 4)]);
			}
		}
	}
	
	/**
	 * returns world width
	 * @return world width (int)
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * returns world height
	 * @return world height (int)
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * returns the world entityManager
	 * @return world entityManager (EntityManager)
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * returns handler object
	 * @return handler object (Handler)
	 */
	public Handler getHandler() {
		return handler;
	}

	/**
	 * sets the handler object
	 * @param handler object (Handler)
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	/**
	 * returns the ItemManager
	 * @return ItemManager Object (ItemManager)
	 */
	public ItemManager getItemManager() {
		return itemManager;
	}

	/**
	 * sets itemManager
	 * @param itemManager Object (ItemManager)
	 */
	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
}
