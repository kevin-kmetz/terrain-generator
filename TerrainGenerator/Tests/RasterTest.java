package TerrainGenerator.Tests;

import TerrainGenerator.Raster;

import java.util.Arrays;

class RasterTest {

	public static void main(String[] args) {

		RasterTest rasterTest = new RasterTest();

	}

	RasterTest() {

		final int width = 6;
		final int height = 5;

		Raster raster = new Raster(width, height);

		// Test setting of pixels in the raster.
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				raster.set(x, y, y*width + x + 1);
			}
		}

		raster.display();

		// Test setting individual elements in the raster.
		raster.set(1, 0, 5);
		raster.set(3, 4, 8);

		System.out.println();
		raster.display();

		// Test adding a row to the top of the raster.
		int[] tempArray = new int[width];
		Arrays.fill(tempArray, 99);
		raster.appendTop(tempArray);

		System.out.println();
		raster.display();

		// Test adding multiple rows to the top of the raster.
		int[][] tempMultiArray = new int [3][width];

		for (int[] i : tempMultiArray) {
			Arrays.fill(i, 77);
		}

		raster.appendTop(tempMultiArray);

		System.out.println();
		raster.display();

		// Test adding a row to the bottom of the raster.
		Arrays.fill(tempArray, 55);
		raster.appendBottom(tempArray);

		System.out.println();
		raster.display();

		// Test adding three rows to the bottom of the raster.
		tempMultiArray = new int [3][width];

		for (int[] i : tempMultiArray) {
			Arrays.fill(i, 33);
		}

		raster.appendBottom(tempMultiArray);

		System.out.println();
		raster.display();

	}

}