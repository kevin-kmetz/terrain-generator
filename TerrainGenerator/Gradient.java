package TerrainGenerator;

import java.awt.Color;

public class Gradient {

	private Color firstColor;
	private Color secondColor;

	private float gradientSlopeRed = 1.0;
	private float gradientInterceptRed = 0.0;
	private float gradientSlopeGreen = 1.0;
	private float gradientInterceptGreen = 0.0;
	private float gradientSlopeBlue = 1.0;
	private float gradientInterceptBlue = 0.0;

	private float conversionSlopeRed = 1.0;
	private float conversionInterceptRed = 0.0;
	private float conversionSlopeGreen = 1.0;
	private float conversionInterceptGreen = 0.0;
	private float conversionSlopeBlue = 1.0;
	private float conversionInterceptBlue = 0.0;

	public Gradient(int firstRed, int firstGreen, int firstBlue, int secondRed, int secondGreen, int secondBlue) {

		firstColor = new Color(firstRed, firstGreen, firstBlue);
		secondColor = new Color(secondRed, secondGreen, secondBlue);

	}

	public Gradient(Color firstColor, Color secondColor) {

		this.firstColor = new Color(firstColor.getRGB());
		this.secondColor = new Color(secondColor.getRGB());

	}

	void calculateGradient() {

		// [a, b] -> [c, d]
		// y = (x - a)( (d - c)/(b - a) ) + c
		// y = x*blob - a*bloc + c
		// y = Px + Q
		


	}

	void getSlopeAndIntercept() {
		
	}

}