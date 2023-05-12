package com.host.builder;

/*
// Abstract Product
public interface Car {
    String getBrand();
    String getColor();
    String getSize();
    String assemble();
    String paint();
    String polish();
}

// Concrete Products
public class Sedan implements Car {
    private String brand;
    private String color;
    private String size;

    public Sedan(String brand, String color, String size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String assemble() {
        return "Assembling sedan car...";
    }

    public String paint() {
        return "Painting sedan car...";
    }

    public String polish() {
        return "Polishing sedan car...";
    }
}

public class SUV implements Car {
    private String brand;
    private String color;
    private String size;

    public SUV(String brand, String color, String size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String assemble() {
        return "Assembling SUV car...";
    }

    public String paint() {
        return "Painting SUV car...";
    }

    public String polish() {
        return "Polishing SUV car...";
    }
}

// Abstract Factory
public interface CarFactory {
    Car createCar(String brand, String color, String size);
}

// Concrete Factories
public class SedanFactory implements CarFactory {
    public Car createCar(String brand, String color, String size) {
        return new Sedan(brand, color, size);
    }
}

public class SUVFactory implements CarFactory {
    public Car createCar(String brand, String color, String size) {
        return new SUV(brand, color, size);
    }
}

// Builder Interface
public interface CarBuilder {
    CarBuilder setBrand(String brand);
    CarBuilder setColor(String color);
    CarBuilder setSize(String size);
    CarBuilder addFeatures();
    Car build();
}

// Concrete Builder
public class CustomCarBuilder implements CarBuilder {
    private String brand;
    private String color;
    private String size;
    private CarFactory carFactory;

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public CarBuilder addFeatures() {
        // Add custom features to the car
        return this;
    }

    public CarBuilder setCarFactory(CarFactory carFactory) {
        this.carFactory = carFactory;
        return this;
    }

    public Car build() {
        if (carFactory == null) {
            throw new IllegalStateException("CarFactory not set");
        }
        return carFactory.createCar(brand, color, size);
    }
}

// Client
public class CarManufacturer {
    private CarFactory carFactory;

    public CarManufacturer(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public Car manufactureCar(CarBuilder builder) {
        Car customCar = builder.build();
        System.out.println("Manufacturing custom car of brand: " + customCar.getBrand());
        System.out.println("Color: " + customCar.getColor());
        System.out.println("Size: " + customCar.getSize
        System.out.println(customCar.assemble());
        System.out.println(customCar.paint());
        System.out.println(customCar.polish());
        return customCar;
    }
}

// Usage
public class AbstractFactoryBuilderExample {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanFactory();
        CarFactory suvFactory = new SUVFactory();

        CarManufacturer carManufacturer = new CarManufacturer(sedanFactory);

        CarBuilder customCarBuilder = new CustomCarBuilder()
                .setBrand("XYZ")
                .setColor("Red")
                .setSize("Large")
                .addFeatures();

        Car customSedanCar = carManufacturer.manufactureCar(customCarBuilder);
        System.out.println();

        // Now let's manufacture an SUV using the SUV factory
        carManufacturer = new CarManufacturer(suvFactory);

        customCarBuilder = new CustomCarBuilder()
                .setBrand("ABC")
                .setColor("Blue")
                .setSize("Extra Large")
                .addFeatures();

        Car customSuvCar = carManufacturer.manufactureCar(customCarBuilder);
    }
}


*/