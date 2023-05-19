package com.host.mediatar;

import java.util.ArrayList;
import java.util.List;

public class AirTrafficControlTower implements AirTrafficControl {
	private List<Entity> entities;

	public AirTrafficControlTower() {
		entities = new ArrayList<>();
	}

	@Override
	public void sendOrder(Entity entity, String order) {
		for (Entity e : entities) {
			if (e != entity) {
				e.receiveOrder(order);
			}
		}
	}

	@Override
	public void notifyOfPosition(Entity entity, double x, double y) {
		for (Entity e : entities) {
			if (e != entity) {
				e.receivePositionUpdate(entity, x, y);
			}
		}
	}

	@Override
	public void registerEntity(Airplane airplane) {
		entities.add(airplane);
	}

}
/*
 * The concrete mediator class, let's call it AirTrafficControlTower, implements
 * the AirTrafficControl interface and manages the communication between the
 * entities.
 */
