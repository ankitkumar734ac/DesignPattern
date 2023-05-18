package com.host.proxy;

//Step 2: Implement the real object
public class RealImage implements Image {
	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadFromDisk();
	}

	@Override
	public void display() {
		System.out.println("Displaying image: " + filename);
	}

	private void loadFromDisk() {
		System.out.println("Loading image: " + filename);
	}

}
