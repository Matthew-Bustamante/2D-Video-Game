package game;

import game.Game;
public class Launcher {
	
	public static void main(String[]args) {
		Game game = new Game("v0.3.0", 1000, 500);
		game.start();
	}
	
}

