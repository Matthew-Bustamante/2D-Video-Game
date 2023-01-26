package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import entities.creatures.Player;
import game.Handler;

/**
 * EntityManager class that manages all entities in the game 
 * @author Matthew-Bustamante
 *
 */
public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
				return -1;
			}
			return 1;
		}
	};
	
	/**
	 * EntityManager Constructor
	 * @param Game Handler Object
	 * @param Player object
	 */
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	/**
	 * Ticks all entities 
	 */
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()) {
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
		entities.sort(renderSorter);
		
	}
	
	/**
	 * Renders all entities
	 * @param Graphics object
	 */
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
		
	}
	
	/**
	 * adds entity to the game
	 * @param Entity object
	 */
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	//GETTERS SETTERS
	
	/**
	 * returns the game handler object
	 * @return handler object
	 */
	public Handler getHandler() {
		return handler;
	}
	
	/**
	 * Sets a handler object
	 * @param handler object
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * returns a player object
	 * @return player object
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * sets to a player object
	 * @param player object
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * returns the arraylist that contains all entities
	 * @return arraylist (entities)
	 */
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	/**
	 * sets a new arraylist of entities
	 * @param arraylist (Entity)
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}
