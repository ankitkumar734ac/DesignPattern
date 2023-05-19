package com.host.iterator;

/**
 * 
 * @author Ankit_Kumar
 * 
 *         The Iterator design pattern is a behavioral pattern that provides a
 *         way to access the elements of an aggregate object sequentially
 *         without exposing its underlying representation. It decouples the
 *         traversal algorithm from the container, making it easier to modify or
 *         replace the traversal algorithm without affecting the container.
 * 
 *         In Java, the Iterator design pattern is commonly implemented using
 *         the java.util.Iterator interface. This interface defines the methods
 *         for traversing and accessing elements in a collection. Here's an
 *         example of how to implement and use the Iterator pattern in Java:
 */

//Define the aggregate interface
interface Aggregate {
	Iterator<Integer> createIterator();
}

//Implement the concrete aggregate class
class ConcreteAggregate implements Aggregate {
	private int[] elements;

	public ConcreteAggregate(int[] elements) {
		this.elements = elements;
	}

	@Override
	public Iterator<Integer> createIterator() {
		return new ConcreteIterator(elements);
	}
}

//Define the iterator interface
interface Iterator<T> {
	boolean hasNext();

	T next();
}

//Implement the concrete iterator class
class ConcreteIterator implements Iterator<Integer> {
	private int[] elements;
	private int position;

	public ConcreteIterator(int[] elements) {
		this.elements = elements;
		this.position = 0;
	}

	@Override
	public boolean hasNext() {
		return position < elements.length;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			int element = elements[position];
			position++;
			return element;
		}
		throw new IndexOutOfBoundsException("No more elements");
	}
}

//Client code
public class IteratorTest {
	public static void main(String[] args) {
		int[] elements = { 1, 2, 3, 4, 5 };
		Aggregate aggregate = new ConcreteAggregate(elements);
		Iterator<Integer> iterator = aggregate.createIterator();

		while (iterator.hasNext()) {
			int element = iterator.next();
			System.out.println(element);
		}
	}
}
/**
 * In the example above, we have an aggregate interface Aggregate, which defines
 * the createIterator() method for creating an iterator object. The concrete
 * aggregate class ConcreteAggregate implements this interface and provides the
 * implementation for creating a specific iterator.
 * 
 * The iterator interface Iterator defines the methods hasNext() and next() for
 * traversing the elements. The concrete iterator class ConcreteIterator
 * implements this interface and provides the necessary logic to iterate over
 * the elements of an array.
 * 
 * In the client code, we create an instance of the concrete aggregate class and
 * call its createIterator() method to get an iterator object. We then use the
 * iterator to traverse the elements of the collection and perform some
 * operations.
 * 
 * This example demonstrates the basic implementation of the Iterator pattern in
 * Java. It allows you to decouple the traversal logic from the underlying
 * collection, providing a standardized way to access elements in a sequential
 * manner.
 */

/**
 * The Iterator design pattern is used to provide a uniform way of accessing the
 * elements of a collection object, regardless of its underlying implementation.
 * Here are the main reasons for using the Iterator pattern:
 * 
 * Separation of concerns: The Iterator pattern separates the traversal
 * algorithm from the container object. This separation allows you to modify or
 * replace the traversal algorithm without affecting the container. It promotes
 * single responsibility and makes the code more maintainable.
 * 
 * Encapsulation: By providing a standardized iterator interface, the Iterator
 * pattern encapsulates the internal structure and representation of the
 * collection. Clients can access the elements without needing to know the
 * specific details of the container.
 * 
 * Sequential access: The Iterator pattern enables sequential access to the
 * elements of a collection. It provides a simple and consistent way to iterate
 * over the elements, regardless of the specific implementation details. It also
 * allows for efficient traversal of large collections by fetching elements on
 * demand.
 * 
 * Now let's discuss the pros and cons of using the Iterator pattern:
 * 
 * Pros:
 * 
 * Flexibility: The Iterator pattern allows for flexible traversal algorithms.
 * You can have different iterator implementations for the same collection,
 * enabling different types of traversals (e.g., forward, backward, filtered,
 * etc.).
 * 
 * Encapsulation: It encapsulates the internal structure of the collection,
 * providing a clean and consistent interface for accessing the elements.
 * 
 * Simplified client code: Clients can use the iterator interface to access
 * elements without dealing with the complexities of the underlying collection
 * implementation. This simplifies client code and reduces dependencies.
 * 
 * Cons:
 * 
 * Limited functionality: The Iterator pattern provides basic sequential access
 * to elements, but it may not be suitable for complex traversal scenarios or
 * when you need random access to elements. Performance impact: The iterator
 * abstraction adds a layer of indirection, which can slightly impact
 * performance compared to direct access to the collection elements.
 * 
 * Immutability: The Iterator pattern assumes that the collection being iterated
 * over doesn't change during the iteration process. If the collection is
 * modified concurrently, it may lead to unexpected behavior or exceptions.
 * 
 * Overall, the Iterator design pattern is valuable when you need a standardized
 * way to access elements in a collection and want to decouple the traversal
 * algorithm from the container. It promotes separation of concerns,
 * encapsulation, and simplifies client code. However, it may not be suitable
 * for all scenarios, especially when complex traversal or random access is
 * required.
 */
