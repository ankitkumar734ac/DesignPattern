## Builder Design Pattern
The Builder design pattern in Java is a creational design pattern that provides a way to construct complex objects step by step. It allows you to create an object with various optional parameters while ensuring that the object is only constructed when it is fully configured.
<br/> <b>Note: There are many ways to implement a builder design pattern</b>
### 1. Inner Static Builder (Fluent Builder):
 An Inner Static Builder, also known as a Fluent Builder, is a design pattern used to create complex objects with a fluent and expressive syntax. This pattern is often used when you want to build an object with various configuration options and method chaining.
<br/> <b>Step</b>
 * Create a public static nested class called the "Builder" inside the class for which you want to build objects.
 * Add all the optional parameters as fields in the Builder class.
 * Provide setter methods in the Builder class to set the optional parameters. Each setter method should return the Builder object itself to enable method chaining.
 * Create a private constructor for the outer class to prevent direct instantiation.
 * Add a public build method in the Builder class that constructs and returns the desired object. Inside the build method, instantiate the outer class, passing the values from the Builder fields.
 * Optionally, you can add validation logic inside the build method to ensure that all required parameters are set correctly.
 * To create an object using the Builder, obtain an instance of the Builder class and chain the setter methods to set the desired parameters. Finally, call the build method to obtain the constructed object.

<br/><b>Example:</b>

```Java
public class Product {
	private String name;
	private String description;
	private double price;

	private Product(Builder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.price = builder.price;
	}

	public static class Builder {
		private String name;
		private String description;
		private double price;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * Builder is the return type of the method, which allows method chaining.
		 * @param description
		 * @return returns the current instance of the Builder object (this), allowing for method chaining.
		 */
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setPrice(double price) {
			this.price = price;
			return this;
		}

		public Product build() {
			// Optionally, you can add validation logic here
			return new Product(this);
		}
	}

	// Getters for Product fields

	

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
}
```
```java
public class BuilderTest {
	public static void main(String[] args) {
		// Usage:
		Product product = new Product.Builder()
		                        .setName("Example Product")
		                        .setDescription("This is an example product")
		                        .setPrice(19.99)
		                        .build();
		System.out.println(product);
		
	}

}
```


 <b>Method chaining:</b> is a programming technique where multiple method calls are chained together in a single line of code. Each method call is invoked on the return value of the previous method call, allowing for a concise and fluent syntax.
 <br/> 
 ### Pros and Cons of Fluent Builder
 <b>Pros:</b>
* <b>Encapsulation:</b> The builder is tightly coupled with the class it's building, so it has access to the class's private members, allowing it to directly set properties.
* <b>Simplified Usage:</b> You don't need to create a separate builder class or call a separate builder method, making the code more concise and readable.
* <b>Fluency:</b> It enables a fluent and intuitive syntax for setting properties, which can make the code more expressive.
* <b>Reduced Risk of Incomplete Objects:</b> Since the builder is part of the same class, it's easier to ensure that all mandatory properties are set during construction.
<br/>
<b>Cons:</b> 

* <b>Complexity:</b> Having the builder in the same class can increase the complexity of the class, especially if there are many properties to set. The class may become large and harder to maintain.
* <b>Violation of Single Responsibility Principle:</b> Combining the builder and the class can violate the Single Responsibility Principle, which states that a class should have only one reason to change. If the class has multiple responsibilities, it may become less maintainable.
* <b>Tight Coupling:</b> The builder is tightly coupled with the class, which can make it difficult to reuse the builder for other classes or change the class's structure without affecting the builder.
* <b>Limited Inheritance:</b> If you want to subclass the class you're building, the inner builder may not be as easily inherited, which can limit flexibility in some cases.

### 2. Separate Builder Class:

```java
public class Product {
    private String part1;
    private String part2;
    // Other properties

    // Constructor
    public Product(String part1, String part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    // Getters
    // Other methods
}
```
```java
public class ProductBuilder {
    private String part1;
    private String part2;
    // Other properties

    public ProductBuilder() {
        // Initialize with default values or leave them null
    }

    public ProductBuilder withPart1(String part1) {
        this.part1 = part1;
        return this;
    }

    public ProductBuilder withPart2(String part2) {
        this.part2 = part2;
        return this;
    }

    // Other setter methods for additional properties

    public Product build() {
        return new Product(part1, part2);
    }
}
```
```java
Product product = new ProductBuilder()
    .withPart1("Part 1 Value")
    .withPart2("Part 2 Value")
    .build();
```
### Using a separate builder class in the Builder Design Pattern comes with its own set of pros and cons:
<b>Pros:</b>
* <b>Single Responsibility Principle:</b> It adheres more closely to the Single Responsibility Principle, as the builder class is responsible for constructing the object, separate from the object it builds.
* <b>Better Separation of Concerns:</b> The separation of the building process from the main class improves the code's organization and maintainability.
* <b>Reusability:</b> You can reuse the same builder class for creating instances of different objects, promoting code reuse.
* <b>Cleaner Class Interface:</b> The main class can have a cleaner and less cluttered interface, focusing on its core functionality.
* <b>Easier Testing:</b> Testing the construction of objects becomes more straightforward as you can isolate the builder class for testing purposes.
<br/>
<b>Cons:</b>

* <b>Additional Code:</b> Using a separate builder class requires you to write additional code, which can make the codebase larger and potentially more complex.
* <b>Slightly More Verbose:</b> The usage of a separate builder involves creating a builder instance and calling methods on it to set properties, which can be slightly more verbose than using an inner builder.
* <b>Boilerplate Code:</b> You'll need to define the builder class, its methods, and possibly a lot of getter and setter methods if there are many properties, which can be considered boilerplate code.
* <b>Possible Tight Coupling:</b> Depending on the design, there could be tight coupling between the builder and the main class if they share many properties.

In summary, using a separate builder class provides better separation of concerns, adheres to design principles, and offers improved reusability.

### Lombok or Annotation Processors:
Some libraries like Lombok in Java offer annotations to generate builder methods automatically, reducing boilerplate code.
<b>Pros:</b> Reduces manual coding, simplifies usage, and follows DRY (Don't Repeat Yourself) principles.
<b>Cons:</b> Adds a dependency on the library, and you lose some level of control over the builder code.
```java
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String phoneNumber;
}
```
```java
public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .address("123 Main St")
                .phoneNumber("555-1234")
                .build();

        System.out.println(person);
    }
}
```

### Immutable Builder: 
???
### Generic Builder: 

### Step Builder: 


## Problem statement that can be solved by using builder pattern
The Builder Design Pattern is a creational design pattern that is primarily used to solve problems related to object creation and initialization. Some common problem statements that can be solved using the Builder pattern include:

1. **Creating Complex Objects**: When you need to create objects with a large number of optional or configurable attributes, and you want to provide a clean and flexible way to set these attributes without creating multiple constructors with numerous parameters.

2. **Immutability**: To create immutable objects, ensuring that once an object is constructed, its state cannot be changed, which is important for thread safety and predictability.

3. **Parameter Validation**: When you want to enforce validation and consistency checks on the parameters passed during object creation.

4. **Avoiding Telescoping Constructors**: To avoid the anti-pattern of having constructors with an increasing number of parameters (telescoping constructors) that make the code hard to read and maintain.

5. **Fluent and Expressive API**: When you want to provide a fluent and readable API for creating objects by chaining method calls, making the code more expressive and self-documenting.

6. **Configuration and Setup**: When you need to create and configure objects for complex systems, such as configuring database connections, network requests, or application settings.

7. **Managing Optional Parameters**: To manage optional parameters without the need to pass `null` or default values for parameters you don't want to set.

8. **Consistent Object Creation**: To ensure a consistent and standard way to construct objects across different parts of the codebase.

9. **Avoiding Constructors with Numerous Parameters**: To avoid having constructors with a long list of parameters, which can be error-prone and hard to use.

10. **Extension and Customization**: To provide a way for users to extend or customize the object creation process, adding new features or behaviors as needed.

11. **Building Complex Data Structures**: When you need to create complex data structures, like trees, graphs, or composite objects, where each part of the structure can be built incrementally.

12. **Database Query Building**: In the context of databases, you can use the Builder pattern to construct complex SQL queries or NoSQL queries with various conditions, filters, and clauses.

The Builder pattern addresses these issues by separating the construction of complex objects from their representation, providing a clear and structured way to create objects with multiple attributes and optional parameters. This results in more readable and maintainable code and allows for easy extension and customization.










