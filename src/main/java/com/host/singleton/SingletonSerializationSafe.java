package com.host.singleton;

import java.io.*;

/**
 * @author Ankit_Kumar
 *To prevent the Singleton pattern from being broken using serialization, 
 *you can implement the readResolve() method in the Singleton class. 
 *This method is automatically called by the Java Serialization framework after the 
 *deserialization process is complete, and it allows you to return a reference to the 
 *original Singleton instance instead of creating a new one
 *
 */
public class SingletonSerializationSafe implements Serializable {

    private static SingletonSerializationSafe instance;

    private SingletonSerializationSafe() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static SingletonSerializationSafe getInstance() {
        if (instance == null) {
            instance = new SingletonSerializationSafe();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Singleton! " + instance);
    }
    /**
     * In this modified version of the Singleton class, we have implemented the Serializable 
     * interface and overridden the readResolve() method to return the original Singleton instance. 
     * This approach can help to prevent the Singleton pattern from being broken using serialization.
     */
    protected Object readResolve() {
        return instance;
    }
}

