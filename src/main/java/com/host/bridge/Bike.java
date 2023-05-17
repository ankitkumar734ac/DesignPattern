package com.host.bridge;

public class Bike extends Vehicle {
	public Bike(Engine engine) {
		super(engine);
	}

	@Override
	public void start() {
		System.out.println("Starting Bike");
		engine.startEngine();
	}

	@Override
	public void stop() {
		System.out.println("Stopping Bike");
		engine.stopEngine();
	}
}
/**
 * Abstract Design Pattern VS Bridge Design Pattern
 * 
 * The Adapter and Bridge design patterns are both structural patterns that aim to decouple different components of a system. However, they serve different purposes and are used in different contexts:
 * 
 * Adapter Design Pattern:
 * The Adapter design pattern is used to make two incompatible interfaces work together. It acts as a bridge between two existing interfaces, allowing them to collaborate without requiring changes to their existing code. The Adapter pattern typically involves a single adapter class that converts the interface of one class into the interface expected by the client code.
 * 
 * Key characteristics of the Adapter pattern:
 * 1.It resolves the incompatibility between two existing interfaces.
 * 2.It typically involves a single adapter class that adapts the interface of one class to match the expected interface of another class or system.
 * 3.It is used when you have existing classes/interfaces that cannot work together directly, and you want to make them collaborate without modifying their code.
 * 4.It typically involves wrapping one object with another to provide the necessary adaptation.
 * 
 * Bridge Design Pattern:
 * The Bridge design pattern is used to decouple an abstraction from its implementation, allowing them to vary independently. It provides a bridge between an abstraction (interface or abstract class) and its implementation, allowing them to be developed and modified independently of each other. The Bridge pattern involves two separate class hierarchies, one for the abstraction and one for the implementation, connected through a bridge.
 * 
 * Key characteristics of the Bridge pattern:
 * 1.It separates the abstraction from its implementation, allowing them to vary independently.
 * 2.It involves two separate class hierarchies, one for the abstraction and one for the implementation, connected through a bridge.
 * 3.It is used when you want to decouple the abstraction and implementation to allow them to evolve independently.
 * 4.It provides flexibility to switch or extend different implementations of the abstraction without impacting the client code.
 * 
 * In summary, the Adapter pattern is used to make two incompatible interfaces work together, while the Bridge pattern is used to decouple an abstraction from its implementation. The Adapter pattern focuses on resolving interface incompatibilities, while the Bridge pattern focuses on separating the abstraction from the implementation to provide flexibility and extensibility.
 * 
 */