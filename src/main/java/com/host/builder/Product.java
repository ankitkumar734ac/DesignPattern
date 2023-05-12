package com.host.builder;

/**
 * @author Ankit_Kumar
 *
 *	The Builder design pattern in Java is a creational design pattern that provides a way to construct complex objects step by step. 
 *	It allows you to create an object with various optional parameters, while ensuring that the object is only constructed when 
 *	it is fully configured.
 *
 *To implement the Builder pattern in Java, you can follow these steps:
 * 1. Create a public static nested class called the "Builder" inside the class for which you want to build objects.
 * 2.Add all the optional parameters as fields in the Builder class.
 * 3.Provide setter methods in the Builder class to set the optional parameters.
 *  Each setter method should return the Builder object itself to enable method chaining.
 * 4.Create a private constructor for the outer class to prevent direct instantiation.
 * 5.Add a public build method in the Builder class that constructs and returns the desired object.
 *  Inside the build method, instantiate the outer class, passing the values from the Builder fields.
 * 6.Optionally, you can add validation logic inside the build method to ensure that all required parameters are set correctly.
 * 7.To create an object using the Builder, obtain an instance of the Builder class and chain the setter methods 
 * to set the desired parameters. Finally, call the build method to obtain the constructed object.
 */
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
/**
 * Method chaining: is a programming technique where multiple method calls are chained together in a single line of code.
 * Each method call is invoked on the return value of the previous method call, allowing for a concise and fluent syntax.
*/

/**
 * The Builder design pattern has several advantages and some limitations. 
 * Here are the pros and cons of using the Builder design pattern:P
 * Pros:
 * 1.Provides a readable and fluent API for creating complex objects step by step.
 * 2.Allows the creation of objects with different configurations using the same construction process.
 * 3.Enhances code clarity and maintainability by separating the construction logic from the object's class.
 * 4.Provides flexibility to add new construction steps or modify the existing ones without impacting client code.
 * 5.Supports immutability by ensuring that the constructed object is in a consistent state.
 * 
 * Cons:
 * 1.Increases code complexity by requiring the creation of additional classes/interfaces for the builder and its steps.
 * 2.Requires more code compared to other creation patterns, which can be a drawback for simpler object creation scenarios.
 * 3.May not be suitable for objects with a small number of properties or when the object creation process is straightforward.
 * 4.Incur some performance overhead due to the involvement of multiple objects and method calls.
 * 
 * You should consider using the Builder pattern in your project when:
 * 1.You need to create objects that involve multiple steps or have complex construction logic.
 * 2.The object you want to create has a large number of optional parameters or configurations.
 * 3.You want to provide a clear and readable API for object creation, especially when the number of constructor parameters becomes cumbersome.
 * 4.You anticipate future changes or additions to the construction process without impacting client code.
 * 
 * However, if the object creation process is simple and straightforward, 
 * and there are no anticipated changes or variations, using a builder pattern may introduce 
 * unnecessary complexity. In such cases, simpler patterns like constructors or factory methods may be more appropriate.
 */
