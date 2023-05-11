package com.host.factory.method;

public class FactoryMethodTest {
	/**
	 * The factory design pattern is a creational design pattern that provides a way to create objects without specifying their 
	 * concrete classes. It defines an interface or abstract class for creating objects and allows the subclasses to decide which 
	 * class to instantiate. This pattern promotes loose coupling by eliminating the need for clients to know the concrete classes 
	 * of objects that they create.
	 * 
	 * The factory design pattern works by providing a factory method that creates objects based on certain parameters. 
	 * Clients call this factory method to create objects instead of creating objects directly. The factory method decides 
	 * which class to instantiate based on the provided parameters.
	 * 
	 * One of the advantages of the factory design pattern is that it allows for easy extensibility. New classes can be added 
	 * to the system without affecting existing code. It also promotes code reuse by centralizing object creation logic and 
	 * allows for better encapsulation of object creation.
	 * 
	 * Overall, the factory design pattern is a useful pattern for creating objects in a flexible and extensible manner, 
	 * promoting loose coupling and easy maintenance of code."
	 */
	
	
	public static void main(String[] args) {
		PizzaFactory pizzaFactory = new PizzaFactory();
	    PizzaStore pizzaStore = new PizzaStore(pizzaFactory);
	    
	    Pizza cheesePizza = pizzaStore.orderPizza("cheese");
	    System.out.println("Ordered a " + cheesePizza.getClass().getSimpleName() + "\n");
	    
	    Pizza pepperoniPizza = pizzaStore.orderPizza("pepperoni");
	    System.out.println("Ordered a " + pepperoniPizza.getClass().getSimpleName() + "\n");
	    
	    Pizza veggiePizza = pizzaStore.orderPizza("veggie");
	    System.out.println("Ordered a " + veggiePizza.getClass().getSimpleName() + "\n");
	}
	/**
	 * Sure! Here are some specific requirements or design goals that may influence your decision to create Pizza as an abstract class or an interface in the Factory Method Design Pattern:
	 * 1.If you want to provide a default implementation of the common behavior for all pizzas, such as the prepare(), bake(), cut(), and box() methods, then you should create Pizza as an abstract class.
	 * 2.If you want to enforce a specific hierarchy of classes, where each concrete Pizza class must extend the Pizza class, then you should create Pizza as an abstract class.
	 * 3.If you want to allow multiple inheritance of behavior, where a concrete Pizza class can inherit from multiple classes, then you should create Pizza as an interface.
	 * 4.If you want to provide a contract for behavior without specifying any implementation details, then you should create Pizza as an interface.
	 * 5.If you want to ensure that all methods of Pizza are implemented by concrete Pizza classes, then you should create Pizza as an interface.
	 * 6.If you want to allow for future changes to the hierarchy of classes, such as adding new behaviors or creating new types of pizzas, then you should create Pizza as an interface.
	 * 	Ultimately, the decision to create Pizza as an abstract class or an interface depends on the specific requirements and design goals of your program. Both options have their advantages and disadvantages, 
	 * 	and the best choice depends on the specific needs of your program.
	 */
	
	/**
	 * Static Factory vs Factory Method
	 * 
	 * Static Factory Method is a variation of the Factory Method Design Pattern. 
	 * In this pattern, a single static method is used to create and return objects instead of creating a separate Factory class.
	 * In the Static Factory Method pattern, a class defines a static method that creates and returns an object of its own 
	 * class or another class. This method is usually named getInstance() or valueOf(). The method takes in parameters that 
	 * determine the type or state of the object being created.
	 * 
	 * The main difference between the Static Factory Method and the Factory Method patterns is that in the Factory Method pattern, 
	 * a separate Factory class is used to create objects, while in the Static Factory Method pattern, the creation of objects is 
	 * encapsulated within a single static method of the object's class.
	 * 
	 */
}
