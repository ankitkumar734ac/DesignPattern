package com.host.prototype;

import java.util.ArrayList;
import java.util.List;

public class ComplexObject {
    private int id;
    private String name;
    private List<Integer> numbers;

    public ComplexObject(int id, String name, List<Integer> numbers) {
        this.id = id;
        this.name = name;
        this.numbers = numbers;
    }

    // Copy constructor for deep cloning
    public ComplexObject(ComplexObject other) {
        this.id = other.id;
        this.name = other.name;
        this.numbers = new ArrayList<>(other.numbers);
    }

    // Getters and setters for member variables
    
    /*
     * A copy constructor is a special constructor in a class that creates a new object by copying the values 
     * from an existing object of the same class. It is used to perform a deep copy of the object, ensuring that 
     * all member variables are correctly copied, including any complex or nested objects.
     * 
     * In Java, copy constructors are not built-in or automatically provided by the language. 
     * You need to define them explicitly in your class. Typically, a copy constructor takes an instance 
     * of the same class as a parameter and initializes the new object's member variables by copying the values 
     * from the parameter object.
     */
    public ComplexObject deepCopy() {
        return new ComplexObject(this);
    }

	@Override
	public String toString() {
		return "ComplexObject [id=" + id + ", name=" + name + ", numbers=" + numbers + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
}
/*
The pros and cons of using a copy constructor for deep copying in Java are as follows:

Pros:

1.Control over the copying process: With a copy constructor, you have full control over how the object is copied. You can explicitly define the copying logic for each member variable, including complex or nested objects.

2.Clear intent: The presence of a copy constructor explicitly indicates that deep copying is intended. It provides a clear indication to other developers that a separate copy of the object is being created.

3.Flexibility: You can choose which member variables to copy and which ones to exclude from the copying process. This gives you flexibility in managing the cloning behavior based on your specific requirements.

Cons:

1.Manual implementation: You need to write the copy constructor manually, which requires understanding the structure of the class and all its member variables. This can be time-consuming and error-prone, especially for classes with a large number of member variables.

2.Maintenance: If there are changes to the class's structure, such as adding or removing member variables, you need to update the copy constructor accordingly. This can introduce maintenance overhead and the possibility of introducing bugs if not handled correctly.

3.Nested objects: When dealing with complex object hierarchies and nested objects, you need to ensure that the copy constructor handles deep copying of all nested objects as well. This can make the implementation more complex and prone to errors if not handled carefully.

.Limited reusability: The copy constructor is specific to the class for which it is implemented. If you have multiple classes that require deep copying, you need to implement copy constructors for each of them, potentially duplicating code.

Overall, while using a copy constructor for deep copying provides control and clear intent, it requires manual implementation and can be more prone to maintenance and complexity issues, especially when dealing with complex object hierarchies. Consider the trade-offs and carefully evaluate the suitability of a copy constructor approach based on your specific use case.
 */
