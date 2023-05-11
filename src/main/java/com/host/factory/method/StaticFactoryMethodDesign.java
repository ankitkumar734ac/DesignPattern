package com.host.factory.method;

public class StaticFactoryMethodDesign {
	
}
/*
 public abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    public static Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza();
        } else if (type.equals("veggie")) {
            return new VeggiePizza();
        } else {
            throw new IllegalArgumentException("Invalid pizza type");
        }
    }
}

public class CheesePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing cheese pizza...");
    }
    public void bake() {
        System.out.println("Baking cheese pizza...");
    }
    public void cut() {
        System.out.println("Cutting cheese pizza...");
    }
    public void box() {
        System.out.println("Boxing cheese pizza...");
    }
}

public class PepperoniPizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing pepperoni pizza...");
    }
    public void bake() {
        System.out.println("Baking pepperoni pizza...");
    }
    public void cut() {
        System.out.println("Cutting pepperoni pizza...");
    }
    public void box() {
        System.out.println("Boxing pepperoni pizza...");
    }
}

public class VeggiePizza extends Pizza {
    public void prepare() {
        System.out.println("Preparing veggie pizza...");
    }
    public void bake() {
        System.out.println("Baking veggie pizza...");
    }
    public void cut() {
        System.out.println("Cutting veggie pizza...");
    }
    public void box() {
        System.out.println("Boxing veggie pizza...");
    }
}

public class PizzaStore {
    public static void main(String[] args) {
        Pizza cheesePizza = Pizza.createPizza("cheese");
        cheesePizza.prepare();
        cheesePizza.bake();
        cheesePizza.cut();
        cheesePizza.box();
        System.out.println("Ordered a " + cheesePizza.getClass().getSimpleName() + "\n");

        Pizza pepperoniPizza = Pizza.createPizza("pepperoni");
        pepperoniPizza.prepare();
        pepperoniPizza.bake();
        pepperoniPizza.cut();
        pepperoniPizza.box();
        System.out.println("Ordered a " + pepperoniPizza.getClass().getSimpleName() + "\n");

        Pizza veggiePizza = Pizza.createPizza("veggie");
        veggiePizza.prepare();
        veggiePizza.bake();
        veggiePizza.cut();
        veggiePizza.box();
        System.out.println("Ordered a " + veggiePizza.getClass().getSimpleName() + "\n");
    }
}

 */
