package input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager class that manages key inputs from the user
 * @author Matthew-Bustamante
 *
 */
public class KeyManager implements KeyListener{
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight;
	
	/**
	 * KeyManager Constructor
	 * Initiallizes the keys array
	 */
	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	/**
	 * tick method that gathers input from user
	 * And checks if a key was pressed or recently pressed
	 */
	public void tick() {
		for(int i =0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			}
			else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		//Test code
		if(keyJustPressed(KeyEvent.VK_I)) {
			System.out.println("I Pressed");
		}
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
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = true;
		//System.out.println("Pressed!");
	}

	@Override
	/**
	 * checks if a key got released
	 * @param KeyEvent Object
	 */
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = false;
	}
	
	/**
	 * checks if a key was recently pressed
	 * @param keyCode (int)
	 * @return false if a key wasn't recently pressed
	 * Returns the justPressed key if not false
	 */
	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode >= keys.length) {
			return false;
		}
		return justPressed[keyCode];
	}
}
