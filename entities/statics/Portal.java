package entities.statics;

import java.awt.Graphics;

import display.graphics.Assets;
import entities.creatures.Creature;
import game.Handler;
import tiles.Tile;

/**
 * Portal class:  
 * A portal has 1 health and the player can attack/interact with it
 * If the portal is destroyed then the player progress to the next level.
 * @author Sethrekar
 *
 */
public class Portal extends StaticEntity {
	
	/**
	 * Portal constructor
	 * @param handler object (Handler)
	 * @param x position (float)
	 * @param y position (float)
	 */
	public Portal(Handler handler, float x, float y) {
		super(handler, x , y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
		width = 72;
		height =72;
		health = 1;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/*
	 * Renders the portal to the screen
	 */
	public void render(Graphics g) {
		g.drawImage(Assets.portal, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}
