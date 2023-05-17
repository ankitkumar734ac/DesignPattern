package com.host.facade;

/**
 * 
 * @author CA Ankit_Kumar 
 * 		   The Facade design pattern is a structural design
 *         pattern that provides a simplified interface to a complex subsystem
 *         of classes, making it easier to use and understand. It promotes loose
 *         coupling between the client and the subsystem, as the client only
 *         interacts with a single interface provided by the Facade.
 * 
 *         The main idea behind the Facade pattern is to hide the complexities
 *         of a subsystem by providing a unified interface. It acts as a single
 *         entry point for the client to access the subsystem's functionality,
 *         abstracting away the underlying implementation details.
 * 
 *         To implement the Facade pattern in Java, you can follow these steps:
 * 
 *         1. Identify a complex subsystem: Identify the classes and components
 *         that make up the complex subsystem that you want to simplify.
 * 
 *         2. Create a Facade class: Create a Facade class that encapsulates the
 *         interactions with the subsystem. The Facade should provide a simple
 *         and unified interface that hides the complexities of the subsystem.
 * 
 *         3. Implement methods in the Facade: Implement methods in the Facade
 *         class that delegate the calls to the appropriate classes within the
 *         subsystem. The Facade orchestrates the interactions and handles any
 *         necessary conversions or transformations.
 * 
 *         4. Hide the subsystem from the client: Ensure that the client only
 *         interacts with the Facade class and does not have direct access to
 *         the subsystem's classes. This promotes loose coupling and allows the
 *         subsystem to evolve independently.
 * 
 *         Here's a complex example to illustrate the Facade pattern:
 * 
 *         Let's assume we have a multimedia system with multiple components,
 *         including a DVD player, a projector, and a surround sound system. We
 *         want to create a unified interface for controlling these components.
 *
 */
public class FacadeTest {
	public static void main(String[] args) {
		HomeTheaterFacade homeTheater = new HomeTheaterFacade();
		homeTheater.watchMovie();
	}
}
/**
 * In this example, we have a complex subsystem consisting of three classes:
 * DVDPlayer, Projector, and SurroundSoundSystem. We create a HomeTheaterFacade
 * class that provides a unified interface for controlling the subsystem. The
 * HomeTheaterFacade class creates instances of the subsystem classes and
 * delegates the calls to them in the watchMovie method.
 * 
 * By using the HomeTheaterFacade, the client only needs to interact with a
 * single class and doesn't need to know the details of how the DVD player,
 * projector, and surround sound system are controlled. The Facade encapsulates
 * the complexity of the subsystem, providing a simpler and more convenient
 * interface for the client.
 * 
 * Please note that this is a simplified example to demonstrate the concept of
 * the Facade pattern. In real-world scenarios, the complexity of the subsystem
 * can be much higher, and the Facade pattern helps to simplify its usage.
 */
