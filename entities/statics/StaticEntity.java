package entities.statics;

import entities.Entity;
import game.Handler;

/**
 * StaticEntity abstract class that inherits from the Entity class.  
 * This is for entities that don't move like Trees, turrents, or traps
 * @author Matthew-Bustamante
 *
 */
public abstract class StaticEntity extends Entity{
	
	/**
	 * StaticEntity constructor 
	 * @param Handler object
	 * @param x position (float)
	 * @param y position (float)
	 * @param Static Entity width (int)
	 * @param Static Entity height (int)
	 */
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
	/*	
	 * Potential Hurtable Interface code
	@Override
	public void hurt(int ammount) {
		//Overides to do a no hurt
	}
	*/
}
