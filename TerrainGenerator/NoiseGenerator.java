package TerrainGenerator;

import java.util.Random;

public class NoiseGenerator {

	OpenSimplexNoise openSimplexNoise;
	long seed;

	int octaves;
	double persistence;
	double lacunarity;
	boolean stretchNoise;

	int highestValue;
	int lowestValue;
	int spread;
	int offset;

	public NoiseGenerator() {
		
		this(0, 255, 5, 0.5, 2.0, 0L, false);

	}

	public NoiseGenerator(int highestValue, int lowestValue, int octaves, double persistence, double lacunarity, long seed, boolean stretchNoise) {

		this.highestValue = highestValue;
		this.lowestValue = lowestValue;
		this.octaves = octaves;
		this.persistence = persistence;
		this.lacunarity = lacunarity;
		this.seed = seed;
		this.stretchNoise = stretchNoise;

		spread = highestValue - lowestValue;
		offset = 0 - lowestValue;

		openSimplexNoise = new OpenSimplexNoise(seed);

	}

	public double getRawNoise(double x, double y) {

		double totalNoise = 0;
		double currentFrequency = 1;
		double currentAmplitude = 1;

		double summedAmplitudes = 0;

		for (int i = 0; i < octaves; i++) {

			totalNoise += openSimplexNoise.eval(x*currentFrequency, y*currentFrequency) * currentAmplitude;
			summedAmplitudes += currentAmplitude;

			currentAmplitude *= persistence;
			currentFrequency *= lacunarity;

		}

		double outputNoise = totalNoise/summedAmplitudes;

		if (stretchNoise == true) {
			// This enables the raw noise to cover all values from -1 to 1, instead of -0.865 to 0.865.
			// The constant needs to change based on all of the generator's initial parameters, so this needs to be improved.
			outputNoise *= 1.149425287;
		}

		return outputNoise;

	}

	public double getNormalizedNoise(double x, double y) {

		double rawNoise = getRawNoise(x, y);

		double normalizedNoise = (rawNoise + 1.0) / 2.0;

		return normalizedNoise;

	}

	public double getNoise(double x, double y) {

		double normalizedNoise = getNormalizedNoise(x, y);

		double adjustedNoise = (normalizedNoise * (double) spread) - (double) offset;

		return adjustedNoise;

	}

}