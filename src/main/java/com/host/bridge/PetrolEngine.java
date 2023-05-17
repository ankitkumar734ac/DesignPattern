package com.host.bridge;

public class PetrolEngine implements Engine {
	@Override
	public void startEngine() {
		System.out.println("Starting Petrol Engine");
	}

	@Override
	public void stopEngine() {
		System.out.println("Stopping Petrol Engine");
	}
}
/**
 * Yes, it is possible to break the Bridge design pattern if not implemented correctly. Here are a few ways to avoid breaking the pattern:
 * 
 * 1. Proper Abstraction-Implementation Separation: Ensure that you clearly define and separate the abstraction and implementation. The abstraction should depend on the implementation through an interface or abstract class, rather than directly depending on a concrete implementation. Avoid tightly coupling the abstraction and implementation classes.
 * 2. Avoiding Direct Access: The abstraction should not have direct access to the implementation's internal details. It should only interact with the implementation through the defined interface or abstract class. Avoid bypassing the abstraction and directly accessing the implementation.
 * 3. Consistent Naming and Semantics: Use consistent naming conventions and maintain a clear semantic relationship between the abstraction and implementation classes. This will help in understanding and maintaining the codebase. Avoid using ambiguous or misleading names that may lead to confusion.
 * 4. Careful Design and Refactoring: During the design phase, carefully analyze the relationships and dependencies between the abstraction and implementation. Consider the specific requirements and potential changes that may occur in the future. Refactor the codebase as needed to ensure a proper separation and minimize dependencies.
 * 5. Follow SOLID Principles: Apply the SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion) to guide your design and implementation. These principles promote loose coupling, abstraction, and flexibility, which align well with the goals of the Bridge pattern.
 * 6. Testing and Code Reviews: Conduct thorough testing and code reviews to identify any potential violations of the Bridge pattern. Ensure that the abstraction and implementation classes are properly separated and that the interactions between them conform to the intended design. Test different scenarios and edge cases to validate the correct usage of the pattern.
 * 
 * By following these guidelines, you can avoid breaking the Bridge pattern and ensure that the abstraction and implementation remain decoupled, providing the intended benefits of flexibility and extensibility.
 */