package TerrainGenerator.Tests;

// An initial test to verify that OpenSimplexNoise is working and
// to check the range of its output values.

import TerrainGenerator.OpenSimplexNoise;

import java.util.Random;

class OpenSimplexNoiseTest {

	public static void main (String[] args) {

		OpenSimplexNoiseTest noiseTest = new OpenSimplexNoiseTest();

	}

	OpenSimplexNoiseTest() {

		final double width = 960.0;
		final double height = 640.0;
		final double totalPixels = width * height;

		final int numberOfRuns = 5;

		for (int i = 0; i < numberOfRuns; i++) {

			Random random = new Random();
			Long seed = random.nextLong();

			OpenSimplexNoise noise = new OpenSimplexNoise(seed);
			double sum = 0.0;

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

			System.out.println("Run " + (i+1));
			System.out.println("Seed: " + seed);
			System.out.println("Average value: " + average);
			System.out.println("Lowest value: " + lowestValue);
			System.out.println("Hightest value: " + highestValue);
			System.out.println();

		}

	}

}