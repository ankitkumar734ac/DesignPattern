package com.host.mediatar;

public class Airplane implements Entity {
	private AirTrafficControl controlTower;

	public Airplane(AirTrafficControl controlTower) {
		this.controlTower = controlTower;
		controlTower.registerEntity(this);
	}

	@Override
	public void sendOrder(String order) {
		controlTower.sendOrder(this, order);
	}

	@Override
	public void receiveOrder(String order) {
		System.out.println("Airplane received order: " + order);
	}

	@Override
	public void sendPositionUpdate(double x, double y) {
		controlTower.notifyOfPosition(this, x, y);
	}

	@Override
	public void receivePositionUpdate(Entity entity, double x, double y) {
		System.out.println("Airplane received position update from " + entity + ": (" + x + ", " + y + ")");
	}
}
/*
 * The concrete entity classes, like Airplane or Runway, implement the Entity
 * interface and use the mediator to communicate with other entities.
 */
