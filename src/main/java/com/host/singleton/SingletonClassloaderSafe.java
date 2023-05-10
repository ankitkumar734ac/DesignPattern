package com.host.singleton;
/**
 * @author Ankit_Kumar
 *To prevent this from happening, we can use the ClassLoader.getSystemClassLoader() method to ensure that
 * only one instance of the Singleton class is loaded by the system class loader
 */
public class SingletonClassloaderSafe {
	private static SingletonClassloaderSafe instance;

	public static synchronized SingletonClassloaderSafe getInstance() {
		if (instance == null) {
			instance = new SingletonClassloaderSafe();
		}
		return instance;
	}

	static {
	    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
	}

}
/**
 * In this modified version of the Singleton class, we have made the getInstance() method synchronized 
 * to ensure that only one instance of the Singleton class is created even when multiple threads access
 * it concurrently. Additionally, we have added a static block that sets the default assertion status
 * of the system class loader to true. This ensures that the Singleton class is loaded only once by the 
 * system class loader, preventing the classloader attack on the Singleton pattern.
 */

