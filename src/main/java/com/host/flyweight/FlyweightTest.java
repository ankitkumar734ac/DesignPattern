package com.host.flyweight;

public class FlyweightTest {
	/**
	 * In this example, we have the Font interface representing the flyweight
	 * objects. The ConcreteFont class implements this interface and represents the
	 * shared font data. The FontFactory class manages the pool of flyweight objects
	 * and provides a way to retrieve existing fonts or create new ones. The
	 * TextEditor class acts as the client code that uses the flyweight objects to
	 * display characters with specific fonts.
	 * 
	 * As we can observe, the font 'Arial' is shared by characters 'A' and 'C',
	 * while the font 'Calibri' is created and used only once. This sharing of the
	 * common font data helps in reducing memory usage and optimizing the
	 * performance of the text editor application.
	 */
	public static void main(String[] args) {
		TextEditor editor = new TextEditor();

		editor.displayCharacter('A', "Arial");
		editor.displayCharacter('B', "Times New Roman");
		editor.displayCharacter('C', "Arial");
		editor.displayCharacter('D', "Calibri");
	}

}
/*
 * The Flyweight design pattern is a structural design pattern that aims to
 * minimize the memory usage and improve the performance of an application by
 * sharing common data across multiple objects. It is used when an application
 * needs to create a large number of objects that share similar or identical
 * state, and the duplication of this state would consume a significant amount
 * of memory.
 * 
 * The main idea behind the Flyweight pattern is to separate the intrinsic
 * (shared) and extrinsic (unique) state of an object. The intrinsic state
 * represents the common data that can be shared among multiple objects, while
 * the extrinsic state represents the data that varies from object to object.
 * 
 * Here's how the Flyweight pattern typically works:
 * 
 * 1. Define a Flyweight interface or base class that declares the methods for
 * accessing and manipulating the intrinsic state.
 * 
 * 2. Create a ConcreteFlyweight class that implements the Flyweight interface
 * and represents the shared, immutable state of the objects.
 * 
 * 3. Create a FlyweightFactory class that manages a pool of flyweight objects.
 * It provides a way to retrieve a flyweight object based on the intrinsic
 * state. If a flyweight object with a particular intrinsic state already exists
 * in the pool, it returns that object; otherwise, it creates a new one and adds
 * it to the pool.
 * 
 * 4. Optionally, create an UnsharedConcreteFlyweight class that represents the
 * unique, mutable state of the objects. These objects are not shared and are
 * not affected by the FlyweightFactory.
 * 
 * 5. In the client code, use the FlyweightFactory to get or create flyweight
 * objects, and then set the extrinsic state specific to each object.
 * 
 * 
 * By sharing the common data, the Flyweight pattern reduces the memory
 * footprint of the application and allows more efficient use of resources. It
 * is particularly useful when there are a large number of objects with
 * overlapping state, such as in graphical applications where multiple objects
 * may share the same image or font.
 * 
 * It's important to note that the Flyweight pattern emphasizes memory
 * optimization and is most effective when dealing with large numbers of
 * objects. If the number of objects is small or the memory usage is not a
 * concern, the overhead of managing flyweights may outweigh the benefits.
 * Therefore, it's essential to consider the specific requirements and
 * constraints of your application before applying this pattern.
 */
