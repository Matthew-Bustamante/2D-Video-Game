package display.graphics;

import entities.Entity;
import game.Game;
import game.Handler;
import tiles.Tile;
/**
 * GameCamera class that controls the player's point of view
 * @author Sethrekar
 *
 */
public class GameCamera {
	//instance variables
	private Handler handler;
	private float xOffset, yOffset;
	
	/**
	 * GameCamera Constructor
	 * @param Game Handler Object
	 * @param x Coordinate offset
	 * @param y Coordinate offset
	 */
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	/**
	 * Checks if there is a blank space in the world and moves the world
	 */
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHIEGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tile.TILEHIEGHT - handler.getHeight();
		}
	}
	
	/**
	 * Centers the camera on the player
	 * @param entity (player, tree, enemy)
	 */
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	/**
	 * moves the camera
	 * @param xAmt
	 * @param yAmt
	 */
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	/**
	 * returns x coordinate offset
	 * @return x coordinate offset
	 */
	public float getxOffset() {
		return xOffset;
	}
	
	/**
	 * sets x coordinate offset
	 * @param float number to set the xOffset
	 */
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	
	/**
	 * returns y coordinate offset
	 * @return y coordinate offset
	 */
	public float getyOffset() {
		return yOffset;
	}
	
	/**
	 * sets the y coordinate offset
	 * @param float number to set the yOffset
	 */
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
