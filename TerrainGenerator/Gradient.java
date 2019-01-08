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

	/*private float conversionSlopeRed = 1.0;
	private float conversionInterceptRed = 0.0;
	private float conversionSlopeGreen = 1.0;
	private float conversionInterceptGreen = 0.0;
	private float conversionSlopeBlue = 1.0;
	private float conversionInterceptBlue = 0.0;*/

	public Gradient(int firstRed, int firstGreen, int firstBlue, int secondRed, int secondGreen, int secondBlue) {

		//firstColor = new Color(firstRed, firstGreen, firstBlue);
		//secondColor = new Color(secondRed, secondGreen, secondBlue);

		this(new Color(firstRed, firstGreen, firstBlue), newColor(secondRed, secondGreen, secondBlue));

	}

	public Gradient(Color firstColor, Color secondColor) {

		this.firstColor = new Color(firstColor.getRGB());
		this.secondColor = new Color(secondColor.getRGB());

		calculateGradientVariables();

	}

	void calculateGradientVariables() {

		float[] redSlopeIntercept = getSlopeIntercept(firstColor.getRed(), secondColor.getRed());
		gradientSlopeRed = redSlopeIntercept[0];
		gradientInterceptRed = redSlopeIntercept[1];

		float[] greenSlopeIntercept = getSlopeIntercept(firstColor.getGreen(), secondColor.getGreen());
		gradientSlopeGreen = greenSlopeIntercept[0];
		gradientInterceptGreen = greenSlopeIntercept[1];

		float[] blueSlopeIntercept = getSlopeIntercept(firstColor.getBlue(), secondColor.getBlue());
		gradientSlopeBlue = blueSlopeIntercept[0];
		gradientInterceptBlue = blueSlopeIntercept[1];

	}

	/*void calculateConversionVariables() {

	}*/

	private float[] getSlopeIntercept(int newStartingValue, int newEndingValue) {

		// [a, b] -> [c, d]
		// y = (x - a)( (d - c)/(b - a) ) + c
		// y = x*blob - a*bloc + c
		// y = Px + Q

		float newSV = newStartingValue;
		float newEV = newEndingValue;

		float grayScaleStart = 0.0;
		float grayScaleEnd = 255.0;

		float slope;
		float intercept;

		float determinant = (newEV - newSV)/(grayScaleEnd - grayScaleStart);

		float slope = determinant;
		float intercept = newSV - grayScaleStart*determinant;

		float[] slopeIntercept = { slope, intercept };

		return slopeIntercept;
	}
	
	public Color getColor(int colorValue) {

		// int inputRed = inputColor.getRed();
		// int inputGreen = inputColor.getGreen();
		// int inputBlue = inputColor.getBlue();

		float outputRed = ((float) colorValue)*gradientSlopeRed +gradientInterceptRed;
		float outputGreen = ((float) colorValue)*gradientSlopeGreen +gradientInterceptGreen;
		float outputBlue = ((float) colorValue)*gradientSlopeBlue +gradientInterceptBlue;

		return new Color((int) outputRed, (int) outputGreen, (int) outputBlue);

	}

}