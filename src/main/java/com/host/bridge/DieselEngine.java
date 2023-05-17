package com.host.bridge;

public class DieselEngine implements Engine {
	@Override
	public void startEngine() {
		System.out.println("Starting Diesel Engine");
	}

	@Override
	public void stopEngine() {
		System.out.println("Stopping Diesel Engine");
	}
}
/**
 * When we need to use Bridge Design Pattern
 * 
 * The Bridge design pattern is used when you want to decouple an abstraction from its implementation so that they can vary independently. It is useful in the following scenarios:
 * 1. When you want to separate an abstraction (such as an interface or an abstract class) from its concrete implementation. This is helpful when you have multiple implementations of an abstraction and want to switch between them dynamically without affecting the client code.
 * 2. When you want to avoid a permanent binding between an abstraction and its implementation. By using the Bridge pattern, you can change the implementation at runtime, which provides flexibility and extensibility to your system.
 * 3. When you want to extend and add new functionalities without modifying the existing code. The Bridge pattern allows you to introduce new abstractions and implementations independently, enabling you to add new features to your system without impacting the existing codebase.
 * 4. When you have a complex class hierarchy that is difficult to manage and maintain. The Bridge pattern helps to simplify the class hierarchy by separating the abstraction and implementation into separate class hierarchies, making the system more manageable and reducing coupling.
 * 5. When you want to hide implementation details from the client code. The Bridge pattern encapsulates the implementation details behind an abstraction, providing a clean and simplified interface for the clients to interact with.
 * 
 * Overall, the Bridge design pattern is useful when you need to decouple abstractions from their implementations, provide flexibility and extensibility, and manage complex class hierarchies.
 */
