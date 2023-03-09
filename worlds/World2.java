package worlds;

import java.awt.Graphics;

import entities.EntityManager;
import entities.creatures.Player;
import entities.statics.Portal;
import entities.statics.Rock;
import entities.statics.Tree;
import game.Game;
import game.Handler;
import game.items.ItemManager;
import tiles.Tile;
import utils.Utils;

/**
 * World class that loads in a world.
 * Draws entities into the world and draws tiles to the screen.
 * @author Sethrekar
 *
 */
public class World2 extends Universe{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entities
	private EntityManager entityManager;
	
	//Item
	private ItemManager itemManager;
	
	/**
	 * World constructor
	 * @param handler Object (Handler)
	 * @param world file path (string)
	 */
	public World2(Handler handler, String path) {
		super(handler, path);
		this.handler = handler;
		//entityManager = new EntityManager(handler, handler.getWorld().getEntityManager().getPlayer());
		
		//Trees
		//entityManager.addEntity(new Tree(handler, 500, 280));
		entityManager.addEntity(new Tree(handler, 200, 250));
		//entityManager.addEntity(new Tree(handler, 500, 550));
		
		//Rocks
		
		entityManager.addEntity(new Rock(handler, 300, 500));
		//entityManager.addEntity(new Rock(handler, 550, 480));
		
		//Portal
		entityManager.addEntity(new Portal(handler, 1050, 500));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
		itemManager = handler.getWorld().getItemManager();
	}
	
	

}
