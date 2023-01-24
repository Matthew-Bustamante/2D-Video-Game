package display.graphics;

import java.awt.image.BufferedImage;
/**
 * Animation class that handles animations
 * @author Matthew-Bustamante
 *
 */
public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	/**
	 * Animation constructor
	 * @param animation speed
	 * @param frames
	 */
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	/**
	 * tick method that controls animation ticking
	 */
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index ++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
	/**
	 * Returns BufferedImage array
	 * @return frames array
	 */
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}
