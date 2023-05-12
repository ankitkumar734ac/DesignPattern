package com.host.builder;

/*
public abstract class Pizza {
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    public static abstract class Builder {
        public abstract Builder addCheese();
        public abstract Builder addPepperoni();
        public abstract Builder addVeggies();
        public abstract Pizza build();
    }
}

public class CheesePizza extends Pizza {
    private CheesePizza(Builder builder) {
        // Construction logic
    }

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

    public static class Builder extends Pizza.Builder {
        public Builder addCheese() {
            // Logic to add cheese
            return this;
        }

        public Builder addPepperoni() {
            // Logic to add pepperoni
            return this;
        }

        public Builder addVeggies() {
            // Logic to add veggies
            return this;
        }

        public CheesePizza build() {
            return new CheesePizza(this);
        }
    }
}

// Similar implementation for PepperoniPizza and VeggiePizza classes

public class PizzaStore {
    private PizzaFactory pizzaFactory;

    public PizzaStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza.Builder builder = createPizzaBuilder(type);
        if (builder != null) {
            Pizza pizza = builder.build();
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            return pizza;
        }
        return null;
    }

    private Pizza.Builder createPizzaBuilder(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza.Builder();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza.Builder();
        } else if (type.equals("veggie")) {
            return new VeggiePizza.Builder();
        } else {
            throw new IllegalArgumentException("Invalid pizza type");
        }
    }
}

public class PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza.Builder builder = createPizzaBuilder(type);
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    private Pizza.Builder createPizzaBuilder(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza.Builder();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza.Builder();
        } else if (type.equals("veggie")) {
            return new VeggiePizza.Builder();
        } else {
            throw new IllegalArgumentException("Invalid pizza type");
        }
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(pizzaFactory);

        Pizza cheesePizza = pizzaStore.orderPizza("cheese");
        System.out.println("Ordered a " + cheesePizza.getClass().getSimpleName() + "\n");

        Pizza pepperoniPizza = pizzaStore.orderPizza("pepperoni");
        System.out.println("Ordered a " + pepperoniPizza.getClass().getSimpleName() + "\n");

        Pizza veggiePizza = pizzaStore.orderPizza("veggie");
        System.out.println("Ordered a " + veggiePizza.getClass().getSimpleName() + "\n");
    }
}



*/