package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import display.graphics.Assets;
import game.Game;
import game.Handler;

public class Player extends Creature{

	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		//Collision Box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		 /*
		  //TEST CODE FOR COLLISIONS
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 */
	}
}

