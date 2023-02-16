package display.graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
	
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
