package game;

import game.Game;
public class Launcher {
	
	public static void main(String[]args) {
		Game game = new Game("Game Demo", 640, 360);
		game.start();
	}
	
}

