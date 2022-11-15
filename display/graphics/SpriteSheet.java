package display.graphics;

import java.awt.image.BufferedImage;
/**
 * SpriteSheet class that deals with sprites
 */
public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	/**
	 * Crop method that crops an image on a sprite sheet
	 * @param x coordinate on the entire image
	 * @param y coordinate of the entire image
	 * @param width of the selected image
	 * @param height of the selected image
	 * @return
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
