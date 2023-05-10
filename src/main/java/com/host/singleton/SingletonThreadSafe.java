package com.host.singleton;
/**
 * 
 * @author Ankit_Kumar
 *You can make the getInstance() method thread-safe by using techniques like double-checked locking
 *or synchronization to ensure that only one thread can access the instance at a time.
 * Here's an example of how you could modify the Singleton class to use double-checked locking.
 *In this modified version of the Singleton class, the instance variable is declared as
 *volatile to ensure that changes to it are immediately visible to all threads. 
 *The getInstance() method uses double-checked locking to ensure that only one thread can 
 *access the instance at a time. This approach can help to prevent race conditions and ensure 
 *that the Singleton instance is only created once, even in a multi-threaded environment.
 */
public class SingletonThreadSafe {

    private static volatile SingletonThreadSafe instance;

    private SingletonThreadSafe() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static SingletonThreadSafe getInstance() {
        if (instance == null) {
            synchronized (SingletonThreadSafe.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafe();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello Singleton! "+instance);
    }
}

