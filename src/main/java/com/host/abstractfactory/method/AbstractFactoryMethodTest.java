package com.host.abstractfactory.method;

/**
 * @author CA Ankit_Kumar 
 * 		   The Abstract Factory design pattern is a creational
 *         design pattern that provides an interface for creating families of
 *         related or dependent objects without specifying their concrete
 *         classes. It allows you to encapsulate the object creation logic and
 *         provide a common interface for creating objects of different types.
 *         In Java, you can implement the Abstract Factory pattern using
 *         interfaces and classes.
 */


/**
 * When to use the Abstract Factory pattern in a project:
 * 1. When you need to create families of related or dependent objects.
 * 2. When you want to provide a client with a way to create objects without specifying their concrete classes.
 * 3. When you need to ensure that the created objects are compatible with each other.
 * 4. When you anticipate the need to introduce new families of products in the future.
 */


/**
 * Let's consider a car manufacturing company that produces different types of cars, such as Sedan, SUV, and Sports Car. 
 * Each car type requires the creation of various components, including the engine, tire, and body. 
 * The Abstract Factory pattern can be used to create different families of car components based on the type of car being manufactured.
 *
 */
public class AbstractFactoryMethodTest {
	public static void main(String[] args) {

		CarManufacturer sedanManufacturer = new CarManufacturer(new SedanCarFactory());
		sedanManufacturer.manufactureCar();

		CarManufacturer suvManufacturer = new CarManufacturer(new SuvCarFactory());
		suvManufacturer.manufactureCar();

		CarManufacturer sportsCarManufacturer = new CarManufacturer(new SportsCarFactory());
		sportsCarManufacturer.manufactureCar();

	}
}
/**
 * Abstract Factory Design Pattern Pros and Cons
 * 
 * Pros:
 * 1. Encapsulation: The Abstract Factory pattern encapsulates the creation of objects within the factory, 
 * providing a clear separation between object creation and object usage. Clients only need to interact with the abstract factory 
 * and its products, without being concerned about the specific implementations.
 * 2. Flexibility: By using the Abstract Factory pattern, you can easily swap or introduce new families of products by creating a 
 * new concrete factory that adheres to the abstract factory interface. This makes the system more flexible and adaptable to changes.
 * 3. Adherence to the Open-Closed Principle: The Abstract Factory pattern promotes the Open-Closed Principle, which states that the 
 * system should be open for extension but closed for modification. It allows you to introduce new types of products without modifying existing client code.
 * 4. Consistency: The Abstract Factory pattern ensures that the created objects are compatible with each other. The concrete factory 
 * guarantees that the created products belong to the same family, ensuring consistency in the system.
 * 
 * Cons:
 * 1. Complexity: The Abstract Factory pattern can introduce additional complexity to the system, especially when dealing with a large 
 * number of products and their variations. It requires defining multiple interfaces, concrete implementations, and their relationships.
 * 2. Increased number of classes: Implementing the Abstract Factory pattern often leads to an increased number of classes in the system, 
 * as each product family requires its own set of interfaces, concrete products, and factories. This can make the codebase larger and more complex.
 * 
 * 
 */
