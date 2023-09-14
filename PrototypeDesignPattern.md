# Prototype Design Pattern
The Prototype design pattern in Java allows you to create new objects by cloning existing ones. 

``Clone By using Cloneable Interface``
```java
public interface Product extends Cloneable {
    void configure();
    Product clone();
    // Add other common methods here
}
```
```java
public class BasicProduct implements Product {
	private String name;
	private List<Integer> list;

	public BasicProduct(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void configure() {
		System.out.println("Configuring basic product: " + name);
	}

	@Override
	public Product clone() {
		try {
			BasicProduct cloned = (BasicProduct) super.clone();
			cloned.list = new ArrayList<>(this.list);
			return (Product) cloned;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "BasicProduct [name=" + name + ", list=" + list + "]";
	}

	// Implement other methods specific to a basic product
}
```
```java
public class PrototypeTest {
	public static void main(String[] args) {
		BasicProduct basicProduct = new BasicProduct("Basic Product");
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		basicProduct.setList(list);
		System.out.println(basicProduct);
		System.out.println("---------------");

		BasicProduct clonedBasicProduct = (BasicProduct) basicProduct.clone();
		basicProduct.setName("Ankit");
		System.out.println(basicProduct);
		System.out.println(clonedBasicProduct);
		// clonedBasicProduct.configure();
		System.out.println("---------------");
		clonedBasicProduct.setName("Kumar");
		clonedBasicProduct.getList().add(20);
		System.out.println(clonedBasicProduct);
		System.out.println("base: " + basicProduct);
	}
}
```

``Clone by using copy constructor`` <br>
A copy constructor is a special constructor in a class that creates a new object by copying the values from an existing object of the same class. It is used to perform a deep copy of the object, ensuring that all member variables are correctly copied, including any complex or nested objects. <br/>
In Java, copy constructors are not built-in or automatically provided by the language. You need to define them explicitly in your class. Typically, a copy constructor takes an instance of the same class as a parameter and initializes the new object's member variables by copying the values from the parameter object.

```java
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
```
```java
public class PrototypeTest {
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);

		ComplexObject original = new ComplexObject(1, "Original", numbers);
		// Set initial values and configure the original object

		ComplexObject clone = original.deepCopy();
		// Perform deep cloning by using the copy constructor

		// Modify the clone or original as needed
		System.out.println(original);
		System.err.println(clone);

		original.setId(11);
		original.setName("Ankit");
		original.getNumbers().add(100000);

		System.out.println(original);
		System.err.println(clone);

		clone.setId(11222);
		clone.setName("Kumar");
		clone.getNumbers().add(1111111);

		System.out.println(original);
		System.err.println(clone);

	}

}
```

``Note``
#### To achieve a deep clone without modifying the clone() method itself, you have a few alternative options:

 ### 1. Implement the Serializable interface and use serialization/deserialization: 
 You can make your class implement the Serializable interface and use serialization to perform a deep clone. 
 This approach requires the class and its member objects to implement Serializable as well. Here's an example:

```java
class MyClass implements Serializable {
    // Class definition

    public MyClass deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (MyClass) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
```
### 2. Use external libraries:
   There are several external libraries available, such as Apache Commons Lang and Gson, that provide deep cloning utilities. These libraries often offer more convenient and flexible ways to perform deep cloning without modifying the clone() method manually.

```java
import org.apache.commons.lang3.SerializationUtils;
class MyClass {
    // Class definition

    public MyClass deepClone() {
        return SerializationUtils.clone(this);
    }
}
```
### 3. Implement a custom deep cloning mechanism: 
You can create your own custom mechanism to perform deep cloning by recursively cloning the member objects within the class. This approach requires careful handling of each member object's cloning process.


## The pros and cons of using a copy constructor for deep copying in Java are as follows:

### Pros:

1. ``Control over the copying process:`` With a copy constructor, you have full control over how the object is copied. You can explicitly define the copying logic for each member variable, including complex or nested objects.

2. ``Clear intent:`` The presence of a copy constructor explicitly indicates that deep copying is intended. It provides a clear indication to other developers that a separate copy of the object is being created.

3. ``Flexibility:`` You can choose which member variables to copy and which ones to exclude from the copying process. This gives you flexibility in managing the cloning behavior based on your specific requirements.

### Cons:

1. ``Manual implementation:`` You need to write the copy constructor manually, which requires understanding the structure of the class and all its member variables. This can be time-consuming and error-prone, especially for classes with a large number of member variables.

2. ``Maintenance:`` If there are changes to the class's structure, such as adding or removing member variables, you need to update the copy constructor accordingly. This can introduce maintenance overhead and the possibility of introducing bugs if not handled correctly.

3. ``Nested objects:`` When dealing with complex object hierarchies and nested objects, you need to ensure that the copy constructor handles deep copying of all nested objects as well. This can make the implementation more complex and prone to errors if not handled carefully.

4. ``Limited reusability:`` The copy constructor is specific to the class for which it is implemented. If you have multiple classes that require deep copying, you need to implement copy constructors for each of them, potentially duplicating code.

Overall, while using a copy constructor for deep copying provides control and clear intent, it requires manual implementation and can be more prone to maintenance and complexity issues, especially when dealing with complex object hierarchies. Consider the trade-offs and carefully evaluate the suitability of a copy constructor approach based on your specific use case.

