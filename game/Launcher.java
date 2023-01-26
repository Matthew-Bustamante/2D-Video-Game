package game;

import game.Game;
/**
 * Launcher class that launches the game.
 * Creates a new Game object
 * @author Matthew-Bustamante
 *
 */
public class Launcher {
	
	public static void main(String[]args) {
		Game game = new Game("v0.4.0", 1000, 500);
		game.start();
	}
	
}

