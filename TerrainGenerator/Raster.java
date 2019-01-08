package TerrainGenerator;

import java.util.LinkedList;

public class Raster {

	int width;
	int height;

	LinkedList<LinkedList<Integer>> raster;		// A LinkedList of rows of integers.

	public Raster (int width, int height) {

		this.width = width;
		this.height = height;

		raster = new LinkedList<LinkedList<Integer>>();

		for (int y = 0; y < height; y++) {
			raster.add(new LinkedList<Integer>());
		}

		for (LinkedList<Integer> i : raster) {
			for (int x = 0; x < width; x++) {
				i.add(-1);
			}
		}

	}

	public void display() {

		for (LinkedList<Integer> i : raster) {
			for (Integer k : i) {
				System.out.print(k + " ");
			}
			System.out.println();
		}

	}

}