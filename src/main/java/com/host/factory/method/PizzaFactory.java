package com.host.factory.method;


/**
 * @author Ankit_Kumar
 *	Next, we create a PizzaFactory class that is responsible for creating instances of the concrete Pizza classes based on a parameter. 
 *	The PizzaFactory class provides a single method called createPizza(String type) that takes a String parameter representing the 
 *	type of pizza to be created. The createPizza() method checks the value of the type parameter and returns an instance of the 
 *	appropriate concrete Pizza class.
 *
 *	WHY
 *	Factory Method Design Pattern lets you create objects dynamically at runtime, based on certain conditions or parameters. 
 *	This makes your code more flexible and maintainable, by separating the object creation process from the rest of your code.
 */
public class PizzaFactory {
	/**
	 * 
	 * So, the Factory Method Design Pattern allows us to create objects without specifying the exact class of object that will be 
	 * created. Instead, the PizzaFactory class determines the class of object to be created based on a parameter. 
	 * This makes our code more flexible and easier to maintain, as we can add new types of pizzas simply by creating a new concrete 
	 * Pizza class and updating the createPizza() method of the PizzaFactory class.
	 */
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza();
        } else if (type.equals("veggie")) {
            return new VeggiePizza();
        } else {
            throw new IllegalArgumentException("Invalid pizza type");
        }
    }
    /**
     * Here are some pros and cons of using the Factory Method design pattern
     * 
     * Pros:
     * 1.Provides a flexible and extensible way of creating objects without tightly coupling the client code to the concrete classes
     * 2.Allows for easy addition of new types of products or classes without modifying the existing client code.
     * 3.Encapsulates the object creation logic in a single place, making it easier to maintain and modify.
     * .Provides a clear separation of concerns between the client code and the product creation code.
     * 
     * Cons:
     * 1.Can result in a larger codebase due to the creation of multiple classes and interfaces.
     * 2.Can lead to increased complexity and reduced performance due to the use of polymorphism and dynamic binding
     * 3.Requires the creation of a separate factory class or method for each type of product, which can result in code duplication if the product creation logic is similar.
     * 4.May not be necessary for simple projects or applications that do not require complex object creation logic.
     *
     *	Overall, the Factory Method design pattern is a useful tool for creating flexible and extensible object creation logic in larger and more complex projects. However, it may not be necessary or appropriate for smaller or simpler projects.
     */
    
    /**
     * Break
     * Yes, you're correct that anyone can create a subclass object directly without using the PizzaFactory. 
     * This is because the Pizza class and its subclasses are all public, which means that they can be accessed and 
     * instantiated from anywhere in the code.
     * To restrict the creation of Pizza objects to the PizzaFactory only, you can use access modifiers such as package-
     * private or protected for the Pizza class and its subclasses. This prevents other classes outside of the package or subclass 
     * hierarchy from directly instantiating Pizza objects.
     */
}
