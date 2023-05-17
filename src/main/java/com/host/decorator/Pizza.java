package com.host.decorator;

//The interface for the component or the original object
public interface Pizza {
	String getDescription();

	double getCost();
}

/**
 * The Decorator design pattern has several advantages and some potential drawbacks. Here are the pros and cons of using the Decorator pattern:
 * 
 * Pros:
 * 1. Flexible extension: The Decorator pattern allows for dynamic and flexible extension of an object's behavior at runtime. You can add or remove decorators as needed, without modifying the original object or its other decorators
 * 2. Open for extension, closed for modification: With the Decorator pattern, you can add new functionality to an object without modifying its existing code. This principle helps maintain the existing code and reduces the risk of introducing bugs
 * 3. Composition over inheritance: The Decorator pattern promotes composition over inheritance, which provides more flexibility and avoids the limitations of subclassing. You can combine multiple decorators in various ways to create different combinations of behavior
 * 4. Single Responsibility Principle (SRP): The Decorator pattern allows you to separate the responsibilities of an object into different decorators. Each decorator focuses on a specific aspect of behavior, promoting a clear and modular design.
 * 5. Easy to add or remove decorators: Since decorators implement the same interface as the wrapped object, they can be easily added or removed without affecting the client code. This flexibility makes it straightforward to customize an object's behavior.
 * 
 * Cons:
 * 1. Increased complexity: The Decorator pattern can introduce additional complexity to the codebase. With multiple layers of decorators, it may become harder to understand the flow of execution and trace the behavior of the object.
 * 2. Object proliferation: As you add more decorators, the number of objects in the system can increase significantly. This can result in a large number of small, specialized objects, which may impact performance and memory usage.
 * 3. Order of decoration: The order in which decorators are applied can be crucial. If decorators are not applied correctly, it may lead to unexpected behavior or conflicts. Ensuring the correct order of decorators can require careful attention and testing.
 * 4. Overuse potential: There is a risk of overusing the Decorator pattern, especially if simple behavior extensions can be achieved through other means, such as subclassing or using other design patterns. Using the Decorator pattern for trivial extensions can unnecessarily complicate the code.
 * 
 * Overall, the Decorator pattern is a powerful tool for adding behavior dynamically and maintaining code flexibility. However, like any design pattern, it should be used judiciously, considering the specific requirements and trade-offs of the project at hand.
 * 
 */