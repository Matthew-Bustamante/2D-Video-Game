package input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager class that manages key inputs from the user
 * @author Matthew-Bustamante
 *
 */
public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight;
	
	/**
	 * KeyManager Constructor
	 * Initiallizes the keys array
	 */
	public KeyManager() {
		keys = new boolean[256];
	}
	
	/**
	 * tick method that gathers input from user
	 */
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	/**
	 * Checks if a key is typed 
	 * @param KeyEvent Object
	 */
	public void keyTyped(KeyEvent e) {
	}

	@Override
	/**
	 * checks if a key got pressed 
	 * @param KeyEvent Object
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//System.out.println("Pressed!");
	}

	@Override
	/**
	 * checks if a key got released
	 * @param KeyEvent Object
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
