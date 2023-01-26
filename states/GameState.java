package states;

import java.awt.Graphics;

import display.graphics.Assets;
import entities.creatures.Player;
import entities.statics.Tree;
import game.Game;
import game.Handler;
import tiles.Tile;
import worlds.World;

/**
 * GameState class handles creating new worlds and for ticking worlds as well as rendering worlds
 * @author Sethrekar
 *
 */
public class GameState extends State{
	

	private World world;

	/**
	 * GameState Constructor
	 * Creates new world object
	 * @param Handler Object
	 */
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "worlds/world1.txt");
		handler.setWorld(world);


		
		
	}

	
	/**
	 * @Override
	 * ticks world
	 */
	public void tick() {
		world.tick();
	}

	
	/**
	 * @Override
	 * Renders world
	 * @param Graphics Object (Graphics)
	 */
	public void render(Graphics g) {
		world.render(g);
	}
	
}

