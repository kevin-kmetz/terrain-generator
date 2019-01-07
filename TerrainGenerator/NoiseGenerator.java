package TerrainGenerator;

import java.util.Random;

class NoiseGenerator {

	OpenSimplexNoise openSimplexNoise;
	long seed;

	int octaves;
	double persistence;
	double lacunarity;

	int highestValue;
	int lowestValue;
	int spread;
	int offset;

	public NoiseGenerator() {
		
		this(0, 255, 5, 0.5, 2.0, 0L);

	}

	public NoiseGenerator(int highestValue, int lowestValue, int octaves, double persistence, double lacunarity, long seed) {

		this.highestValue = highestValue;
		this.lowestValue = lowestValue;
		this.octaves = octaves;
		this.persistence = persistence;
		this.lacunarity = lacunarity;
		this.seed = seed;

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

		return outputNoise;

	}

	public double getNoise(double x, double y) {

		double rawNoise = getRawNoise(x, y);

		double adjustedNoise = (rawNoise * (double) spread) - (double) offset;

		return adjustedNoise;

	}

}