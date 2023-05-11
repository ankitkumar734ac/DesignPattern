package com.host.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {
	/**
	 * Two threads are created and both try to access the Singleton instance using
	 * the getInstance() method. Because the getInstance() method is not
	 * thread-safe, it is possible for both threads to simultaneously determine that
	 * the instance variable is null and then proceed to create their own instance
	 * of the Singleton class. This can result in two different instances of the
	 * Singleton class being created, which violates the Singleton pattern.
	 */
	public static void breakSingletonByThread() {

		Runnable task = () -> {
			Singleton singleton = Singleton.getInstance();
			System.out.println("Thread " + Thread.currentThread().getId() + " Singleton instance: " + singleton);
		};

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(task);
		executor.submit(task);

		executor.shutdown();
	}

	/**
	 * Reflection is a feature in Java that allows you to inspect and modify the
	 * runtime behavior of a program, including the ability to access private fields
	 * and methods. In this example, we first obtain an instance of the Singleton
	 * class using the getInstance() method. We then use Reflection to access the
	 * private constructor of the Singleton class and create a second instance of
	 * the class. Finally, we print out both instances to confirm that we have
	 * successfully created a second instance of the Singleton class.
	 */
	public static void breakSingletonByReflection() {
		Singleton singleton1 = Singleton.getInstance();

		// Use reflection to create a second instance of the Singleton class
		Singleton singleton2 = null;
		try {
			Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			singleton2 = constructor.newInstance();
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println("Singleton instance 1: " + singleton1);
		System.out.println("Singleton instance 2: " + singleton2);
	}

	/**
	 * Possible to break the Singleton pattern using serialization in Java.
	 * Serialization is the process of converting an object into a stream of bytes
	 * so that it can be easily stored or transmitted across a network. In this
	 * example, we first obtain an instance of the Singleton class using the
	 * getInstance() method. We then serialize the Singleton object to a file and
	 * then deserialize it back to a new instance of the Singleton class. Finally,
	 * we print out both instances to confirm that we have successfully created a
	 * second instance of the Singleton class. Note: To break the singleton by
	 * serialization we need to implement the singleton class with Serializable
	 * interface
	 */
	public static void breakSingletonBySerialization() throws Exception {
		Singleton singleton1 = Singleton.getInstance();
		// Serialize the Singleton object to a file
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
		out.writeObject(singleton1);
		out.close();

		// Deserialize the Singleton object from the file
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
		Singleton singleton2 = (Singleton) in.readObject();
		in.close();

		System.out.println("Singleton instance 1: " + singleton1);
		System.out.println("Singleton instance 2: " + singleton2);
	}

	/**
	 * The Singleton pattern can also be broken using the classloader mechanism in
	 * Java. If two classloaders load the same class separately, they will get
	 * different instances of the Singleton, breaking the pattern. In this example,
	 * we have defined a custom ClassLoader that loads the Singleton class. We
	 * create two instances of this ClassLoader and use them to load the Singleton
	 * class separately. We then instantiate two objects of the Singleton class, one
	 * using each of the loaded classes. When we run this code, we will see that we
	 * have two different instances of the Singleton class, breaking the Singleton
	 * pattern
	 */
	public static void breakSingletonByClassloaders() throws Exception {

		Singleton instance1 = Singleton.getInstance();
		System.out.println("Instance 1: " + instance1);

		CustomClassLoader breaker = new CustomClassLoader(ClassLoader.getSystemClassLoader());
		Class<?> singletonClass = breaker.loadClass("com.host.singleton.Singleton");

		Constructor<?> constructor = singletonClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object instance2 = constructor.newInstance();
		System.out.println("Instance 2: " + instance2);
	}
	/**
	 * To break the Singleton pattern by object cloning, you can override the clone() method in the Singleton class 
	 * and provide an implementation that creates a new instance.
	 * @Override
	 * protected Object clone() throws CloneNotSupportedException {
	 * 		return new Singleton();
	 * }
	 * The clone() method is overridden to create a new instance of the Singleton class using the constructor directly. 
	 * This allows cloning to generate a new instance rather than returning the existing singleton instance.
	 */
	public static void breakSingletonByObjectCloning() {
		//Singleton singleton1 = Singleton.getInstance();
        //Singleton singleton2 = (Singleton) singleton1.clone();
        
        //System.out.println("singleton1: " + singleton1);
        //System.out.println("singleton2: " + singleton2);
	}

	public static void main(String[] args) throws Exception {
		// Normal Singleton
//		Singleton singleton = Singleton.getInstance();
//		singleton.showMessage();
//		Singleton singleton1 = Singleton.getInstance();
//		singleton1.showMessage();

//		breakSingletonByThread();

//		breakSingletonByReflection();

//		breakSingletonBySerialization();

//		breakSingletonByClassloaders();

	}

}
