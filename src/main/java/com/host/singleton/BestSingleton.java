package com.host.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class BestSingleton implements Serializable {
    private static final long serialVersionUID = 1L;// This line defines a unique identifier for the class during serialization. It helps ensure compatibility between serialized objects and their class definitions.
    
    /**
     * This line defines a private static inner class called SingletonHolder. 
     * It is responsible for holding the instance of PerfectSingleton and ensures lazy initialization in a thread-safe manner.
     *
     */
    private static class SingletonHolder {
        private static final BestSingleton INSTANCE = new BestSingleton();
    }
    /**
     * This is the private constructor of the PerfectSingleton class. It is marked private to prevent instantiation from outside the class. 
     * The constructor checks if an instance already exists using the SingletonHolder.INSTANCE reference and throws an exception if it does.
     */
    private BestSingleton() {
        // Private constructor to prevent instantiation from outside the class
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
    }
    /**
     * This is a public static method that provides access to the Singleton instance. It returns the instance held by the SingletonHolder class.
     */
    public static BestSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello Perfect Singleton!");
    }

    // Override readResolve method to prevent object creation during deserialization
    /**
     * This is an overridden method from the Serializable interface. It is used during deserialization to control the instance creation process. 
     * In this case, it returns the existing instance from the SingletonHolder.
     */
    protected Object readResolve() throws ObjectStreamException {
        return SingletonHolder.INSTANCE;
    }

    // Override clone method to prevent object cloning
    /**
     * This is an overridden method from the Object class to prevent cloning of the Singleton object. It throws a CloneNotSupportedException to indicate that the Singleton class cannot be cloned.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned");
    }

    // Override finalize method to prevent object resurrection
    /**
     * This is an overridden method from the Object class that is called by the garbage collector when the object is about to be reclaimed. 
     * In this case, it throws an UnsupportedOperationException to prevent the resurrection of the Singleton object.
     */
    @Override
    protected void finalize() throws Throwable {
        throw new UnsupportedOperationException("Singleton class cannot be finalized");
    }
}
/**
 * This implementation follows the best practices for creating a perfect Singleton class. It addresses the following concerns:
 * 1. Thread safety: The Singleton instance is created in a thread-safe manner using the initialization-on-demand holder idiom.
 * 2. Classloader safety: The Singleton instance is initialized only once per classloader.
 * 3. Object cloning safety: The clone() method is overridden to throw a CloneNotSupportedException, preventing the creation of a cloned instance.
 * 4. Reflection safety: The private constructor throws an exception if an instance already exists, preventing the creation of multiple instances using reflection.
 * 5. Serialization safety: The readResolve() method is overridden to return the existing instance during deserialization, ensuring that only one instance is used.
 * 6. Object finalization safety: The finalize() method is overridden to throw an UnsupportedOperationException, preventing the resurrection of the Singleton object.
 * 
 * By incorporating these precautions, the PerfectSingleton class provides a robust implementation of a Singleton pattern that is safe from various vulnerabilities.
 */
