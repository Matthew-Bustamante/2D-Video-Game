package entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.graphics.Animation;
import display.graphics.Assets;
import entities.creatures.Creature;
import game.Handler;
import game.items.Item;
import tiles.Tile;

/**
 * Tree class that inherits from the StaticEntity class.  
 * A Tree is scattered throughout the world,
 * A Tree can take damage from the player,
 * A Tree drops wood upon death
 * @author Matthew-Bustamante
 *
 */
public class Tree extends StaticEntity{
	private Animation eyeAnimation;
	private Animation hurtAnimation;
	
	//private int hitTracker;
	
	/**
	 * Tree Constructor
	 * @param Handler object
	 * @param x position
	 * @param y position
	 */
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
	/**
	 * Ticks the tree for animations
	 */
	public void tick() {
		//Animations
		eyeAnimation.tick();
		//hurtAnimation.tick();
		
		
	}

	@Override
	/**
	 * renders the tree to the screen and renders in the animation to the tree
	 */
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, 70, null);
		//hitTracker = false;
		/*
		  //TEST CODE FOR COLLISIONS
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 */

	}
	
	/**
	 * Returns the typical animation frame to allow for animation to occur.
	 * If the player hits the tree then method returns the hurtAnimation frame instead
	 * @return eyeAnimation or the hurtAnimation if the tree is hurt (BufferedImage)
	 */
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
	/**
	 * Die method that adds a wood item to the game when the Tree reaches 0 health
	 */
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
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
