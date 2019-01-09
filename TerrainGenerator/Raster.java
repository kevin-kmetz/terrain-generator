package TerrainGenerator;

import java.util.LinkedList;

public class Raster {

	private int width;
	private int height;

	private int[][] raster;		// A LinkedList of rows of integers.

	public Raster(int width, int height) {

		this.width = width;
		this.height = height;

		raster = new int[height][width];

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				raster[y][x] = -1;

			}

		}

	}

	public void set(int x, int y, int value) {

		raster[y][x] = value;

	}

	public int get(int x, int y) {

		return raster[y][x];

	}

	public void display() {

		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {

				System.out.print(raster[y][x] + " ");

			}

			System.out.println();

		}

	}

	public void appendTop(int[] row) {

		int[][] updatedRaster = new int[height][width];

		System.arraycopy(row, 0, updatedRaster[0], 0, updatedRaster[0].length);

		for (int i = 0; i < raster.length-1; i++) {
			System.arraycopy(raster[i], 0, updatedRaster[i+1], 0, raster[i].length);
		}

		System.arraycopy(updatedRaster, 0, raster, 0, raster.length);

	}

	public void appendTop(int[][] rows) {

		int[][] updatedRaster = new int[height][width];

		for (int i = 0; i < rows.length; i++) {
			System.arraycopy(rows[i], 0, updatedRaster[i], 0, updatedRaster[i].length);
		}

		for (int i = rows.length; i < height; i++) {
			System.arraycopy(raster[i-rows.length], 0, updatedRaster[i], 0, updatedRaster[i].length);
		}

		System.arraycopy(updatedRaster, 0, raster, 0, raster.length);

	}

	public void appendBottom(int[] row) {

		int[][] updatedRaster = new int[height][width];

		int rowsToAppend = 1;
		int rowsToShiftUp = height - rowsToAppend;

		// Shift (height - 1) rows to preserve up.
		for (int insertionIndex = 0, oldRasterIndex = rowsToAppend; insertionIndex < rowsToShiftUp; insertionIndex++, oldRasterIndex++) {
			System.arraycopy(raster[oldRasterIndex], 0, updatedRaster[insertionIndex], 0, width);
		}

		// Insert single new row at the bottom of the raster, in its very last row.
		System.arraycopy(row, 0, updatedRaster[updatedRaster.length-1], 0, width);

		System.arraycopy(updatedRaster, 0, raster, 0, raster.length);

	}

	public void appendBottom(int[][] rows) {

		int[][] updatedRaster = new int[height][width];

		int rowsToAppend = rows.length;
		int rowsToShiftUp = height - rowsToAppend;

		// Shift rows to preserve up.
		for (int insertionIndex = 0, oldRasterIndex = rowsToAppend; insertionIndex < rowsToShiftUp; insertionIndex++, oldRasterIndex++) {
			System.arraycopy(raster[oldRasterIndex], 0, updatedRaster[insertionIndex], 0, width);
		}

		// Insert new rows at the bottom.
		for (int insertionIndex = height - rowsToAppend, rowIndex = 0; rowIndex < rowsToAppend; insertionIndex++, rowIndex++) {
			System.arraycopy(rows[rowIndex], 0, updatedRaster[insertionIndex], 0, width);
		}

		System.arraycopy(updatedRaster, 0, raster, 0, raster.length);

	}

}