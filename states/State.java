package states;

import java.awt.Graphics;

import game.Game;
import game.Handler;

/**
 * State Abstract Class. Provides a blue print for other states the game may have like:
 * Game State, Menu State, Game Over State.
 * @author Matthew-Bustamante
 *
 */
public abstract class State {
	
	private static State currentState = null;
	
	/**
	 * sets current state to a new state
	 * @param new state (State)
	 */
	public static void setState(State state) {
		currentState = state;
	}
	
	/**
	 * returns the current state
	 * @return current state (State)
	 */
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	
	protected Handler handler;
	
	/**
	 * State Constructor
	 * @param Handler Object
	 */
	public State(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * abstract tick method ticks states
	 */
	public abstract void tick();
	
	/**
	 * abstract render method renders states
	 * @param Graphics Objects (Graphics)
	 */
	public abstract void render(Graphics g);
	
}