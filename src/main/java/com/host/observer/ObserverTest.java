package com.host.observer;

/**
 * 
 * @author CA Ankit_Kumar
 * 
 *         The Observer design pattern in Java is used to establish a
 *         one-to-many relationship between objects.
 * 
 *         It allows multiple dependent objects (observers) to be notified and
 *         updated automatically when the state of a subject (observable) object
 *         changes.
 * 
 *         The Observer pattern promotes loose coupling and ensures that objects
 *         can communicate without having explicit knowledge of each other.
 *
 */
public class ObserverTest {
	/**
	 * 
	 * In this example, the WeatherStation acts as the subject (observable), while
	 * the TemperatureDisplay represents the observer. The WeatherStation maintains
	 * a list of registered observers and notifies them whenever the temperature
	 * changes. The observers, in turn, update their internal state and display the
	 * current temperature.
	 * 
	 * As you can see, both TemperatureDisplay instances are notified and updated
	 * when the temperature changes. The Observer pattern allows for easy
	 * extensibility, as you can add new observers without modifying the subject or
	 * existing observers.
	 */
	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		TemperatureDisplay dispaly1 = new TemperatureDisplay();
		TemperatureDisplay display2 = new TemperatureDisplay();

		weatherStation.registerObserver(dispaly1);
		weatherStation.registerObserver(display2);

		weatherStation.setTemperature(25);

		weatherStation.removeObserver(display2);

		weatherStation.setTemperature(30);

		WeatherStation weatherStation2 = new WeatherStation();

		TemperatureDisplay display3 = new TemperatureDisplay();
		TemperatureDisplay display4 = new TemperatureDisplay();

		weatherStation2.registerObserver(display3);
		weatherStation2.registerObserver(display4);

		Thread thread1 = new Thread(() -> weatherStation2.setTemperature(250));
		Thread thread2 = new Thread(() -> weatherStation2.setTemperature(300));

		thread1.start();
		thread2.start();

		StockMarket stockMarket = new StockMarket();

		StockDisplay display5 = new StockDisplay();
		StockDisplay display6 = new StockDisplay();

		stockMarket.registerObserver(display5);
		stockMarket.registerObserver(display6);

		stockMarket.setStockPrice(150.50);
		stockMarket.setStockPrice(160.75);
	}
}

/**
 * What problem can we solved by Observer pattern?
 * 
 * The Observer pattern is a behavioral design pattern that is used to establish
 * a one-to-many dependency between objects. It provides a way for multiple
 * observers (also known as subscribers or listeners) to be notified and updated
 * automatically when the state of a subject (also known as a publisher or
 * observable) changes. The Observer pattern can be used to solve various
 * problems, including:
 * 
 * 1. Event-driven systems: When you have a system where various components or
 * modules need to react to events or changes in state, the Observer pattern
 * provides a flexible solution. The observers can subscribe to specific events
 * or subjects and be notified whenever those events occur or the subjects'
 * state changes.
 * 
 * 2. Decoupling components: The Observer pattern helps to decouple the subject
 * from its observers. The subject doesn't need to have direct knowledge of its
 * observers, and the observers don't need to know about each other. This loose
 * coupling allows for easier maintenance, extensibility, and reusability of the
 * components.
 * 
 * 3. User interfaces: In graphical user interfaces (GUIs), the Observer pattern
 * is commonly used to implement the model-view-controller (MVC) architecture.
 * The model represents the data or state, and the views are the visual
 * representations of that data. The views register as observers to the model,
 * allowing them to update automatically when the model changes. This pattern
 * helps keep the user interface synchronized with the underlying data.
 * 
 * 4. Distributed systems and messaging: In distributed systems or messaging
 * systems, the Observer pattern can be used to propagate changes or messages
 * across multiple nodes or components. When a change occurs in one node, the
 * observers in other nodes can be notified and take appropriate actions.
 * 
 * 5. Logging and auditing: The Observer pattern can be useful for implementing
 * logging and auditing mechanisms. Observers can be registered to monitor
 * certain events or actions in a system, allowing them to log or audit those
 * events for tracking, debugging, or security purposes.
 * 
 * Overall, the Observer pattern provides a way to establish a dynamic and
 * loosely coupled relationship between objects, enabling efficient
 * communication and synchronization between components in various scenarios.
 * 
 */
