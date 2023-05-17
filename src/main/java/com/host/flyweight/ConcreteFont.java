package com.host.flyweight;

 // ConcreteFlyweight class
public class ConcreteFont implements Font {
    private String name;

    public ConcreteFont(String name) {
        this.name = name;
    }

    @Override
    public void render(String text) {
        System.out.println("Rendering '" + text + "' in font: " + name);
    }
}
