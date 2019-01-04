package TerrainGenerator.Tests;

// An initial test to verify that OpenSimplexNoise is working and
// to check the range of its output values.

import TerrainGenerator.OpenSimplexNoise;

class OpenSimplexNoiseTest {

	public static void main (String[] args) {

		OpenSimplexNoiseTest noiseTest = new OpenSimplexNoiseTest();

	}

	OpenSimplexNoiseTest() {

		OpenSimplexNoise noise = new OpenSimplexNoise();
		double sum = 0.0;

		double width = 960.0;
		double height = 640.0;
		double totalPixels = width * height;

		double lowestValue = 0.0;
		double highestValue = 0.0;

		for (double y = 0.0; y < height; y++) {

			for (double x = 0.0; x < width; x++) {

				double currentValue = noise.eval(x, y);
				sum += currentValue;

				if (currentValue < lowestValue) {
					lowestValue = currentValue;
				}

				if (currentValue > highestValue) {
					highestValue = currentValue;
				}

			}

		}

		double average = sum / totalPixels;

		System.out.println("Average value: " + average);
		System.out.println("Lowest value: " + lowestValue);
		System.out.println("Highest value: " + highestValue);

	}

}