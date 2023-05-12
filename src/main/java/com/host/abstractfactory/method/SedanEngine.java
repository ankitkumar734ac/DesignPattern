package com.host.abstractfactory.method;

//Concrete Product: Sedan Engine
public class SedanEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing Sedan Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.
