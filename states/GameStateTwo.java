package states;

import java.awt.Graphics;
import java.util.ArrayList;

import display.graphics.Assets;
import entities.Entity;
import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Portal;
import entities.statics.Tree;
import game.Game;
import game.Handler;
import tiles.Tile;
import worlds.Universe;
import worlds.World;
import worlds.World2;

/**
 * GameState class handles creating new worlds and for ticking worlds as well as rendering worlds
 * @author Sethrekar
 *
 */
public class GameStateTwo extends State{
	

	private Universe world2;

	/**
	 * GameState Constructor
	 * Creates new world object
	 * @param Handler Object
	 */
	public GameStateTwo(Handler handler) {
		super(handler);
		world2 = new World2(handler, "worlds/world2.txt");
		handler.setWorld(world2);
		
	}

	
	/**
	 * @Override
	 * ticks world
	 */
	public void tick() {
		world2.tick();
	}

	
	/**
	 * @Override
	 * Renders world
	 * @param Graphics Object (Graphics)
	 */
	public void render(Graphics g) {
		world2.render(g);
	}
	/*
	public void switchWorlds() {
		world2 = new World(handler, "worlds/world2.txt");
		handler.setWorld(world2);
	}
	*/
}

