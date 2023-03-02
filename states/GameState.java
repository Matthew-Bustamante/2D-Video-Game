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
import worlds.World;
import worlds.World2;

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
		
		/*
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e instanceof Portal) {
				if(e.isActive() == false) {
					world2 = new World(handler, "worlds/world2.txt");
					handler.setWorld(world2);
				}
				else {
					break;
				}
			}
		} */
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

