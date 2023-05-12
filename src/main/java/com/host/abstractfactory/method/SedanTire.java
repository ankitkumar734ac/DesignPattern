package com.host.abstractfactory.method;

//Concrete Product: Sedan Tire
public class SedanTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing Sedan Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.