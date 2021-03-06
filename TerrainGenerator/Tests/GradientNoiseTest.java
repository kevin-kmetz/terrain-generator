package TerrainGenerator.Tests;

// A test to verifty that NoiseGenerator correctly produces OpenSimplex noise
// under various parameters.

import TerrainGenerator.Gradient;
import TerrainGenerator.NoiseGenerator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.util.Random;

class GradientNoiseTest {

	public static void main (String[] args) {

		GradientNoiseTest gradientNoiseTest = new GradientNoiseTest();

	}

	GradientNoiseTest() {

		final double width = 960.0;
		final double height = 640.0;
		final double totalPixels = width * height;
		final double scale = 100.0;

		final int highestValue = 255;
		final int lowestValue = 0;
		final int octaves = 5;
		final double persistence = 0.5;
		final double lacunarity = 2.0;
		final boolean stretchNoise = true;

		final Color firstColor = new Color(Color.MAGENTA.getRGB());
		final Color secondColor = new Color(Color.YELLOW.getRGB());

		final Gradient gradient = new Gradient(firstColor, secondColor);

		Random random = new Random();
		final int numberOfRuns = 5;

		for (int i = 0; i < numberOfRuns; i++) {

			Long seed = random.nextLong();

			NoiseGenerator generator = new NoiseGenerator(highestValue, lowestValue, octaves, persistence, lacunarity, seed, stretchNoise);
			
			double rawNoiseSum = 0.0;
			double rawLowestValue = 0.0;
			double rawHighestValue = 0.0;

			double normalizedNoiseSum = 0.0;
			double normalizedLowestValue = 0.0;
			double normalizedHighestValue = 0.0;

			double noiseSum = 0.0;
			double noiseHighestValue = 0.0;
			double noiseLowestValue = 0.0;

			BufferedImage heightMap = new BufferedImage((int) width, (int) height, BufferedImage.TYPE_INT_RGB);

			for (double y = 0.0; y < height; y++) {

				for (double x = 0.0; x < width; x++) {

					double currentRawNoise = generator.getRawNoise(x/scale, y/scale);
					double currentNormalizedNoise = generator.getNormalizedNoise(x/scale, y/scale);
					double currentNoise = generator.getNoise(x/scale, y/scale);

					rawNoiseSum += currentRawNoise;
					normalizedNoiseSum += currentNormalizedNoise;
					noiseSum += currentNoise;

					if (currentRawNoise < rawLowestValue) {
						rawLowestValue = currentRawNoise;
						normalizedLowestValue = currentNormalizedNoise;
						noiseLowestValue = currentNoise;
					}

					if (currentRawNoise > rawHighestValue) {
						rawHighestValue = currentRawNoise;
						normalizedHighestValue = currentNormalizedNoise;
						noiseHighestValue = currentNoise;
					}

					int colorValue = (int) currentNoise;
					Color color = gradient.getColor(colorValue);

					heightMap.setRGB((int) x, (int) y, color.getRGB());

				}

			}

			try {

				String fileName = "GradientHeightMap_" + (i + 1) + ".png";
				File outputFile = new File(fileName);
				outputFile.createNewFile();

				ImageIO.write(heightMap, "png", outputFile);

			} catch (Exception e) {

				System.out.println("Error - unable to output a heightmap for Run " + (i + 1) + "!");

			}

			double rawAverage = rawNoiseSum / totalPixels;
			double normalizedAverage = normalizedNoiseSum / totalPixels;
			double noiseAverage = noiseSum / totalPixels;

			System.out.println("Run " + (i + 1));
			System.out.println("Seed: " + seed);

			System.out.println("\nAverage raw value: " + rawAverage);
			System.out.println("Lowest raw value: " + rawLowestValue);
			System.out.println("Highest raw value: " + rawHighestValue);

			System.out.println("\nAverage normalized value: " + normalizedAverage);
			System.out.println("Lowest normalized value: " + normalizedLowestValue);
			System.out.println("Highest normalized value: " + normalizedHighestValue);

			System.out.println("\nAverage value: " + noiseAverage);
			System.out.println("Lowest value: " + noiseLowestValue);
			System.out.println("Highest value: " + noiseHighestValue);
			System.out.println();

		}

	}

}