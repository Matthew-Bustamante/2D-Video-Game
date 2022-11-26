package states;

import java.awt.Graphics;

import display.graphics.Assets;
import entities.creatures.Player;
import entities.statics.Tree;
import game.Game;
import game.Handler;
import tiles.Tile;
import worlds.World;

public class GameState extends State{
	

	private World world;

	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "worlds/world1.txt");
		handler.setWorld(world);


		
		
	}

	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}
	
}

