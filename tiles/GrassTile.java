package tiles;


import display.graphics.Assets;

/**
 * GrassTile class that inherits from Tile class and loads a grass texture from Assets class
 * @author Matthew-Bustamante
 *
 */
public class GrassTile extends Tile{
	
	/**
	 * GrassTile Constructor
	 * @param tile id (int)
	 */
	public GrassTile(int id) {
		super(Assets.grass, id);
	}

}
