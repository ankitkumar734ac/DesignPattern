package com.host.observer;

import java.util.ArrayList;
import java.util.List;

//Concrete Subject
public class StockMarket implements Subject {
 private List<Observer> observers;
 private double stockPrice;

 public StockMarket() {
     observers = new ArrayList<>();
 }

 public void setStockPrice(double stockPrice) {
     this.stockPrice = stockPrice;
     notifyObservers();
 }

 @Override
 public void registerObserver(Observer observer) {
     if (!observers.contains(observer)) {
         observers.add(observer);
     }
 }

 @Override
 public void removeObserver(Observer observer) {
     observers.remove(observer);
 }

 @Override
 public void notifyObservers() {
     for (Observer observer : observers) {
         observer.update(stockPrice);
     }
 }
}
