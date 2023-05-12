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
