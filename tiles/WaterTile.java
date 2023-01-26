package tiles;

import display.graphics.Assets;

/**
 * WaterTile class. Draws the water texture to screen and water is now passable
 * @author Matthew-Bustamante
 *
 */
public class WaterTile extends Tile {
	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	
	/**
	 * @Override
	 * isSolid is set to true here because water is not passable
	 * @return true (boolean)
	 */
	public boolean isSolid() {
		return true;
	}
}
