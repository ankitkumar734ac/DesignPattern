### Abstract Design Pattern
The Abstract Factory design pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It allows you to encapsulate the object creation logic and provide a common interface for creating objects of different types.In Java, you can implement the Abstract Factory pattern using interfaces and classes.

### When to use the Abstract Factory pattern in a project:
1. When you need to create families of related or dependent objects.
2. When you want to provide a client with a way to create objects without specifying their concrete classes.
3. When you need to ensure that the created objects are compatible with each other.
4. When you anticipate the need to introduce new families of products in the future.

`Example`
Let's consider a car manufacturing company that produces different types of cars, such as Sedan, SUV, and Sports Car. Each car type requires the creation of various components, including the engine, tire, and body. The Abstract Factory pattern can be used to create different families of car components based on the type of car being manufactured.
 
```Java
//Abstract Product: Engine
public interface Engine {
 void design();
}
//Abstract product interfaces (Engine and Tire) define the common operations for the products.
```
```java
//Concrete Product: Sedan Engine
public class SedanEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing Sedan Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Concrete Product: Sports Car Engine
public class SportsCarEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing Sports Car Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Concrete Product: SUV Engine
public class SuvEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing SUV Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Abstract Product: Tire
public interface Tire {
 void manufacture();
}
//Abstract product interfaces (Engine and Tire) define the common operations for the products.
```
```java
//Concrete Product: Sports Car Tire
public class SportsCarTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing Sports Car Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Concrete Product: SUV Tire
public class SuvTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing SUV Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Concrete Product: Sedan Tire
public class SedanTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing Sedan Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Abstract Factory
public interface CarFactory {
	Engine createEngine();

	Tire createTire();
}
//The abstract factory interface (CarFactory) declares factory methods to create the abstract product objects.
```
```java
//Concrete Factory: Sedan Car Factory
public class SedanCarFactory implements CarFactory {
 @Override
 public Engine createEngine() {
     return new SedanEngine();
 }

 @Override
 public Tire createTire() {
     return new SedanTire();
 }
}
//Concrete factory classes (SedanCarFactory, SuvCarFactory,SportCarFactory) implement the abstract factory interface and provide the logic to create the specific families of products.
```
```java
//Concrete Product: Sports Car Engine
public class SportsCarEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing Sports Car Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
```
```java
//Concrete Factory: SUV Car Factory
public class SuvCarFactory implements CarFactory {
 @Override
 public Engine createEngine() {
     return new SuvEngine();
 }

 @Override
 public Tire createTire() {
     return new SuvTire();
 }
}
//Concrete factory classes (SedanCarFactory, SuvCarFactory,SportCarFactory) implement the abstract factory interface and provide the logic to create the specific families of products.
```
```java
//Client
//The client code (CarManufacturer) depends on the abstract factory interface (CarFactory) to create the products, and it interacts with the products through their abstract interfaces (Engine and Tire).
public class CarManufacturer {
	private CarFactory carFactory;

	public CarManufacturer(CarFactory factory) {
		this.carFactory = factory;
	}

	public void manufactureCar() {
		Engine engine = carFactory.createEngine();
		Tire tire = carFactory.createTire();

		System.out.println("Manufacturing a car:");
		engine.design();
		tire.manufacture();
		System.out.println("Car manufactured.\n");
	}

}
```
```java
public class AbstractFactoryMethodTest {
	public static void main(String[] args) {

		CarManufacturer sedanManufacturer = new CarManufacturer(new SedanCarFactory());
		sedanManufacturer.manufactureCar();

		CarManufacturer suvManufacturer = new CarManufacturer(new SuvCarFactory());
		suvManufacturer.manufactureCar();

		CarManufacturer sportsCarManufacturer = new CarManufacturer(new SportsCarFactory());
		sportsCarManufacturer.manufactureCar();

	}
}
```
### Abstract Factory Design Pattern Pros and Cons
 `Pros:`
1. Encapsulation: The Abstract Factory pattern encapsulates the creation of objects within the factory, providing a clear separation between object creation and object usage. Clients only need to interact with the abstract factory and its products, without being concerned about the specific implementations.
2. Flexibility: By using the Abstract Factory pattern, you can easily swap or introduce new families of products by creating a new concrete factory that adheres to the abstract factory interface. This makes the system more flexible and adaptable to changes.
3. Adherence to the Open-Closed Principle: The Abstract Factory pattern promotes the Open-Closed Principle, which states that the system should be open for extension but closed for modification. It allows you to introduce new types of products without modifying existing client code.
4. Consistency: The Abstract Factory pattern ensures that the created objects are compatible with each other. The concrete factory guarantees that the created products belong to the same family, ensuring consistency in the system.
 `Cons:`
1. Complexity: The Abstract Factory pattern can introduce additional complexity to the system, especially when dealing with a large number of products and their variations. It requires defining multiple interfaces, concrete implementations, and their relationships.
2. Increased number of classes: Implementing the Abstract Factory pattern often leads to an increased number of classes in the system, as each product family requires its own set of interfaces, concrete products, and factories. This can make the codebase larger and more complex.
   

### Diff b/w Factory Method and Abstract Factory method
`Factory Method Pattern:`
1. Purpose: The Factory Method pattern is used to create objects of a single product type. It provides an interface for creating objects, but the specific subclass that creates the object is determined at runtime.
2. Structure: In the Factory Method pattern, there is an abstract creator class that declares the factory method. Concrete subclasses of the creator class implement the factory method to create specific product objects.
3. Single Product Type: The Factory Method pattern focuses on creating a single product type, and the factory method returns instances of that specific product type.
4. Subclass Responsibility: The responsibility of creating the product objects is delegated to the concrete subclasses,which implement the factory method.
5. Extension: The Factory Method pattern is primarily used to support extension and allows the addition of new product types by creating new concrete creator subclasses.
`Abstract Factory Pattern:`
1. Purpose: The Abstract Factory pattern is used to create families of related or dependent objects. It provides an interface for creating multiple types of products, where each product type belongs to a specific family.
2. Structure: In the Abstract Factory pattern, there is an abstract factory interface that declares factory methods for creating the products. Concrete factory classes implement the abstract factory interface to create specific families of related products.
3. Multiple Product Types: The Abstract Factory pattern focuses on creating families of related products, where each family can consist of multiple product types. The factory methods in the abstract factory interface return instances of different product types.
4. Encapsulation: The responsibility of creating the product objects is encapsulated within the concrete factory classes.The client code interacts with the abstract factory and its products without being aware of the specific concrete implementations.
5. Variation Across Families: The Abstract Factory pattern is used when you anticipate the need for different families of related products, with variations in their implementations. It ensures that the created objects within a family are compatible with each other.
`In summary, `
The Factory Method pattern is used to create a single product type, while the Abstract Factory pattern is used to create families of related products. The Factory Method pattern focuses on extensibility by allowing the addition of new product types, while the Abstract Factory pattern focuses on providing families of compatible products with variations across families.

```java
// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1: Windows Factory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2: macOS Factory
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Abstract Product: Button
interface Button {
    void render();
}

// Concrete Product 1: Windows Button
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button");
    }
}

// Concrete Product 2: macOS Button
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a macOS button");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void render();
}

// Concrete Product 1: Windows Checkbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox");
    }
}

// Concrete Product 2: macOS Checkbox
class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a macOS checkbox");
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Determine the operating system
        String os = System.getProperty("os.name").toLowerCase();

        // Create the appropriate factory based on the operating system
        GUIFactory factory;
        if (os.contains("win")) {
            factory = new WindowsFactory();
        } else if (os.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            throw new RuntimeException("Unsupported operating system.");
        }

        // Use the factory to create GUI components
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Render the components
        button.render();
        checkbox.render();
    }
}
```
In this example, the Abstract Factory pattern is used to create GUI components (Button and Checkbox) for different operating systems (Windows and macOS). The GUIFactory interface represents the abstract factory, and its concrete implementations (WindowsFactory and MacOSFactory) create specific implementations of the GUI components.

The Button and Checkbox interfaces represent the abstract products, and their concrete implementations (WindowsButton, MacOSButton, WindowsCheckbox, MacOSCheckbox) represent the concrete products for each operating system.

The client code determines the operating system, creates the appropriate factory based on it, and uses the factory to create the GUI components. The components are then rendered, demonstrating the usage of the abstract factory and the concrete products.

This example showcases how the Abstract Factory pattern allows for the creation of families of related objects (GUI components) without the client code being aware of their specific implementations. It enables the client to work with different implementations based on the operating system without tightly coupling the code to a particular implementation.



## Note
In summary, the Factory Design Pattern is suitable when you have a single factory producing a few product variants, while the Abstract Factory Design Pattern is more appropriate when you need multiple factories producing entire families of related objects, supporting a more flexible and extensible design.

`Example 3`
Create the abstract product interfaces for Chair, Sofa, and CoffeeTable:
```java
// Abstract Product: Chair
interface Chair {
    void sit();
}

// Abstract Product: Sofa
interface Sofa {
    void sit();
}

// Abstract Product: CoffeeTable
interface CoffeeTable {
    void placeCoffee();
}
```
Create concrete product implementations for each product family:
```java
// Concrete Product: VictorianChair
class VictorianChair implements Chair {
    @Override
    public void sit() {
        System.out.println("You are sitting on a Victorian chair.");
    }
}

// Concrete Product: VictorianSofa
class VictorianSofa implements Sofa {
    @Override
    public void sit() {
        System.out.println("You are sitting on a Victorian sofa.");
    }
}

// Concrete Product: VictorianCoffeeTable
class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public void placeCoffee() {
        System.out.println("You placed a coffee cup on a Victorian coffee table.");
    }
}

// Concrete Product: ModernChair
class ModernChair implements Chair {
    @Override
    public void sit() {
        System.out.println("You are sitting on a Modern chair.");
    }
}

// Concrete Product: ModernSofa
class ModernSofa implements Sofa {
    @Override
    public void sit() {
        System.out.println("You are sitting on a Modern sofa.");
    }
}

// Concrete Product: ModernCoffeeTable
class ModernCoffeeTable implements CoffeeTable {
    @Override
    public void placeCoffee() {
        System.out.println("You placed a coffee cup on a Modern coffee table.");
    }
}
```
Create the abstract factory interface for creating furniture products:
```java
// Abstract Factory: FurnitureFactory
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}
```
Create concrete factory implementations for each furniture style:
```java
// Concrete Factory: VictorianFurnitureFactory
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

// Concrete Factory: ModernFurnitureFactory
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}
```
Create the FurnitureShop class that will use the abstract factory to create furniture products:
```java
// Client: FurnitureShop
public class FurnitureShop {
    private FurnitureFactory furnitureFactory;

    public FurnitureShop(FurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public void orderFurniture() {
        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();
        CoffeeTable coffeeTable = furnitureFactory.createCoffeeTable();

        chair.sit();
        sofa.sit();
        coffeeTable.placeCoffee();
    }
}
```
Finally, create the main class to run the simulation:
```java
public class Main {
    public static void main(String[] args) {
        // Create a Victorian style furniture shop
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureShop victorianShop = new FurnitureShop(victorianFactory);
        System.out.println("Ordering furniture in Victorian style:");
        victorianShop.orderFurniture();

        System.out.println();

        // Create a Modern style furniture shop
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureShop modernShop = new FurnitureShop(modernFactory);
        System.out.println("Ordering furniture in Modern style:");
        modernShop.orderFurniture();
    }
}
```


