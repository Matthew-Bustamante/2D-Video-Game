package display.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * FontLoader class that loads an external font from your local computer.
 * Currently this class and isn't used anywhere in the game. unable to load an external font
 * Fonts are handled by the Text class.
 * @author Matthew-Bustamante
 *
 */
public class FontLoader {
	
	/**
	 * !!! DO NOT USE !!!
	 * Load font method that is suppose to load an external font file however it does not work
	 * @param file path (String)
	 * @param size of font (float)
	 * @return the Font if file found. Returns NULL if file is not found or doesn't exist
	 */
	public static Font loadFont(String path, float size) {
		try {
			InputStream fontStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			return Font.createFont(Font.TRUETYPE_FONT, fontStream);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
