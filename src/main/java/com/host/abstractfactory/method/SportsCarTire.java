package com.host.abstractfactory.method;

//Concrete Product: Sports Car Tire
public class SportsCarTire implements Tire {
 @Override
 public void manufacture() {
     System.out.println("Manufacturing Sports Car Tire");
 }
}
//Concrete product implementations (SedanEngine, SuvEngine, SedanTire, SuvTire, SportsCarTire, SportCarEngine) provide specific implementations of the abstract product interfaces.