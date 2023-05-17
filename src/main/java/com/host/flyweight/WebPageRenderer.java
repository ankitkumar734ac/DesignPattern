package com.host.flyweight;

import java.awt.Graphics;

//Client code
public class WebPageRenderer {
	private ImageFactory imageFactory;

	public WebPageRenderer() {
		imageFactory = new ImageFactory();
	}

	public void renderImage(String path, int x, int y) {
		Image image = imageFactory.getImage(path);
		Graphics g = getGraphicsContext(); // Obtain the graphics context
		image.render(g, x, y);
	}

	private Graphics getGraphicsContext() {
		// Logic to obtain the graphics context for rendering
		// This is just a placeholder for simplicity
		return null;
	}

	public static void main(String[] args) {
		WebPageRenderer renderer = new WebPageRenderer();

		renderer.renderImage("image1.jpg", 100, 100);
		renderer.renderImage("image2.jpg", 200, 200);
		renderer.renderImage("image1.jpg", 300, 300);
		renderer.renderImage("image3.jpg", 400, 400);
	}
}
