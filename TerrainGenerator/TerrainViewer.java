package TerrainGenerator;

import java.awt.*;

class TerrainViewer {

	private TerrainGenerator generator;

	public static void main(String[] args) {

		TerrainViewer viewer = new TerrainViewer();

	}

	TerrainViewer() {

		generator = new TerrainGenerator();
		generator.generateTerrain();

		Frame frame = new Frame("Terrain Viewer");
		frame.setLayout(null);
		frame.setSize(960, 640);

		Canvas canvas = new Canvas();
		canvas.setSize(960, 640);
		frame.add(canvas);

		frame.setVisible(true);

		Image image = generator.getImage();
		canvas.getGraphics().drawImage(image, 0, 0, null);

	}

}