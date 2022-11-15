package display.graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * ImageLoader class that loads images
 * @author Tars
 *
 */
public class ImageLoader {
	
	/**
	 * loadImage method that takes in the images path and loads the image
	 * @param image's path
	 * @return null if method can't find the image path else it returns the image path
	 */
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
