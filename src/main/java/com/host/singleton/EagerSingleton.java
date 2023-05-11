package com.host.singleton;


/**
 * @author CA Ankit Kumar
 *	In this modified version, the instance variable is declared as final and initialized with a new instance of the Singleton class. 
 *	This ensures that the instance is created eagerly at the time of class loading.
 *	Now, whenever you call getInstance(), it will simply return the already created instance without checking for null or creating a new instance.
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
        // Private constructor to prevent instantiation from outside the class
    }
    
    public static EagerSingleton getInstance() {
        return instance;
    }
    
    public void showMessage() {
        System.out.println("Hello Eager Singleton! " + instance);
    }
}

/**
 *  Lazy initialization VS Eager initialization
 * The choice between lazy initialization and eager initialization for a Singleton depends on the specific requirements and constraints of your application. 
 * Both approaches have their advantages and considerations.
 * 
 * Lazy Initialization:
 * 1. Lazy initialization creates the Singleton instance only when it is first requested.
 * 2. It provides on-demand instance creation, which can be beneficial for memory and resource management.
 * 3. Lazy initialization can incur a slight overhead when multiple threads access the getInstance() method simultaneously, requiring synchronization to ensure thread safety.
 * 4. It is suitable when the Singleton instance is resource-intensive or its creation is costly.
 * 
 * Eager Initialization:
 * 1. Eager initialization creates the Singleton instance when the class is loaded by the JVM.
 * 2. It ensures that the instance is available immediately without any additional checks or synchronization.
 * 3. Eager initialization can be useful in scenarios where the Singleton instance needs to be available upfront or when the overhead of lazy initialization is undesirable.
 * 4. It may consume memory and resources even if the instance is not used during the application's lifetime.
 * 
 * In general, if the Singleton instance is not always required and its creation is expensive, lazy initialization can be a good choice. 
 * On the other hand, if the Singleton instance is always needed and the overhead of creating it is minimal, eager initialization can be a straightforward option.
 * It's important to note that both lazy and eager initialization can be implemented with thread-safe techniques to ensure proper Singleton behavior 
 * in multi-threaded environments.
 */