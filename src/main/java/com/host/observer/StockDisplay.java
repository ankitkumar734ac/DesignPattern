package com.host.observer;

//Concrete Observer
public class StockDisplay implements Observer {
	private double stockPrice;

	@Override
	public void update(double stockPrice) {
		this.stockPrice = stockPrice;
		display();
	}

	public void display() {
		System.out.println("Current Stock Price: $" + stockPrice);
	}
}
/*
 * In this example, we have a StockMarket class acting as the subject
 * (observable) and a StockDisplay class acting as the observer. Here's how it
 * addresses the concerns:
 * 
 * 1. Thread Safety: Since there is no shared mutable state or concurrent access
 * in this example, explicit synchronization is not required. However, if you
 * have concurrent access to shared state within the subject or observer, you
 * can apply appropriate synchronization mechanisms to ensure thread safety.
 * 
 * 2. Inconsistent State: The StockMarket class simply updates the stock price
 * and notifies the observers. There is no inconsistency concern in this
 * specific example.
 * 
 * 3. Uncontrolled Observers: In the registerObserver() method, we check if the
 * observer is not already present in the list before adding it. This prevents
 * duplicate entries and ensures that observers are not registered multiple
 * times.
 * 
 * 4. Tight Coupling: The observers (StockDisplay) depend on the Observer
 * interface, ensuring loose coupling between the subject and observers.
 * 
 * 5. Performance and Efficiency: In this example, there is no explicit
 * optimization implemented. However, the StockMarket class could include
 * additional logic to track whether the stock price has changed before
 * triggering a notification to avoid unnecessary updates and notifications.
 * 
 * The observers (StockDisplay) receive and display the stock price updates
 * correctly.
 * 
 * This example provides a simplified illustration of the Observer pattern and
 * demonstrates a design that avoids the mentioned concerns, such as
 * inconsistent state, uncontrolled observers, tight coupling, and provides
 * flexibility for optimizations if needed.
 */