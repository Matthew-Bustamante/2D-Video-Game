package states;

import java.awt.Color;
import java.awt.Graphics;

import game.Game;
import game.Handler;
/**
 * MenuState Class that creates a main menu for the game
 * @author Sethrekar
 *
 */
public class MenuState extends State {
	
	public MenuState(Handler handler) {
		super(handler);
	}

	/**
	 * tick method for Menu state.  Tracks the movement of the mouse.
	 */
	public void tick() {
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
			State.setState(handler.getGame().gameState);
		}
	}

	/**
	 * Renders anything that is put onto the menu of the game
	 */
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	}

}