package com.host.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Ankit_Kumar
 *To prevent the Singleton pattern from being broken using Reflection, 
 *you can modify the Singleton class to throw an exception if a second 
 *instance is attempted to be created using Reflection.
 *In this modified version of the Singleton class, the private constructor throws an exception 
 *if an attempt is made to create a second instance of the Singleton class. 
 *This approach can help to prevent the Singleton pattern from being broken using Reflection.
 */
public class SingletonReflectionSafe {

    private static SingletonReflectionSafe instance;

    private SingletonReflectionSafe() {
        // Private constructor to prevent instantiation from outside the class
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static SingletonReflectionSafe getInstance() {
        if (instance == null) {
            instance = new SingletonReflectionSafe();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Singleton! " + instance);
    }
}

