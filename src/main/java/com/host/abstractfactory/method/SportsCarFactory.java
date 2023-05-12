package com.host.abstractfactory.method;

//Concrete Factory: Sports Car Factory
public class SportsCarFactory implements CarFactory {
 @Override
 public Engine createEngine() {
     return new SportsCarEngine();
 }

 @Override
 public Tire createTire() {
     return new SportsCarTire();
 }
}
//Concrete factory classes (SedanCarFactory, SuvCarFactory,SportCarFactory) implement the abstract factory interface and provide the logic to create the specific families of products.