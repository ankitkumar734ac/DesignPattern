package com.host.observer;

//Concrete Observer
public class TemperatureDisplay implements Observer {

	private double temperature;

	@Override
	public void update(double temperature) {
		this.temperature = temperature;
		display();
	}

	public void display() {
		System.out.println("Current Temperature: " + temperature + " degrees");
	}
}
