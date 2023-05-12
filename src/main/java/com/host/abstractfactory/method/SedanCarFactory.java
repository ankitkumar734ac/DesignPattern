package com.host.abstractfactory.method;

//Concrete Factory: Sedan Car Factory
public class SedanCarFactory implements CarFactory {
 @Override
 public Engine createEngine() {
     return new SedanEngine();
 }

 @Override
 public Tire createTire() {
     return new SedanTire();
 }
}
//Concrete factory classes (SedanCarFactory, SuvCarFactory,SportCarFactory) implement the abstract factory interface and provide the logic to create the specific families of products.