package TerrainGenerator.Tests;

// An initial test to verify that OpenSimplexNoise is working and
// to check the range of its output values.

import TerrainGenerator.OpenSimplexNoise;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.util.Random;

class OpenSimplexNoiseTest {

	public static void main (String[] args) {

		OpenSimplexNoiseTest noiseTest = new OpenSimplexNoiseTest();

	}

	OpenSimplexNoiseTest() {

		final double width = 960.0;
		final double height = 640.0;
		final double totalPixels = width * height;
		final double scaleValue = 64.0;

		final int numberOfRuns = 5;

		for (int i = 0; i < numberOfRuns; i++) {

			Random random = new Random();
			Long seed = random.nextLong();

			OpenSimplexNoise noise = new OpenSimplexNoise(seed);
			
			double sum = 0.0;
			double lowestValue = 0.0;
			double highestValue = 0.0;

			double adjustedSum = 0.0;
			double adjustedLowestValue = 0.0;
			double adjustedHighestValue = 0.0;

			BufferedImage heightMap = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_RGB);

			for (double y = 0.0; y < height; y++) {

				for (double x = 0.0; x < width; x++) {

					double currentValue = noise.eval(x/scaleValue, y/scaleValue);
					double adjustedCurrentValue = (currentValue + 1) / 2;

					sum += currentValue;
					adjustedSum += adjustedCurrentValue;

					if (currentValue < lowestValue) {
						lowestValue = currentValue;
						adjustedLowestValue = adjustedCurrentValue;
					}

					if (currentValue > highestValue) {
						highestValue = currentValue;
						adjustedHighestValue = adjustedCurrentValue;
					}

					int colorValue = (int) (adjustedCurrentValue * 255);
					Color color = new Color(colorValue, colorValue, 0);

					heightMap.setRGB((int) x, (int) y, color.getRGB());

				}

			}

			try {

				String fileName = "HeightMap_" + (i + 1) + ".png";
				File outputFile = new File(fileName);
				outputFile.createNewFile();

				ImageIO.write(heightMap, "png", outputFile);

			} catch (Exception e) {

				System.out.println("Error - unable to output a heightmap for Run " + (i + 1) + "!");

			}

			double average = sum / totalPixels;
			double adjustedAverage = adjustedSum / totalPixels;

			System.out.println("Run " + (i + 1));
			System.out.println("Seed: " + seed);

			System.out.println("\nAverage value: " + average);
			System.out.println("Lowest value: " + lowestValue);
			System.out.println("Hightest value: " + highestValue);

			System.out.println("\nAverage adjusted value: " + adjustedAverage);
			System.out.println("Lowest adjusted value: " + adjustedLowestValue);
			System.out.println("Highest adjusted value: " + adjustedHighestValue);
			System.out.println();

		}

	}

}