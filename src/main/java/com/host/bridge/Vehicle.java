package com.host.bridge;

//Abstraction
public abstract class Vehicle {
	protected Engine engine;

	protected Vehicle(Engine engine) {
		this.engine = engine;
	}

	public abstract void start();

	public abstract void stop();
}
/**
 * Abstraction:
 * The Vehicle class is an abstract class that represents a generic vehicle.
 * It has a reference to an Engine object and provides common methods like start() and stop().
 */
