package com.host.facade;

// Facade Class
public class HomeTheaterFacade {
	private DVDPlayer dvdPlayer;
	private Projector projector;
	private SurroundSoundSystem surroundSoundSystem;

	public HomeTheaterFacade() {
		this.dvdPlayer = new DVDPlayer();
		this.projector = new Projector();
		this.surroundSoundSystem = new SurroundSoundSystem();
	}

	public void watchMovie() {
		dvdPlayer.on();
		projector.on();
		projector.setInput(dvdPlayer);
		surroundSoundSystem.on();
		surroundSoundSystem.setDVDPlayer(dvdPlayer);
		dvdPlayer.playMovie();
	}

	// Other methods for different operations...

}
/*
 * Pros VS Cons
 * 
 * The Facade pattern has several advantages and disadvantages, which are
 * summarized below:
 * 
 * Pros:
 * 
 * Simplified interface: The Facade pattern provides a simple and unified
 * interface to a complex subsystem, making it easier for clients to use. It
 * hides the complexity and reduces the learning curve for interacting with the
 * subsystem.
 * 
 * Encapsulation and abstraction: The Facade encapsulates the implementation
 * details of the subsystem and provides a higher-level interface. This promotes
 * encapsulation and abstraction, allowing clients to interact with the
 * subsystem without being exposed to its internal complexities.
 * 
 * Decoupling: The Facade pattern promotes loose coupling between the client and
 * the subsystem. Clients only need to interact with the Facade and are unaware
 * of the individual components and their interactions within the subsystem.
 * This reduces dependencies and improves maintainability.
 * 
 * Improved maintainability: Since the Facade acts as a central point of control
 * for the subsystem, any changes or updates to the subsystem can be isolated
 * within the Facade. This simplifies maintenance and reduces the impact of
 * changes on the client code.
 * 
 * Cons:
 * 
 * Limited flexibility: The Facade pattern aims to simplify the usage of a
 * subsystem by providing a simplified interface. However, this simplicity may
 * come at the cost of reduced flexibility. Clients may not have direct access
 * to all the functionality and customization options provided by the subsystem.
 * 
 * Reduced granularity: The Facade pattern abstracts away the individual
 * components and operations of the subsystem, providing a higher-level
 * interface. This can lead to a loss of granularity, making it more challenging
 * to perform fine-grained operations on the subsystem if needed.
 * 
 * Increased complexity of the Facade: As the complexity of the subsystem grows,
 * the Facade itself may become more complex. It may need to handle numerous
 * interactions and orchestrate multiple subsystem components, which can make
 * the Facade class itself harder to understand and maintain.
 * 
 * Dependency on the Facade: Clients relying heavily on the Facade pattern may
 * become tightly coupled with the Facade itself. If the Facade changes or needs
 * to be replaced, it can have a significant impact on the client code,
 * potentially requiring extensive modifications.
 * 
 * It's important to consider these pros and cons when deciding whether to use
 * the Facade pattern. It is most beneficial when there is a need to simplify
 * and provide a unified interface to a complex subsystem while maintaining
 * loose coupling and abstraction.
 * 
 */