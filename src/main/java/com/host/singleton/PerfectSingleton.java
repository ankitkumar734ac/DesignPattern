package com.host.singleton;

import java.io.Serializable;

/**
 * 
 * @author CA
 *	Creating a Singleton class in Java that is resistant to various scenarios like multi-threading, reflection, serialization, class loaders, and object cloning 
 *	requires implementing specific techniques.
 */
public class PerfectSingleton implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    /**
     *  Multi-threading: To support multi-threading, the volatile keyword is used to ensure that changes made to the instance variable are visible to all threads.
     */
    private static volatile PerfectSingleton instance;
    
    // Private constructor to prevent instantiation
    private PerfectSingleton() {
    	/**
    	 * Reflection: By throwing an exception in the private constructor if an instance already exists, we prevent the creation of multiple instances using reflection.
    	 */
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }
    /**
     * Class loaders: The class does not have any specific measures to guard against class loading vulnerabilities. However, 
     * the use of a private constructor and the lazy initialization in the getInstance() method help in preventing unintended creation of multiple instances.
     */
    public static PerfectSingleton getInstance() {
        if (instance == null) {
            synchronized (PerfectSingleton.class) {
                if (instance == null) {
                    instance = new PerfectSingleton();
                }
            }
        }
        return instance;
    }
    
    // Override the clone() method to prevent cloning
    /**
     * Object cloning: The clone() method is overridden to throw a CloneNotSupportedException, preventing cloning of the Singleton object.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned.");
    }
    
    // Ensure readResolve() to maintain Singleton property during deserialization
    /**
     * @return Serialization: The Singleton class implements the Serializable interface. 
     * To maintain the singleton property during deserialization, the readResolve() method is overridden to return the existing instance.
     */
    protected Object readResolve() {
        return getInstance();
    }
}
/**
 * Note: It is worth noting that there is no foolproof way to entirely prevent all possible ways of breaking a Singleton pattern.
 */

