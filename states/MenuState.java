package states;

import java.awt.Color;
import java.awt.Graphics;

import display.graphics.Assets;
import game.Game;
import game.Handler;
import game.ui.ClickListener;
import game.ui.UIImageButton;
import game.ui.UIManager;
/**
 * MenuState Class that creates a main menu for the game
 * @author Sethrekar
 *
 */
public class MenuState extends State {
	
	private UIManager uiManager;
	
	/**
	 * Menu constructor
	 * @param Handler Object (Handler)
	 */
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(430, 200, 128, 64, Assets.ui_button, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}}));
	}

	/**
	 * tick method for Menu state.  Tracks the movement of the mouse.
	 */
	public void tick() {
		uiManager.tick();
	}

	/**
	 * Renders anything that is put onto the menu of the game
	 * @param Graphics Object (Graphics)
	 */
	public void render(Graphics g) {
		uiManager.render(g);
	}
	

}