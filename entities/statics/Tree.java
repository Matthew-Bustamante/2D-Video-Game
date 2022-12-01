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
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
		
		//Animations
		eyeAnimation = new Animation(100, Assets.tree_animation);
	}

	@Override
	public void tick() {
		//Animations
		eyeAnimation.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, 70, null);
		
		/*
		  //TEST CODE FOR COLLISIONS
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		 */

	}
	
	private BufferedImage getCurrentAnimationFrame() {
		return eyeAnimation.getCurrentFrame();
	}
	
}
