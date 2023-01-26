package tiles;

import display.graphics.Assets;

/**
 * DirtTile class that inherits from Tile class and loads in a Dirt tile texture
 * @author Matthew-Bustamante
 *
 */
public class DirtTile extends Tile {
	/**
	 * DirtTile constructor
	 * @param tile id (int)
	 */
	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
}
