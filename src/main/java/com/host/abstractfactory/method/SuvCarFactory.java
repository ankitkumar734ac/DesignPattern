package com.host.abstractfactory.method;

//Concrete Factory: SUV Car Factory
public class SuvCarFactory implements CarFactory {
 @Override
 public Engine createEngine() {
     return new SuvEngine();
 }

 @Override
 public Tire createTire() {
     return new SuvTire();
 }
}
//Concrete factory classes (SedanCarFactory, SuvCarFactory,SportCarFactory) implement the abstract factory interface and provide the logic to create the specific families of products.