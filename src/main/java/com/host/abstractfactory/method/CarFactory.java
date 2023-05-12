package com.host.abstractfactory.method;

//Abstract Factory
public interface CarFactory {
	Engine createEngine();

	Tire createTire();
}
//The abstract factory interface (CarFactory) declares factory methods to create the abstract product objects.