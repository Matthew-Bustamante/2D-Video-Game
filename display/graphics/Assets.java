package display.graphics;
import java.awt.image.BufferedImage;

import display.graphics.ImageLoader;
import display.graphics.SpriteSheet;
/**
 * Assets class that handles all images and sounds of the game
 * @author Tars
 *
 */
public class Assets {
	
	private static final int width = 32, height = 32;
	
	//add sprites here 
	public static BufferedImage player, grass, wall,dirt;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));
		
		player = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		wall = sheet.crop(width * 2, 0, width, height);
		dirt = sheet.crop(width * 3, 0, width, height);
		
	}
}

