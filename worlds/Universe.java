package worlds;

import java.awt.Graphics;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Portal;
import entities.statics.Rock;
import entities.statics.Tree;
import game.Handler;
import game.items.ItemManager;
import tiles.Tile;
import utils.Utils;

public abstract class Universe {
	
protected EntityManager entityManager;
	
	//Item
	protected ItemManager itemManager;
	
	protected Handler handler;
	protected int width;

	protected int height;
	protected int spawnX;

	protected int spawnY;
	private int[][] tiles;
	
	public Universe(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		itemManager = new ItemManager(handler);
	}
	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}
	
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
		
		
	}
	public Tile getTile (int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public void loadWorld(String path) {
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
