package com.host.singleton;

import java.io.Serializable;

/**
 * @author Ankit_Kumar
 * Singleton Design Pattern
 * --> The Singleton Design Pattern is a creational design pattern that restricts the instantiation of a class to one object 
 * and ensures that this object is globally accessible to other parts of the program. 
 * This pattern is commonly used when you need to ensure that only one instance of a particular class is created and 
 * that this instance is easily accessible from other parts of the program.
 *
 */
/**
 * There are several scenarios where you might want to make a class a Singleton in Java:
 * 1. Resource management: You have a resource, such as a database connection or a file system handle, that is expensive to create or maintain, and you want to ensure that only one instance of the resource is created and shared among multiple parts of your application.
 * 2. Configuration management: You have a configuration class that holds global settings or preferences for your application, and you want to ensure that these settings are accessed and modified consistently across all parts of your application.
 * 3. Logging: You have a logging class that writes log messages to a file or database, and you want to ensure that all log messages are written to a single instance of the logging class to avoid conflicts or inconsistencies in the log data.
 * 4. GUI components: You have a GUI component, such as a dialog box or menu, that should only be instantiated once and reused throughout the lifetime of your application.
 * 5. State management: You have a stateful class that holds the state of your application, such as a game engine or an e-commerce shopping cart, and you want to ensure that all parts of your application access and modify the same instance of the class to maintain consistency in the application state.
 */
/**
 * While the Singleton Design Pattern can be useful in certain scenarios, it also has some drawbacks that should be considered:
 * 1. Global state: By creating a single instance of a class that is accessible throughout the application, you introduce global state into your application. This can make it difficult to reason about the behavior of your code and can lead to unexpected side effects or race conditions.
 * 2. Reduced testability: Because the Singleton class is tightly coupled to other parts of your application, it can be difficult to test in isolation. This can make it harder to write unit tests or to mock dependencies when testing other parts of your application.
 * 3. Dependency management: Because the Singleton class is a shared resource, it can be difficult to manage dependencies between different parts of your application. Changes to the Singleton class can have unintended effects on other parts of the application, and it can be difficult to ensure that all dependencies are updated correctly.
 * 4. Thread safety: In a multi-threaded environment, the Singleton pattern can introduce race conditions or other concurrency issues. You may need to introduce additional synchronization or locking mechanisms to ensure that only one thread can access the Singleton instance at a time.
 * 5. Difficulty in extending the Singleton class: If you need to extend the Singleton class, you may run into difficulties because the constructor is private and cannot be called from outside the class. You may need to create a new class that extends the Singleton class and overrides its behavior, which can make your code more complex and harder to maintain.
 */

public class Singleton  {

    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation from outside the class
    }
    //lazy initialization 
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Singleton! "+instance);
    }
}
/**
 *  This approach has some potential drawbacks:
 *  1. Thread safety: The lazy initialization approach used in the example is not thread-safe, which means that it can lead to race conditions if multiple threads try to access the Singleton instance simultaneously. To make the Singleton class thread-safe, you can use techniques like double-checked locking or synchronization to ensure that only one thread can access the instance at a time.
 *  2. Reflection: The Singleton class can be broken using reflection. By using reflection, it is possible to bypass the private constructor and create multiple instances of the Singleton class. To prevent this, you can throw an exception in the constructor if an instance already exists.
 *  3. Serialization: The Singleton class can also be broken during serialization and deserialization. When an object is serialized and then deserialized, it creates a new instance of the object. To prevent this, you can implement the readResolve() method to return the existing instance instead of creating a new one.
 *  4. Classloaders: If your application uses multiple classloaders, it is possible to create multiple instances of the Singleton class. To prevent this, you can use a single classloader or implement a registry of instances to ensure that only one instance is created.
 *  5. Object Cloning: 
 */
