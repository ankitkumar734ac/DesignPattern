package com.host.decorator;
/**
 * @author CA Ankit_Kumar
 * 
 * The Decorator design pattern is a structural design pattern that allows behavior to be
 *  added to an object dynamically. It provides a flexible alternative to subclassing 
 *  for extending the functionality of an object at runtime.
 *  
 *  In Java, the Decorator pattern typically involves creating a set of decorator classes 
 *  that wrap around the original object and provide additional functionality.
 *  The decorator classes implement the same interface as the original object, 
 *  allowing them to be used interchangeably. The decorators add their own behavior
 *  before or after delegating the call to the wrapped object.
 *
 */
public class DecoratorTest {
	public static void main(String[] args) {
		// Create the base pizza
        Pizza pizza = new PlainPizza();

        // Add decorators to the pizza
        pizza = new CheeseDecorator(pizza);
        pizza = new MeatDecorator(pizza);

        // Call methods on the decorated pizza
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
	}
}
/*
 * In this example, we have a Pizza interface representing the component or the original object.
 * The PlainPizza class is the concrete implementation of the component.
 * 
 * The PizzaDecorator class is the base decorator class that implements the Pizza interface. 
 * It contains a reference to the wrapped Pizza object. The concrete decorators (CheeseDecorator and MeatDecorator) extend 
 * the PizzaDecorator class and add specific behavior by modifying the description and cost.
 * 
 * In the main method, we create a base pizza object and then wrap it with different decorators to add extra cheese and meat. 
 * Finally, we call the methods on the decorated pizza object to demonstrate the added behavior.
 * 
 * As you can see, the decorators add the desired behavior (extra cheese and meat) to the original plain pizza dynamically without modifying the original object's class.
 */
