package com.host.decorator;

public class ProblemAndSolutionOfDecotaor {

}
/*
 Certainly! Here's an example problem and its solution using the Decorator pattern:

Problem: Imagine you have a Shape interface that represents different shapes such as circles and rectangles. You want to add additional features to these shapes, such as border color and transparency, without modifying the existing shape classes.

Solution using the Decorator pattern:

Define the Shape interface:

public interface Shape {
    void draw();
}
Implement the concrete shape classes:

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
Create the ShapeDecorator abstract class that implements the Shape interface:

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
Implement the concrete decorators:

public class BorderColorDecorator extends ShapeDecorator {
    private String borderColor;

    public BorderColorDecorator(Shape decoratedShape, String borderColor) {
        super(decoratedShape);
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Border Color: " + borderColor);
    }
}

public class TransparencyDecorator extends ShapeDecorator {
    private int transparency;

    public TransparencyDecorator(Shape decoratedShape, int transparency) {
        super(decoratedShape);
        this.transparency = transparency;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Transparency: " + transparency);
    }
}
Usage example:

public class DecoratorExample {
    public static void main(String[] args) {
        // Create a circle with a border color decorator
        Shape circle = new Circle();
        ShapeDecorator circleWithBorder = new BorderColorDecorator(circle, "Red");
        circleWithBorder.draw();

        // Create a rectangle with a transparency decorator
        Shape rectangle = new Rectangle();
        ShapeDecorator rectangleWithTransparency = new TransparencyDecorator(rectangle, 50);
        rectangleWithTransparency.draw();

        // Create a circle with both border color and transparency decorators
        Shape circleWithBothDecorators = new TransparencyDecorator(
                new BorderColorDecorator(new Circle(), "Blue"), 75);
        circleWithBothDecorators.draw();
    }
}
Output:

Drawing a circle
Border Color: Red
Drawing a rectangle
Transparency: 50
Drawing a circle
Border Color: Blue
Transparency: 75

In this example, the Decorator pattern is used to add additional features to the Shape objects without modifying the existing shape classes. The ShapeDecorator abstract class implements the Shape interface and serves as the base decorator class. Concrete decorators such as BorderColorDecorator and TransparencyDecorator extend the ShapeDecorator class and add specific behavior before or after delegating to the decorated shape object.

By creating and combining different decorators, we can dynamically add features to the shapes. This approach allows for flexible extension while adhering to the Open-Closed Principle, as the existing shape classes don't need to be modified.
 
 
 */
