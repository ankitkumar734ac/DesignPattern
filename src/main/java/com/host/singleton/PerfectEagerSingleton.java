package com.host.singleton;

import java.io.Serializable;

public class PerfectEagerSingleton implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private static final PerfectEagerSingleton INSTANCE = new PerfectEagerSingleton();

    private PerfectEagerSingleton() {
        // Private constructor to prevent instantiation from outside the class
        if (INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
    }

    public static PerfectEagerSingleton getInstance() {
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello Eager Singleton!");
    }

    // Override clone method to prevent object cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned");
    }

    // Override readResolve method to prevent object creation during deserialization
    protected Object readResolve() {
        return INSTANCE;
    }

    // Override finalize method to prevent object resurrection
    @Override
    protected void finalize() throws Throwable {
        throw new UnsupportedOperationException("Singleton class cannot be finalized");
    }
}
/**
 * Thread safety: Eager initialization ensures that the instance is created only once at class loading time, eliminating the need for additional synchronization.
 * Classloader safety: The instance is created using a static final field, ensuring that it is initialized only once per classloader.
 * Object cloning safety: The clone() method is overridden to throw a CloneNotSupportedException, preventing the creation of a cloned instance.
 * Reflection safety: The private constructor throws an exception if an instance already exists, preventing the creation of multiple instances using reflection.
 * Serialization safety: The readResolve() method is overridden to return the existing instance during deserialization, ensuring that only one instance is used.
 * Object finalization safety: The finalize() method is overridden to throw an UnsupportedOperationException, preventing the resurrection of the singleton object.
 */

