package com.host.composite;

public class ProblemAndSolutionOfComposite {

}



/**
 * Code Example Without Composite Pattern (Problem):
 */

/**
 * In this code, we have an Employee class representing individual objects, 
 * and a Department class representing composite objects. The problem lies 
 * in the fact that the Department class has its own displayInfo() method, 
 * which is different from the Employee class's displayInfo() method. 
 * This leads to inconsistency in treating individual and composite objects.
 */

/*
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void displayInfo() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("Sarah");

        Department department1 = new Department("Engineering");
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);

        Department department2 = new Department("Sales");
        department2.displayInfo(); // Problem: Different method used for displaying information

        department1.displayInfo();
    }
}
*/


/**
 * Code Example Using Composite Pattern (Solution):
 * 
 */


/*
import java.util.ArrayList;
import java.util.List;

interface Entity {
    void displayInfo();
}

class Employee implements Entity {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Employee: " + name);
    }
}

class Department implements Entity {
    private String name;
    private List<Entity> entities;

    public Department(String name) {
        this.name = name;
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void displayInfo() {
        System.out.println("Department: " + name);
        for (Entity entity : entities) {
            entity.displayInfo();
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Entity employee1 = new Employee("John");
        Entity employee2 = new Employee("Sarah");

        Department department1 = new Department("Engineering");
        department1.addEntity(employee1);
        department1.addEntity(employee2);

        Department department2 = new Department("Sales");
        department2.displayInfo(); // Treats individual and composite objects uniformly

        department1.displayInfo();
    }
}

 */

/**
 * In this refactored code, we introduced the Entity interface that both Employee and Department classes implement. 
 * This allows us to treat individual and composite objects uniformly. The displayInfo() method is now consistent across
 * both classes, ensuring a unified interface for clients.
 *  
 *  By applying the Composite pattern, we have solved the problem of treating individual and composite objects differently. 
 *  Clients can interact with the elements of the hierarchy using the common Entity interface, simplifying the code and ensuring 
 *  consistency. Additionally, the code supports dynamic composition and manipulation of the structure, allowing entities to be 
 *  added or removed at runtime without affecting the overall structure or client code.
 */

/*
 * In summary, treating the code as a composite using the Composite design pattern provides a more flexible, 
 * scalable, and maintainable solution for working with complex hierarchical structures, such as organizational charts.
 *  It allows for uniform treatment of objects, dynamic composition, recursive operations, and separation of concerns.
 */

















