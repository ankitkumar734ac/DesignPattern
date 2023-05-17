package com.host.bridge;

//Refined Abstractions
public class Car extends Vehicle {
	public Car(Engine engine) {
		super(engine);
	}

	@Override
	public void start() {
		System.out.println("Starting Car");
		engine.startEngine();
	}

	@Override
	public void stop() {
		System.out.println("Stopping Car");
		engine.stopEngine();
	}
}
/**
 * Refined Abstractions:
 * The Car class is a subclass of Vehicle that represents a specific type of vehicle.
 * It takes an Engine object in its constructor via the superclass and implements the start() and stop() methods.
 * In the start() and stop() methods, it uses the engine object to start and stop the engine.
 */