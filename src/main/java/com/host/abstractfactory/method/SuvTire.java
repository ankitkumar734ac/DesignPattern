package com.host.abstractfactory.method;

//Concrete Product: SUV Tire
public class SuvTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing SUV Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.