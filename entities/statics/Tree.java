package entities.statics;

import java.awt.Graphics;

import display.graphics.Assets;
import game.Handler;
import tiles.Tile;

public class Tree extends StaticEntity{
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x), (int) (y), width, height, null);
		
	}
}
