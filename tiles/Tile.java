package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Tile class that is the blue prints for all tiles in the game.
 * this class renders tiles to the screen.
 * Ticks tiles if tiles have animation.
 * Assigns Tiles an id.
 * Assigns a default tile to be not solid
 * @author Sethrekar
 *
 */
public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile waterTile = new WaterTile(3);
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHIEGHT =64;
	
	protected BufferedImage texture;
	protected final int id;
	
	/**
	 * Tile Constructor
	 * @param texture (BufferedImage)
	 * @param tile id (int)
	 */
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	/**
	 * ticks all tiles
	 */
	public void tick() {
		
	}
	
	/**
	 * renders tiles to the screen
	 * @param Graphics Object (Graphics
	 * @param x position (int)
	 * @param y position (int)
	 */
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHIEGHT, null);
	}
	
	/**
	 * is solid method that determines if player can pass through a tile or not
	 * @return default value is false or passable (boolean)
	 */
	public boolean isSolid() {
		return false;
	}
	
	/**
	 * returns a tile id
	 * @return tile tid (int)
	 */
	public int getId() {
		return id;
	}

}
