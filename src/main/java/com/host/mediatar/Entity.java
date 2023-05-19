package com.host.mediatar;

public interface Entity {
	void sendOrder(String order);

	void receiveOrder(String order);

	void sendPositionUpdate(double x, double y);

	void receivePositionUpdate(Entity entity, double x, double y);
}
/*
 * The Entity interface represents the various entities in the air traffic
 * control system, such as airplanes or runways. These entities communicate with
 * each other through the mediator.
 */

/**
 * The Mediator design pattern is useful in various situations where you have a
 * set of components that need to communicate and collaborate with each other.
 * Here are some common problem scenarios where the Mediator pattern can be
 * applied effectively:
 * 
 * 1. Complex communication logic: When you have a system with multiple
 * components that need to communicate in a complex manner, the Mediator pattern
 * can help simplify and centralize the communication logic. It allows you to
 * encapsulate the intricate communication rules within the Mediator, reducing
 * the complexity within individual components.
 * 
 * 2. Dependency management: If you want to reduce the dependencies between
 * components and avoid tight coupling, the Mediator pattern can be helpful. By
 * introducing a Mediator that acts as an intermediary, components can interact
 * without direct knowledge of each other, resulting in a more decoupled system.
 * 
 * 3. Component reusability: When you have reusable components that can be
 * utilized in different contexts, the Mediator pattern can facilitate their
 * integration. The Mediator acts as a bridge between the components, allowing
 * them to collaborate without being aware of the specific context in which they
 * are used.
 * 
 * 4. Event-driven systems: In event-driven systems where components need to
 * react to various events and coordinate their actions, the Mediator pattern
 * can be valuable. The Mediator can receive events from different components
 * and trigger appropriate actions or notify relevant components based on the
 * events received.
 * 
 * 5. GUI applications: Graphical User Interface (GUI) applications often have
 * multiple user interface components that need to interact with each other. The
 * Mediator pattern can help manage the communication and coordination between
 * these components, such as handling user interactions and updating the UI
 * accordingly.
 * 
 * 6. Distributed systems: In distributed systems where different modules or
 * services are distributed across multiple nodes, the Mediator pattern can
 * provide a centralized communication mechanism. The Mediator acts as a
 * communication hub, facilitating the exchange of messages and coordination
 * between the distributed components.
 * 
 * These are just a few examples of the problem domains where the Mediator
 * pattern can be applied effectively. Its primary goal is to promote loose
 * coupling and facilitate communication between components, making it a useful
 * pattern in scenarios where collaboration and interaction between components
 * are critical.
 */