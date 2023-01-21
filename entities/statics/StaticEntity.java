package entities.statics;

import entities.Entity;
import game.Handler;

public abstract class StaticEntity extends Entity{
	
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
