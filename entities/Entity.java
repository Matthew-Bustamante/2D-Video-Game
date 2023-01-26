package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;
import game.Handler;

/**
 * Entity Abstract class that is the blueprint for any entity (player, tree, enemy, bullets etc)
 * @author Matthew-Bustamante
 *
 */
public abstract class Entity {
	public  static final int DEFAULT_HEALTH = 10;
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected int health;
	protected boolean active = true;
	protected Rectangle bounds;
	
	protected int hitTracker;
	
	/**
	 * Entity Contructor
	 * @param Game Handler Object
	 * @param x position
	 * @param y position
	 * @param entity width (pixels)
	 * @param entity height (pixels)
	 */
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hitTracker = 0;
		health = DEFAULT_HEALTH;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	/**
	 * returns the x position of an entity
	 * @return x position (float)
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * sets the x position of an entity
	 * @param x position (float)
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * returns the y positio of an entity
	 * @return y position (float)
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * sets the y position of an entity
	 * @param y position (float)
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * returns entity width
	 * @return entity width (int)
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * sets entity width
	 * @param width (int)
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * returns entity height
	 * @return entity height (int)
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * sets entity height
	 * @param entity height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * abstract tick method 
	 */
	public abstract void tick();
	
	/**
	 * abstract graphics method
	 * @param Graphics
	 */
	public abstract void render(Graphics g);
	
	/**
	 * checks for entity collision
	 * @param xOffset
	 * @param yOffset
	 * @return true if entity has collided with something 
	 * returns false if entity dosen't collide with anything
	 */
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * draws an invisble rectangle to an entity for collision detection
	 * @param xOffset
	 * @param yOffset
	 * @return a rectangle
	 */
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	/**
	 * returns an entity's health
	 * @return entity health (int)
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * sets an entity's health
	 * @param health (int)
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * method that returns if entity is still active (alive)
	 * @return boolean (true or false)
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * sets if an entity is on the screen
	 * true for entity on screen
	 * false for entity not on screen
	 * @param boolean
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Abstract die method for entities that die
	 */
	public abstract void die();
	
	/**
	 * hurt method so that an entity takes damage from player
	 * @param damage dealt
	 */
	public void hurt(int ammount) {
		health -= ammount;
		hitTracker = 10;
		if(health <= 0) {
			active = false;
			die();
		}
	}
	
	
}
