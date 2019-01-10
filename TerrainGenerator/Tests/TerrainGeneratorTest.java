package TerrainGenerator.Tests;

import TerrainGenerator.Gradient;
import TerrainGenerator.HeightPalette;
import TerrainGenerator.TerrainGenerator;

import java.util.Random;

class TerrainGeneratorTest {

	public static void main(String[] args) {

		TerrainGeneratorTest tgTest = new TerrainGeneratorTest();

	}

	TerrainGeneratorTest() {

		/*TerrainGenerator generator = new TerrainGenerator();
		generator.generateTerrain();
		generator.outputImage();*/

		Random random = new Random();

		HeightPalette palette = new HeightPalette();
		/*palette.add(0, 15, 0, 80);			// deep ocean
		palette.add(45, 35, 0, 190);		// ocean
		palette.add(230, 255, 255, 255);	// snow top
		palette.add(90, 255, 230, 175);		// sand
		palette.add(115, 85, 220, 75);		// grass
		palette.add(155, 60, 150, 50);		// elevated grass
		palette.add(185, 75, 50, 20);		// mountain*/

		/*palette.add(0, 15, 0, 80);
		palette.add(55, 35, 0, 190);
		palette.add(115, 255, 230,175);
		palette.add(130, 85, 220, 75);
		palette.add(160, 60, 150, 50);
		palette.add(195, 75, 50, 20);
		palette.add(230,255, 255, 255);*/

		/*palette.add(0, 15, 0, 80);
		palette.add(75, 35, 0, 190);
		palette.add(135, 255, 230,175);
		palette.add(150, 85, 220, 75);
		palette.add(180, 60, 150, 50);
		palette.add(205, 75, 50, 20);
		palette.add(230,255, 255, 255);*/

		/*palette.add(0, 15, 0, 80);
		palette.add(95, 35, 0, 190);
		palette.add(150, 255, 230,175);
		palette.add(165, 85, 220, 75);
		palette.add(195, 60, 150, 50);
		palette.add(215, 75, 50, 20);
		palette.add(238, 255, 255, 255);*/

		palette.add(0, 15, 0, 80);
		palette.add(115, 35, 0, 190);
		palette.add(165, 255, 230,175);
		palette.add(175, 85, 220, 75);
		palette.add(195, 60, 150, 50);
		palette.add(215, 75, 50, 20);
		palette.add(242, 255, 255, 255);

		for (int i = 0; i < 100; i++) {

			TerrainGenerator tempGenerator = new TerrainGenerator(960, 640, 255, 0, random.nextInt(8)+1, random.nextDouble(), random.nextDouble()*3, random.nextLong(), true, palette);
			Gradient tempGradient = new Gradient(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
			tempGenerator.setGradient(tempGradient);

			tempGenerator.generateTerrain();
			tempGenerator.outputImage();
			tempGenerator.outputGradientImage();

			System.out.print(".");

		}

	}

}