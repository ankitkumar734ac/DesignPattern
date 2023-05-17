package com.host.decorator;

//The base decorator class
public abstract class PizzaDecorator implements Pizza {
	protected Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription();
	}

	@Override
	public double getCost() {
		return pizza.getCost();
	}
}
/*
Yes, it is possible to break the Decorator pattern if certain design principles or guidelines are not followed. Here are a few scenarios that can lead to breaking the pattern:

1. Modifying the component interface: The Decorator pattern relies on the component and decorator sharing the same interface. If you modify the component's interface, it will break the compatibility with existing decorators, and the pattern will no longer work as intended.
2. Violating the Liskov Substitution Principle: The Liskov Substitution Principle (LSP) states that objects of a superclass should be substitutable with objects of its subclasses without affecting the correctness of the program. If a decorator violates the LSP by changing the behavior of the component in unexpected ways or by introducing incompatible behavior, it can break the Decorator pattern.
3. Not ensuring proper order of decorators: The order in which decorators are applied can be crucial. If the order is not carefully considered, it can lead to unexpected behavior or conflicts. For example, if decorators override or interfere with each other's behavior incorrectly, it can break the expected functionality of the decorated object.
4. Overcomplicating the design: While the Decorator pattern provides flexibility, it is essential to use it judiciously. Overuse or excessive nesting of decorators can lead to complex and difficult-to-understand code. If the design becomes convoluted or challenging to manage due to an excessive number of decorators or intricate interdependencies, it may break the benefits and maintainability goals of the pattern.
5. Inappropriately using inheritance instead of composition: The Decorator pattern emphasizes composition over inheritance. If inheritance is misused instead of composition, it can lead to a less flexible and less modular design, negating the advantages of the pattern.
It's important to keep these considerations in mind when implementing the Decorator pattern to ensure that the pattern is correctly applied and its benefits are realized. Following best practices and adhering to the principles of object-oriented design will help avoid breaking the pattern and maintain a robust and maintainable codebase.

*/