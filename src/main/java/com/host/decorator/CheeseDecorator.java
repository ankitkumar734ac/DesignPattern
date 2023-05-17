package com.host.decorator;

//Concrete decorators that add specific behavior
public class CheeseDecorator extends PizzaDecorator {
	public CheeseDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", with extra cheese";
	}

	@Override
	public double getCost() {
		return super.getCost() + 1.5;
	}
}