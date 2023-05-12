package com.host.abstractfactory.method;

//Concrete Product: SUV Engine
public class SuvEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing SUV Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.