package com.host.flyweight;

import java.util.HashMap;
import java.util.Map;

//FlyweightFactory class
public class ImageFactory {
	private Map<String, Image> imagePool;

	public ImageFactory() {
		imagePool = new HashMap<>();
	}

	public Image getImage(String path) {
		Image image = imagePool.get(path);

		if (image == null) {
			image = new ConcreteImage(path);
			imagePool.put(path, image);
		}

		return image;
	}
}