package game;

import display.graphics.GameCamera;
import input.KeyManager;
import input.MouseManager;
import worlds.World;

/**
 * Handler Class that acts a data transfer object that transfers objects in the game.
 * This is used to access other class in the Game.
 * @author Matthew-Bustamante
 *
 */
public class Handler {
	
	private Game game;
	private World world;
	
	/**
	 * Handler constructor.
	 * Requires the Game class
	 * @param Game Object
	 */
	public Handler(Game game) {
		this.game = game;
	}
	
	/**
	 * Retrieves the gameCamera
	 * @return GameCamera object
	 */
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	
	/**
	 * Retrieves the KeyManager
	 * @return KeyManager object
	 */
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	/**
	 * Retrieves the MouseManager
	 * @return MouseManager object
	 */
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	/**
	 * Retrieves the screen width
	 * @return screen width (int)
	 */
	public int getWidth() {
		return game.getWidth();	
		}
	/**
	 * Retrieves the screen height
	 * @return screen height (int)
	 */
	public int getHeight() {
		return game.getHeight();
		}
	
	/**
	 * Retrieves the Game class
	 * @return Game object
	 */
	public Game getGame() {
		return game;
	}
	
	/**
	 * Sets the Game class
	 * @param Game Object
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/**
	 * Retrieves the World class
	 * @return World Object
	 */
	public World getWorld() {
		return world;
	}
	
	/**
	 * Sets the World class
	 * @param World Object
	 */
	public void setWorld(World world) {
		this.world = world;
	}
}
