package tiles;


import display.graphics.Assets;

/**
 * RockTile class inherits from Tile class and loads a rock tile from Assets class.
 * This tile is solid and doesn't allow the player to pass through
 * @author Matthew-Bustamante
 *
 */
public class RockTile extends Tile{
	
	/**
	 * RockTile constructor
	 * @param tile id (int)
	 */
	public RockTile(int id) {
		super(Assets.wall, id);
	}
	
	/**
	 * @Override
	 * returns true because player can't pass through rock tile
	 * @return true (boolean)
	 */
	public boolean isSolid() {
		return true;
	}

}
