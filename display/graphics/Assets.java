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
	public static BufferedImage grass, wall, dirt, water, tree;
	public static BufferedImage[] player_down, player_up, player_right, player_left;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/worldTiles.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/playerSpriteSheet.png"));
		SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/treeTexture.png"));
		
		//Player Animation BufferedImage Object Arrays
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		//Player down Animation Crops
		player_down[0] = playerSheet.crop(0, 0, width, height);
		player_down[1] = playerSheet.crop(width, 0, width, height);
		
		//Player up Animation Crops
		player_up[0] = playerSheet.crop(width * 2, 0, width, height);
		player_up[1] = playerSheet.crop(width * 3, 0, width, height);
		
		//Player right Animation 
		player_right[0] = playerSheet.crop(0, 32, width, height);
		player_right[1] = playerSheet.crop(32, 32, width, height);
		
		player_left[0] = playerSheet.crop(32 * 2, 32, width, height);
		player_left[1] = playerSheet.crop(32 * 3, 32, width, height);
		
		grass = sheet.crop(width, 0, width, height);
		wall = sheet.crop(width * 2, 0, width, height);
		dirt = sheet.crop(width * 3, 0, width, height);
		water = sheet.crop(0, height, width, height);
		tree = treeSheet.crop(0, 0, width, height);
		
	}
}

