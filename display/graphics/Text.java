package display.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * Text Class that draws text to the screen for the inventory an other purposes
 * @author Matthew-Bustamante
 *
 */
public class Text {
	
	/**
	 * drawString() method that hard codes a font using Java's font library and puts text at an x and y coordinate
	 * and centers it on the screen
	 * @param graphics object (Graphics
	 * @param text you want to put (String)
	 * @param x position of text (int)
	 * @param y position of text (int)
	 * @param center position of text (boolean)
	 * @param color of text (Color)
	 */
	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c) {
		g.setColor(c);
		Font font = new Font("TimesRoman", Font.BOLD, 30);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(center) {
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos -fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}
	
}
	
