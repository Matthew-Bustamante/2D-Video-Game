package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Utils class that loads in a text file with a bunch of tile ids and parses it to draw up a world
 * @author Matthew-Bustamante
 *
 */
public class Utils {
	
	/**
	 * loads a text file with tile ids 
	 * @param file path (String)
	 * @return file as a string (String)
	 */
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
;			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/**
	 * Parses the string of tile ids 
	 * @param tile id (string)
	 * @return tile id
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
