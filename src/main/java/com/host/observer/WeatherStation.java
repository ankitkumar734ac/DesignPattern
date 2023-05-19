package com.host.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
	private int temperature;
	private List<Observer> observers;

	public WeatherStation() {
		observers = new ArrayList<>();
	}

	public synchronized void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObservers();
	}

	@Override
	public synchronized  void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public synchronized void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public synchronized  void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(temperature);
		}
	}

}
