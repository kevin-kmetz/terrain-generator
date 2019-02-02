package TerrainGenerator;

import java.util.Random;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

class TerrainViewer {

	private TerrainGenerator generator;
	private Frame frame = new Frame("Terrain Viewer");
	private ImageCanvas canvas = new ImageCanvas();
	private Random random = new Random();
	private HeightPalette palette = new HeightPalette();
	private Image image;

	private int xPosition = 0;
	private int yPosition = 0;

	public static void main(String[] args) {

		TerrainViewer viewer = new TerrainViewer();

	}

	TerrainViewer() {

		generator = new TerrainGenerator();
		generator.generateTerrain();

		palette.add(0, 15, 0, 80);			// deep ocean
		palette.add(45, 35, 0, 190);		// ocean
		palette.add(230, 255, 255, 255);	// snow top
		palette.add(90, 255, 230, 175);		// sand
		palette.add(115, 85, 220, 75);		// grass
		palette.add(155, 60, 150, 50);		// elevated grass
		//palette.add(185, 75, 50, 20);		// mountain

		//Frame frame = new Frame("Terrain Viewer");
		frame.setLayout(null);
		frame.setSize(960, 640);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});

		//Canvas canvas = new Canvas();
		canvas.setSize(960, 640);
		frame.add(canvas);
		frame.addKeyListener(new KeyListener());

		frame.setVisible(true);

		image = generator.getImage();
		canvas.getGraphics().drawImage(image, 0, 0, null);

	}

	class ImageCanvas extends Canvas {

		public void paint(Graphics graphic) {

			//graphic.drawImage(image, 0, 0, null);
			System.out.println("Inside paint");

		}

	}

	class KeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent event) {

			char keyPressCharacter = event.getKeyChar();

			if (keyPressCharacter == 'n') {

				System.out.println("Inside KeyListener");
				xPosition = 0;
				yPosition = 0;
				generator = new TerrainGenerator(960, 640, 255, 0, 5, 0.5, 2.0, random.nextLong(), true, palette);
				generator.generateTerrain();
				image = generator.getImage();
				Graphics graphic = canvas.getGraphics();
				graphic.drawImage(image, 0, 0, null);
				canvas.paint(graphic);

			} else if (keyPressCharacter == 'a') {

				xPosition -= 50;
				generator.setPosition(xPosition, yPosition);
				generator.generateTerrain();
				image = generator.getImage();
				Graphics graphic = canvas.getGraphics();
				graphic.drawImage(image, 0, 0, null);
				canvas.paint(graphic);

			}

		}

	}

}