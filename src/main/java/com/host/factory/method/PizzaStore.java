package com.host.factory.method;

/**
 * @author Ankit_Kumar
 *	Finally, we create a PizzaStore class that uses the PizzaFactory to create Pizza objects. 
 *	The PizzaStore class has a constructor that takes a PizzaFactory parameter and a method called orderPizza(String type) 
 *	that takes a String parameter representing the type of pizza to be ordered. The orderPizza() method uses the PizzaFactory to 
 *	create a new Pizza object based on the value of the type parameter and then calls the prepare(), bake(), cut(), and box() 
 *	methods on the new Pizza object.
 */
public class PizzaStore {
    private PizzaFactory pizzaFactory;
    
    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }
    
    public Pizza orderPizza(String type) {
        Pizza pizza = pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
/**
 * How to Break This Factory Desing Pattern
 * 
 * In the given Factory Design Pattern example in Java, we can break the pattern in the following ways:
 * 1. Adding a new type of pizza requires modifying the PizzaFactory class. 
 * This breaks the open-closed principle of SOLID design principles, which states that a class should be open for extension
 * but closed for modification. To avoid this, we can use a configuration file or database to store the pizza types and their 
 * corresponding classes.
 * 2. A malicious user could bypass the PizzaFactory class and create an instance of a concrete pizza class directly. 
 * This can be prevented by making the concrete pizza classes package-private, so that only the PizzaFactory class can access them.
 * 3. The Pizza class has abstract methods for prepare(), bake(), cut(), and box(), which means that all pizza types must implement 
 * these methods, even if some of them don't require them. This can be improved by using an interface instead of an abstract class, 
 * or by using the Adapter design pattern to provide default implementations for these methods.
 */
