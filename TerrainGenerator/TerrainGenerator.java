package TerrainGenerator;

public class TerrainGenerator {

	private HeightPalette palette;
	private NoiseGenerator generator;
	private Raster heightRaster;

	private int xLength;
	private int yLength;

	private int lowestValue;
	private int highestValue;
	private int octaves;
	private double persistence;
	private double lacunarity;
	private long seed;
	private boolean utilizeStretch;

	private int xPosition;
	private int yPosition;
	private double scale;

	private static final int DEFAULT_X_LENGTH = 960;
	private static final int DEFAULT_Y_LENGTH = 640;

	private static final int DEFAULT_LOWEST_VALUE = 0;
	private static final int DEFAULT_HIGHEST_VALUE = 255;
	private static final int DEFAULT_OCTAVES = 5;
	private static final double DEFAULT_PERSISTENCE = 0.5;
	private static final double DEFAULT_LACUNARITY = 2.0;
	private static final long DEFAULT_SEED = 0L;
	private static final boolean DEFAULT_UTILIZE_STRETCH = false;

	private static final int DEFAULT_X_POSITION = 0;
	private static final int DEFAULT_Y_POSITION = 0;
	private static final double DEFAULT_SCALE = 100.0;

	public TerrainGenerator() {

		xLength = DEFAULT_X_LENGTH;
		yLength = DEFAULT_Y_LENGTH;

		highestValue = DEFAULT_HIGHEST_VALUE;
		lowestValue = DEFAULT_HIGHEST_VALUE;
		octaves = DEFAULT_OCTAVES;
		persistence = DEFAULT_PERSISTENCE;
		lacunarity = DEFAULT_LACUNARITY;
		seed = DEFAULT_SEED;
		utilizeStretch = DEFAULT_UTILIZE_STRETCH;

		xPosition = DEFAULT_X_POSITION;
		yPosition = DEFAULT_Y_POSITION;
		scale = DEFAULT_SCALE;

		palette = new HeightPalette();
		palette.add(0, 15, 0, 80);			// deep ocean
		palette.add(45, 35, 0, 190);		// ocean
		palette.add(230, 255, 255, 255);	// snow top
		palette.add(90, 255, 230, 175);		// sand
		palette.add(115, 85, 220, 75);		// grass
		palette.add(155, 60, 150, 50);		// elevated grass
		palette.add(185, 75, 50, 20);		// mountain

		generator = new NoiseGenerator(highestValue, lowestValue, octaves, persistence, lacunarity, seed, utilizeStretch);

		heightRaster = new Raster(xLength, yLength);

	}

	public TerrainGenerator(int xLength, int yLength, int highestValue, int lowestValue, int octaves, double persistence, double lacunarity, long seed, boolean utilizeStretch, HeightPalette palette) {

		this.xLength = xLength;
		this.yLength = yLength;

		this.highestValue = highestValue;
		this.lowestValue = lowestValue;
		this.octaves = octaves;
		this.persistence = persistence;
		this.lacunarity = lacunarity;
		this.seed = seed;
		this.utilizeStretch = utilizeStretch;

		this.palette = palette;

		xPosition = DEFAULT_X_POSITION;
		yPosition = DEFAULT_X_POSITION;
		scale = DEFAULT_SCALE;

		generator = new NoiseGenerator(highestValue, lowestValue, octaves, persistence, lacunarity, seed, utilizeStretch);

		heightRaster = new Raster(xLength, yLength);

	}

	public void setGeneratorToDefaults() {

	}

}