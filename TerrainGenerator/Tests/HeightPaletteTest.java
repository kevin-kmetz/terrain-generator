package TerrainGenerator.Tests;

import TerrainGenerator.HeightPalette;

import java.awt.Color;
import java.util.Random;

class HeightPaletteTest {

	public static void main(String[] args) {

		HeightPaletteTest heightPaletteTest = new HeightPaletteTest();

	}

	HeightPaletteTest() {

		Random random = new Random();

		HeightPalette paletteOne = new HeightPalette();

		paletteOne.add(250, new Color(255, 0, 0));
		paletteOne.add(175, new Color(0, 255, 0));
		paletteOne.add(0, new Color(0, 0, 0));
		paletteOne.add(100, new Color(0, 0, 255));

		paletteOne.display();

		for (int i = 0; i < 10; i++) {

			int tempHeight = random.nextInt(256);

			System.out.println("At height " + tempHeight + ", " + paletteOne.getColor(tempHeight));

		}

		System.out.println();

		HeightPalette randomPalette = new HeightPalette();

		for (int i = 0, numberOfColors = random.nextInt(21); i < numberOfColors; i++) {

			randomPalette.add(random.nextInt(256), new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

		}

		randomPalette.display();

		for (int i = 0; i < 10; i++) {

			int tempHeight = random.nextInt(256);

			System.out.println("At height " + tempHeight + ", " + randomPalette.getColor(tempHeight));

		}

	}


}