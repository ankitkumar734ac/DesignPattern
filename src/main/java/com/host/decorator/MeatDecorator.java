package com.host.decorator;

public class MeatDecorator extends PizzaDecorator {
	public MeatDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", with meat";
	}

	@Override
	public double getCost() {
		return super.getCost() + 2.0;
	}
}
