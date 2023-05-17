package com.host.decorator;

//The concrete implementation of the component
public class PlainPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Plain pizza";
	}

	@Override
	public double getCost() {
		return 5.0;
	}
}
/*
 
When we use?
==============
The Decorator design pattern is commonly used in situations where you want to dynamically add additional behavior or responsibilities to an object without modifying its original class. Here are some scenarios where the Decorator pattern can be useful:

1.Adding functionality to existing classes: If you have a set of existing classes that perform specific tasks, and you want 
to add new behavior to them without modifying their source code, you can use the Decorator pattern. 
Instead of creating subclasses for each new behavior, you can create decorators that wrap around the original objects and provide 
the additional functionality.

2.Extending object behavior at runtime: The Decorator pattern allows you to extend the behavior of an object dynamically at runtime.
 You can add or remove decorators as needed without affecting the client code. This flexibility is particularly useful in situations 
 where the behavior requirements may change or need to be customized based on user preferences or other factors.

3.Composing objects with different combinations of behavior: By using decorators, you can combine different sets of behavior in various
 ways. This flexibility allows you to create objects with different combinations of features, providing a more modular and configurable
  approach compared to using subclassing or inheritance.

4.Implementing responsibilities in a single responsibility manner: The Decorator pattern promotes the Single Responsibility Principle 
(SRP) by allowing you to separate different responsibilities into individual decorators. Each decorator focuses on a specific aspect
 of behavior, making the code more maintainable and easier to understand.

5.Avoiding a "fat" class hierarchy: If you have a class hierarchy that could become excessively large and complex due to the increasing
 number of subclasses, the Decorator pattern provides an alternative solution. Instead of creating numerous subclasses for each possible 
 combination of behavior, you can use decorators to dynamically add the desired behavior without the need for a deep and complex class
  hierarchy.

Overall, the Decorator pattern is useful when you want to add behavior to an object dynamically, maintain flexibility, and avoid 
modifying existing code. It provides a way to enhance and customize objects while adhering to key design principles such as the
 Open-Closed Principle and the Single Responsibility Principle.

*/