package entities.statics;

import java.awt.Graphics;

import display.graphics.Assets;
import entities.creatures.Creature;
import game.Handler;
import game.items.Item;
import tiles.Tile;

public class Rock extends StaticEntity {
	
	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Creature.DEFAULT_CREATURE_WIDTH - 25;
		bounds.height = Creature.DEFAULT_CREATURE_HEIGHT - 10;
		width = 72;
		height = 72;
		health = 2;
	}
	
	@Override
	/*
	 * Tick method made for animations
	 */
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/*
	 * Renders rock to screen
	 */
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}



		

	@Override
	/*
	 * Die method made for the rock to drop the stone item
	 */
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.stoneItem.createNew((int)x, (int)y));
		
	}
}
