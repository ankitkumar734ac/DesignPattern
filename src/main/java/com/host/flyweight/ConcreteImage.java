package com.host.flyweight;

import java.awt.Graphics;

//ConcreteFlyweight class
public class ConcreteImage implements Image {
	private String path; // Intrinsic state

	public ConcreteImage(String path) {
		this.path = path;
		// Simulating the loading of image data from disk
		// and other resource-intensive operations
		System.out.println("Loading image from path: " + path);
	}

	@Override
	public void render(Graphics g, int x, int y) {
		// Simulating the rendering of the image
		g.drawImage((java.awt.Image)loadImageFromDisk(), x, y, null);
	}

	private Object loadImageFromDisk() {
		// Logic to load the image from disk
		// and return the image object
		return new Object(); // Placeholder for simplicity
	}
}