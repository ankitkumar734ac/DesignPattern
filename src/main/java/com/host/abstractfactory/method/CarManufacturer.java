package com.host.abstractfactory.method;

//Client
//The client code (CarManufacturer) depends on the abstract factory interface (CarFactory) to create the products, and it interacts with the products through their abstract interfaces (Engine and Tire).
public class CarManufacturer {
	private CarFactory carFactory;

	public CarManufacturer(CarFactory factory) {
		this.carFactory = factory;
	}

	public void manufactureCar() {
		Engine engine = carFactory.createEngine();
		Tire tire = carFactory.createTire();

		System.out.println("Manufacturing a car:");
		engine.design();
		tire.manufacture();
		System.out.println("Car manufactured.\n");
	}

}

/**
 * Diff b/w Factory Method and Abstract Factory method
 * 
 * Factory Method Pattern:
 * 1. Purpose: The Factory Method pattern is used to create objects of a single product type. It provides an interface for 
 * creating objects, but the specific subclass that creates the object is determined at runtime.
 * 2. Structure: In the Factory Method pattern, there is an abstract creator class that declares the factory method. 
 * Concrete subclasses of the creator class implement the factory method to create specific product objects.
 * 3. Single Product Type: The Factory Method pattern focuses on creating a single product type, and the factory method 
 * returns instances of that specific product type.
 * 4. Subclass Responsibility: The responsibility of creating the product objects is delegated to the concrete subclasses,
 *  which implement the factory method.
 * 5. Extension: The Factory Method pattern is primarily used to support extension and allows the addition of new product 
 * types by creating new concrete creator subclasses.
 * 
 * Abstract Factory Pattern:
 * 1. Purpose: The Abstract Factory pattern is used to create families of related or dependent objects. 
 * It provides an interface for creating multiple types of products, where each product type belongs to a specific family.
 * 2. Structure: In the Abstract Factory pattern, there is an abstract factory interface that declares factory methods 
 * for creating the products. Concrete factory classes implement the abstract factory interface to create specific families of related products.
 * 3. Multiple Product Types: The Abstract Factory pattern focuses on creating families of related products, where each 
 * family can consist of multiple product types. The factory methods in the abstract factory interface return instances of different product types.
 * 4. Encapsulation: The responsibility of creating the product objects is encapsulated within the concrete factory classes.
 *  The client code interacts with the abstract factory and its products without being aware of the specific concrete implementations.
 * 5. Variation Across Families: The Abstract Factory pattern is used when you anticipate the need for different families of 
 * related products, with variations in their implementations. It ensures that the created objects within a family are compatible with each other.
 * 
 * 
 * In summary, 
 * the Factory Method pattern is used to create a single product type, while the Abstract Factory pattern is used to create families of related products. 
 * The Factory Method pattern focuses on extensibility by allowing the addition of new product types, while the Abstract Factory pattern focuses on providing families 
 * of compatible products with variations across families.
 * 
 */
