package com.host.mediatar;

/**
 * 
 * @author Ankit_Kumar
 *
 *         The Mediator design pattern is a behavioral design pattern that
 *         promotes loose coupling between components by introducing a mediator
 *         object that encapsulates the communication logic between them. It
 *         allows components to communicate with each other without having
 *         direct references to each other, thus reducing dependencies and
 *         making the system more maintainable
 */
public class MediatorTest {
	public static void main(String[] args) {
		AirTrafficControlTower controlTower = new AirTrafficControlTower();

		Airplane airplane1 = new Airplane(controlTower);
		Airplane airplane2 = new Airplane(controlTower);

		airplane1.sendOrder("Maintain altitude of 30,000 feet.");
		airplane2.sendOrder("Prepare for landing.");

		airplane1.sendPositionUpdate(100, 200);
		airplane2.sendPositionUpdate(500, 600);
	}

}
/*
 * In an air traffic control system, there are multiple entities involved, such
 * as airplanes, runways, and control towers. These entities need to communicate
 * and coordinate with each other to ensure safe and efficient air traffic
 * management. Here's how the Mediator pattern can be applied:
 * 
 * 
 * In this example, the Airplane entities communicate with each other through
 * the AirTrafficControlTower mediator. The tower receives orders from one
 * entity and forwards them to all other entities except the sender. Similarly,
 * position updates are notified to all other entities. This allows for
 * centralized coordination and communication between the entities without them
 * having direct knowledge of each other.
 * 
 * The Mediator design pattern helps decouple the entities in the air traffic
 * control system, making it easier to maintain and extend the system as new
 * entities are added or existing ones change their behavior.
 */