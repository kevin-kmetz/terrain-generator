package TerrainGenerator.Tests;

import TerrainGenerator.TerrainGenerator;

class TerrainGeneratorTest {

	public static void main(String[] args) {

		TerrainGeneratorTest tgTest = new TerrainGeneratorTest();

	}

	TerrainGeneratorTest() {

		TerrainGenerator generator = new TerrainGenerator();
		generator.generateTerrain();
		generator.outputImage();

	}

}