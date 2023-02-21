package display.graphics;
import java.awt.Font;
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
	
	//Fonts
	public static Font font28;
	
	//add sprites here 
	public static BufferedImage grass, wall, dirt, water, tree;
	// items
	public static BufferedImage wood;
	
	
	public static BufferedImage[] player_down, player_up, player_right, player_left;
	
	//tree animation
	public static BufferedImage [] tree_animation, tree_hurt;
	
	//UI textures
	public static BufferedImage[] ui_button;
	
	//Inventory
	public static BufferedImage inventoryScreen;
	/**
	 * Initiatlizes images
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/worldTiles.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/playerSpriteSheet.png"));
		SpriteSheet treeSheet = new SpriteSheet(ImageLoader.loadImage("/textures/treeTexture.png"));
		SpriteSheet buttonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/uiButtonSheet.png"));
		SpriteSheet itemSheet = new SpriteSheet(ImageLoader.loadImage("/textures/itemSpriteSheet.png"));
		
		//SpriteSheet inventorySheet = new SpriteSheet(ImageLoader.loadImage("/textures/inventoryScreen.png"));
		
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		//font28 = FontLoader.loadFont("/fonts/slkscr.ttf", height);
		
		//Player Animation BufferedImage Object Arrays
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		//Tree Animation BufferedImage Object Array
		tree_animation = new BufferedImage[8];
		
		//Tree Hurt Animation BufferedImage Object Array
		tree_hurt = new BufferedImage[1];
		
		//UI Animation BufferedImage Object Array
		ui_button = new BufferedImage[2];
		
		
		//------------------------------------------------------------------
		
		
		
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
		
		
		
		//tree animation
		tree_animation[0] = treeSheet.crop(0, 0, width, height);
		tree_animation[1] = treeSheet.crop(32, 0, width, height);
		tree_animation[2] = treeSheet.crop(32 * 2, 0, width, height);
		tree_animation[3] = treeSheet.crop(32 * 3, 0, width, height);
		
		tree_animation[4] = treeSheet.crop(0, 32, width, height);
		tree_animation[5] = treeSheet.crop(32, 32, width, height);
		tree_animation[6] = treeSheet.crop(32 * 2, 32, width, height);
		tree_animation[7] = treeSheet.crop(32 * 3, 32, width, height);
		
		
		//tree Hurt Animation
		tree_hurt[0] = treeSheet.crop(0, 67, width, height);
		
		
		//UI Button animation
		ui_button[0] = buttonSheet.crop(0, 0, 64, 32);
		ui_button[1] = buttonSheet.crop(0, 32, 64, 32);
		
		
		
		grass = sheet.crop(width, 0, width, height);
		wall = sheet.crop(width * 2, 0, width, height);
		dirt = sheet.crop(width * 3, 0, width, height);
		water = sheet.crop(0, height, width, height);
		//tree = treeSheet.crop(0, 0, width, height);
		
		//wood item
		wood = itemSheet.crop(0, 0, width, height);
		
		//inventoryScreen = inventorySheet.crop(0, 0, 384, 512);
		
	}
}

