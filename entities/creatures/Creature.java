package entities.creatures;
import entities.Entity;
import game.Game;
import game.Handler;
import tiles.Tile;

/**
 * Creature class that inherits from the Entity class.
 * Creatures are able to move and to detect collisions with game obstacles & other Entities
 * @author Matthew-Bustamante
 *
 */
public abstract class Creature extends Entity {
	
	public  static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	

	protected float speed;
	protected float xMove, yMove;
	/**
	 * Creature constructor
	 * @param Game Handler Object
	 * @param x position (float)
	 * @param y position (float)
	 * @param creature width (int)
	 * @param height (int)
	 */
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	/**
	 * Move method that checks for collisions and then determines
	 * whether to move left or right (x) or move up or down (y)
	 */
	public void move() {
		if(!checkEntityCollisions(xMove, 0f)) {
			moveX();
		}
		if(!checkEntityCollisions(0f, yMove)) {
			moveY();
		}
	}
	
	/**
	 * Moves a creature left of right and checks for collisions with a solid Tile like a wall
	 */
	public void moveX() {
		if(xMove > 0) {//Moving Right
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHIEGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHIEGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if (xMove < 0) {//Moving Left
			
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHIEGHT) && 
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHIEGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	/**
	 * Moves a creature up or down and checks for collisions with solid Tiles like a wall
	 */
	public void moveY() {
		if (yMove < 0) {//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHIEGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH , ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHIEGHT + Tile.TILEHIEGHT - bounds.y;
			}
			
		}else if(yMove > 0) {//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHIEGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH , ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILEHIEGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	/**
	 * Protected method that returns if a tile is a solid tile
	 * 
	 * @param x position
	 * @param y position
	 * @return Returns true if a tile is a solid tile like a wall
	 * returns false if a tile is not solid
	 */
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	// GETTERS AND SETTERS
	
	/**
	 * Returns how much a creature has moved left or right
	 * @return float
	 */
	public float getxMove() {
		return xMove;
	}
	
	/**
	 * sets how much a creature moves left or right
	 * @param float number
	 */
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	
	/**
	 * Returns how much a creature has moved up or down
	 * @return number (float)
	 */
	public float getyMove() {
		return yMove;
	}
	
	/**
	 * sets how much a creature moves up or down
	 * @param number (float)
	 */
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
	/**
	 * Returns the amount of health a creature has
	 * @return number (int)
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Sets the health for a creature
	 * @return number (int)
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * returns the speed of a creature
	 * @return number (float)
	 */
	public float getSpeed() {
		return speed;
	}
	
	/**
	 * sets the speed of a creature in pixels
	 * @param number(float)
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
	
	
}
