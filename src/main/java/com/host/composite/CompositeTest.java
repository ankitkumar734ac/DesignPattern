package com.host.composite;

public class CompositeTest {
	public static void main(String[] args) {
		Employee developer1 = new Developer("John");
		Employee developer2 = new Developer("Sarah");

		Manager manager1 = new Manager("Bob");
		manager1.addEmployee(developer1);
		manager1.addEmployee(developer2);

		Employee developer3 = new Developer("Mike");
		Employee developer4 = new Developer("Alice");

		Manager manager2 = new Manager("Charlie");
		manager2.addEmployee(developer3);
		manager2.addEmployee(developer4);
		manager2.addEmployee(manager1);

		manager2.showDetails();
		/**
		 * In this example, we have two types of employees: Developer and Manager. 
		 * The Developer class represents the leaf nodes, while the Manager class represents the composite nodes that can contain 
		 * other employees. The Employee interface is the common interface implemented by both types.
		 * 
		 * The Manager class maintains a list of employees and provides methods to add and remove employees. 
		 * 
		 * The showDetails() method is implemented in both leaf and composite classes. In the Manager class, 
		 * it recursively calls the showDetails() method on each employee in its list.
		 * 
		 * In the CompositeDemo class, we create a tree-like structure by adding employees to managers. 
		 * Finally, we call the showDetails() method on the top-level manager, which recursively prints the 
		 * details of all employees in the hierarchy.
		 * 
		 * The Composite pattern allows you to treat individual employees (Developer) and groups of employees (Manager) uniformly, 
		 * simplifying the client code that works with the employee hierarchy.
		 */
	}
}
