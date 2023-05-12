package com.host.abstractfactory.method;

//Concrete Product: Sports Car Engine
public class SportsCarEngine implements Engine {
 @Override
 public void design() {
     System.out.println("Designing Sports Car Engine");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.