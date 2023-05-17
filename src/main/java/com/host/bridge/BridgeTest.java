package com.host.bridge;
/**
 * 
 * @author CA Ankit_Kumar
 * 
 * The Bridge design pattern is a structural design pattern that decouples an abstraction from its implementation so that the two can 
 * vary independently. It provides a way to separate the abstraction and implementation into two hierarchies, allowing them to evolve 
 * independently.
 * 
 * In Java, you can implement the Bridge design pattern using the following steps:
 * 1. Identify the abstraction and implementation: 
 * 		The abstraction represents the higher-level interface, while the implementation represents the lower-level implementation details.
 * 2. Create an abstraction interface or abstract class: 
 * 		Define the methods that represent the high-level functionality or behavior. This interface or abstract class will be used
 * 		 by the client code to interact with the abstraction.
 *
 */
public class BridgeTest {
	// Usage

	public static void main(String[] args) {
		Engine petrolEngine = new PetrolEngine();
		Engine dieselEngine = new DieselEngine();

		Vehicle car = new Car(petrolEngine);
		Vehicle bike = new Bike(dieselEngine);

		car.start();
		car.stop();

		bike.start();
		bike.stop();
	}
	/**
	 * In this example, the Bridge pattern is used to separate the abstraction "Vehicle" from its implementation "Engine." 
	 * This allows different types of vehicles (Car, Bike) to use different types of engines (PetrolEngine, DieselEngine) independently.
	 * By modifying the implementation, such as introducing a new type of engine, the vehicles using that implementation remain unaffected.
	 */
	
	/**
	 * The Bridge design pattern has several advantages and disadvantages. Let's explore the pros and cons of using the Bridge pattern:
	 * 
	 * Pros:
	 * 1. Decoupling of Abstraction and Implementation: The Bridge pattern allows you to separate the abstraction from its implementation, which reduces the coupling between them. This separation enables you to modify and vary them independently, making your system more flexible and adaptable to changes.
	 * 2. Extensibility and Flexibility: By using the Bridge pattern, you can easily introduce new abstractions and implementations without modifying the existing code. This promotes extensibility and allows for dynamic changes at runtime, giving you the flexibility to add new features or switch implementations as needed.
	 * 3. Improved Maintainability: The Bridge pattern simplifies the class hierarchy by separating the abstraction and implementation into separate class hierarchies. This separation makes the codebase more maintainable and easier to understand, as it reduces the complexity associated with managing a single, large class hierarchy.
	 * 4. Hiding Implementation Details: The Bridge pattern encapsulates the implementation details behind an abstraction, providing a clean and simplified interface for clients. This abstraction shields the clients from the complexity of the implementation, making it easier to work with and reducing dependencies on specific implementations.
	 * 
	 * Cons:
	 * 1. Increased Complexity: Implementing the Bridge pattern introduces additional abstraction and implementation classes, which can increase the overall complexity of the system. This can make the codebase more difficult to understand and maintain, especially for simpler scenarios where the Bridge pattern may not be necessary.
	 * 2. Overhead: The Bridge pattern adds an additional layer of indirection between the abstraction and implementation. This indirection can introduce some performance overhead, especially in scenarios where frequent communication and coordination between the abstraction and implementation are required.
	 * 3. Initial Design Effort: Applying the Bridge pattern requires careful consideration and design upfront. You need to identify the areas where the pattern is beneficial and properly define the abstractions and implementations. This initial design effort can be time-consuming and may not be justified for smaller or less complex systems.
	 * 4. Increased Number of Classes: The Bridge pattern involves creating separate class hierarchies for the abstraction and implementation. This can lead to an increased number of classes in your system, which might be challenging to manage and understand, especially in larger projects.
	 * 
	 * Overall, the Bridge design pattern provides advantages such as decoupling, extensibility, flexibility, and improved maintainability. However, it comes with the trade-offs of increased complexity, overhead, initial design effort, and a potentially larger number of classes. It is important to evaluate these factors based on the specific requirements and complexity of your project before deciding to use the Bridge pattern.
	 */
}
