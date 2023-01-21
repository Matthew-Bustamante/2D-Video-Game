package entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.graphics.Animation;
import display.graphics.Assets;
import entities.creatures.Creature;
import game.Handler;
import tiles.Tile;

public class Tree extends StaticEntity{
	private Animation eyeAnimation;
	private Animation hurtAnimation;
	
	//private int hitTracker;
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
		//hitTracker = 0;
		
		//Animations
		eyeAnimation = new Animation(100, Assets.tree_animation);
		hurtAnimation = new Animation(1000, Assets.tree_hurt);
	}

	@Override
	public void tick() {
		//Animations
		eyeAnimation.tick();
		//hurtAnimation.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, 70, null);
		//hitTracker = false;
		/*
		  //TEST CODE FOR COLLISIONS
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 */

	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(this.hitTracker > 0) {
			this.hitTracker -= 1;
			return hurtAnimation.getCurrentFrame();
		}
		else {
			return eyeAnimation.getCurrentFrame();
		}
	}
	
	@Override
	public void die() {
		
	}
/*	
	@Override
	public void hurt(int ammount) {
		health -= ammount;
		hitTracker += 10;
		if(health <= 0) {
			active = false;
			die();
		}
		//hitTracker = false;
	}
	*/
}
