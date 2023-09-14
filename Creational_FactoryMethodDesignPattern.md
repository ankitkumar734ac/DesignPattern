## Factory Method Design Pattern
The factory design pattern is a creational design pattern that provides a way to create objects without specifying their concrete classes. It defines an interface or abstract class for creating objects and allows the subclasses to decide which class to instantiate. This pattern promotes loose coupling by eliminating the need for clients to know the concrete classes of objects that they create.

The factory design pattern works by providing a factory method that creates objects based on certain parameters. Clients call this factory method to create objects instead of creating objects directly. The factory method decides which class to instantiate based on the provided parameters.

One of the advantages of the factory design pattern is that it allows for easy extensibility. New classes can be added to the system without affecting existing code. It also promotes code reuse by centralizing object creation logic and allows for better encapsulation of object creation.

Overall, the factory design pattern is a useful pattern for creating objects in a flexible and extensible manner, promoting loose coupling and easy maintenance of code."





```java
public abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();
}
```
```java
public class PepperoniPizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing pepperoni pizza...");
    }
    public void bake() {
        System.out.println("Baking pepperoni pizza...");
    }
    public void cut() {
        System.out.println("Cutting pepperoni pizza...");
    }
    public void box() {
        System.out.println("Boxing pepperoni pizza...");
    }
}
```
```java
public class CheesePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing cheese pizza...");
    }
    public void bake() {
        System.out.println("Baking cheese pizza...");
    }
    public void cut() {
        System.out.println("Cutting cheese pizza...");
    }
    public void box() {
        System.out.println("Boxing cheese pizza...");
    }
}
```
```java
public class VeggiePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing veggie pizza...");
    }
    public void bake() {
        System.out.println("Baking veggie pizza...");
    }
    public void cut() {
        System.out.println("Cutting veggie pizza...");
    }
    public void box() {
        System.out.println("Boxing veggie pizza...");
    }
}
```
```java
public class PizzaFactory {
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
}
```
Finally, we create a PizzaStore class that uses the PizzaFactory to create Pizza objects.The PizzaStore class has a constructor that takes a PizzaFactory parameter and a method called orderPizza(String type) that takes a String parameter representing the type of pizza to be ordered. The orderPizza() method uses the PizzaFactory to create a new Pizza object based on the value of the type parameter and then calls the prepare(), bake(), cut(), and box() methods on the new Pizza object.
```java
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
```

```java
public class FactoryMethodTest {
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
}
```
### Specific requirements or design goals
Sure! Here are some specific requirements or design goals that may influence your decision to create Pizza as an abstract class or an interface in the Factory Method Design Pattern:
	1.If you want to provide a default implementation of the common behavior for all pizzas, such as the prepare(), bake(), cut(), and box() methods, then you should create Pizza as an abstract class.
	2.If you want to enforce a specific hierarchy of classes, where each concrete Pizza class must extend the Pizza class, then you should create Pizza as an abstract class.
	3.If you want to allow multiple inheritance of behavior, where a concrete Pizza class can inherit from multiple classes, then you should create Pizza as an interface.
	4.If you want to provide a contract for behavior without specifying any implementation details, then you should create Pizza as an interface.
	5.If you want to ensure that all methods of Pizza are implemented by concrete Pizza classes, then you should create Pizza as an interface.
	6.If you want to allow for future changes to the hierarchy of classes, such as adding new behaviors or creating new types of pizzas, then you should create Pizza as an interface.
 Ultimately, the decision to create Pizza as an abstract class or an interface depends on the specific requirements and design goals of your program. Both options have their advantages and disadvantages, and the best choice depends on the specific needs of your program.

### Here are some pros and cons of using the Factory Method design pattern
     `Pros:`
     1.Provides a flexible and extensible way of creating objects without tightly coupling the client code to the concrete classes
     2.Allows for easy addition of new types of products or classes without modifying the existing client code.
     3.Encapsulates the object creation logic in a single place, making it easier to maintain and modify.
     4.Provides a clear separation of concerns between the client code and the product creation code.
     
     `Cons:`
     1.Can result in a larger codebase due to the creation of multiple classes and interfaces.
     2.Can lead to increased complexity and reduced performance due to the use of polymorphism and dynamic binding
     3.Requires the creation of a separate factory class or method for each type of product, which can result in code duplication if the product creation logic is similar.
     4.May not be necessary for simple projects or applications that do not require complex object creation logic.
     
     Overall, the Factory Method design pattern is a useful tool for creating flexible and extensible object creation logic in larger and more complex projects. However, it may not be necessary or appropriate for smaller or simpler projects.

### How to break this pattern
Yes, you're correct that anyone can create a subclass object directly without using the PizzaFactory. This is because the Pizza class and its subclasses are all public, which means that they can be accessed and instantiated from anywhere in the code. To restrict the creation of Pizza objects to the PizzaFactory only, you can use access modifiers such as package- private or protected for the Pizza class and its subclasses. This prevents other classes outside of the package or subclass hierarchy from directly instantiating Pizza objects.
### How to Break This Factory Desing Pattern
In the given Factory Design Pattern example in Java, we can break the pattern in the following ways:
  1. Adding a new type of pizza requires modifying the PizzaFactory class. This breaks the open-closed principle of SOLID design principles, which states that a class should be open for extension but closed for modification. To avoid this, we can use a configuration file or database to store the pizza types and their corresponding classes.
  2. A malicious user could bypass the PizzaFactory class and create an instance of a concrete pizza class directly.  This can be prevented by making the concrete pizza classes package-private, so that only the PizzaFactory class can access them.
  3. The Pizza class has abstract methods for prepare(), bake(), cut(), and box(), which means that all pizza types must implement  these methods, even if some of them don't require them. This can be improved by using an interface instead of an abstract class, or by using the Adapter design pattern to provide default implementations for these methods.


### Static Factory Design Pattern
```java
public abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    public static Pizza createPizza(String type) {
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
}

public class CheesePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing cheese pizza...");
    }
    public void bake() {
        System.out.println("Baking cheese pizza...");
    }
    public void cut() {
        System.out.println("Cutting cheese pizza...");
    }
    public void box() {
        System.out.println("Boxing cheese pizza...");
    }
}

public class PepperoniPizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing pepperoni pizza...");
    }
    public void bake() {
        System.out.println("Baking pepperoni pizza...");
    }
    public void cut() {
        System.out.println("Cutting pepperoni pizza...");
    }
    public void box() {
        System.out.println("Boxing pepperoni pizza...");
    }
}

public class VeggiePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing veggie pizza...");
    }
    public void bake() {
        System.out.println("Baking veggie pizza...");
    }
    public void cut() {
        System.out.println("Cutting veggie pizza...");
    }
    public void box() {
        System.out.println("Boxing veggie pizza...");
    }
}

public class PizzaStore {
    public static void main(String[] args) {
        Pizza cheesePizza = Pizza.createPizza("cheese");
        cheesePizza.prepare();
        cheesePizza.bake();
        cheesePizza.cut();
        cheesePizza.box();
        System.out.println("Ordered a " + cheesePizza.getClass().getSimpleName() + "\n");

        Pizza pepperoniPizza = Pizza.createPizza("pepperoni");
        pepperoniPizza.prepare();
        pepperoniPizza.bake();
        pepperoniPizza.cut();
        pepperoniPizza.box();
        System.out.println("Ordered a " + pepperoniPizza.getClass().getSimpleName() + "\n");

        Pizza veggiePizza = Pizza.createPizza("veggie");
        veggiePizza.prepare();
        veggiePizza.bake();
        veggiePizza.cut();
        veggiePizza.box();
        System.out.println("Ordered a " + veggiePizza.getClass().getSimpleName() + "\n");
    }
}
```


### Static Factory vs Factory Method
Static Factory Method is a variation of the Factory Method Design Pattern. 
In this pattern, a single static method is used to create and return objects instead of creating a separate Factory class. In the Static Factory Method pattern, a class defines a static method that creates and returns an object of its own class or another class. This method is usually named getInstance() or valueOf(). The method takes in parameters that determine the type or state of the object being created. 

The main difference between the Static Factory Method and the Factory Method patterns is that in the Factory Method pattern, a separate Factory class is used to create objects, while in the Static Factory Method pattern, the creation of objects is encapsulated within a single static method of the object's class.

`Example 3`

```java
// Transport interface
interface Transport {
    void deliver();
}
```
```java
// Truck class implementing Transport interface
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by truck.");
        // Add truck-specific delivery logic here
    }
}
```
```java
// Sea class implementing Transport interface
class Sea implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea.");
        // Add sea-specific delivery logic here
    }
}
```
```java
// TransportFactory interface
interface TransportFactory {
    Transport createTransport();
}

```
```java
// TruckFactory implementing TransportFactory
class TruckFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

// SeaFactory implementing TransportFactory
class SeaFactory implements TransportFactory {
    @Override
    public Transport createTransport() {
        return new Sea();
    }
}

```
```java
public class LogisticsManagementApp {
    public static void main(String[] args) {
        // Create a TruckFactory to handle truck transportation
        TransportFactory truckFactory = new TruckFactory();
        Transport truck = truckFactory.createTransport();
        truck.deliver();

        // Create a SeaFactory to handle sea transportation
        TransportFactory seaFactory = new SeaFactory();
        Transport sea = seaFactory.createTransport();
        sea.deliver();
    }
}

```
With the Factory Design Pattern, you can easily add new transportation types (e.g., air, rail) by creating corresponding classes and factories without modifying existing code. This makes the application more flexible and maintainable as it continues to grow and incorporate new features.





