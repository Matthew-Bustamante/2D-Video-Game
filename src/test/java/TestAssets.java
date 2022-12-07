package src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import display.graphics.Assets;
class TestAssets {

	@Test
	void testAssetWorldTextures() {
		Assets.init();
		BufferedImage testWaterAsset = Assets.water;
		BufferedImage testDirtAsset = Assets.dirt;
		BufferedImage testGrassAsset = Assets.grass;
		BufferedImage testWallAsset = Assets.wall;
		assertNotNull(testWaterAsset);
		assertNotNull(testDirtAsset);
		assertNotNull(testGrassAsset);
		assertNotNull(testWallAsset);
		
	}

}
