package com.host.builder;

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
/**
 * Builder Pattern solve Abstract Factor and Factory method problems
 * 
 * The Factory Method and Abstract Factory patterns focus on creating objects, while the Builder pattern focuses on constructing 
 * complex objects step by step. Here are some common issues that the Builder pattern addresses:
 * 1.Telescoping constructor anti-pattern: With Factory Method and Abstract Factory, when an object requires multiple constructor 
 * parameters, the number of constructor overloads can become overwhelming. This is known as the telescoping constructor anti-pattern. 
 * The Builder pattern solves this issue by providing a fluent interface that allows step-by-step construction of an object, setting 
 * only the desired parameters.
 * 
 * 2.Flexibility in object construction: Factory Method and Abstract Factory patterns provide a fixed way of object creation based on 
 * predefined methods. In contrast, the Builder pattern allows the construction process to be more flexible. It enables the client to 
 * customize the construction steps and selectively set the desired attributes or properties.
 * 
 * 3.Construction of complex objects: Builder pattern is particularly useful when constructing objects with many optional or 
 * conditional parameters. It allows the client to specify which parameters are required and which ones are optional, making 
 * the construction process more manageable.
 * 
 * 4.Readability and maintainability: The fluent interface of the Builder pattern provides clear and readable code, making 
 * it easier to understand and maintain. The step-by-step construction process improves the code's readability, especially 
 * when dealing with complex object creation logic.
 * 
 * 5.Separation of concerns: The Builder pattern separates the construction logic from the construction steps themselves. 
 * This separation allows for better organization and reduces code duplication, as the construction logic is encapsulated 
 * within the Builder class.
 * 
 * 6.It's important to note that the Factory Method, Abstract Factory, and Builder patterns serve different purposes and 
 * are applicable in different scenarios. While Factory Method and Abstract Factory focus on object creation, the Builder
 *  pattern concentrates on constructing complex objects with a more flexible and readable approach.
 */