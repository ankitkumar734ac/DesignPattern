package com.host.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EagerSingletonTest {

	public static void breakEagerSingletonByRefelection() {
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = null;

		try {
			// Use reflection to access the private constructor
			Constructor<EagerSingleton> constructor = EagerSingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			instance2 = constructor.newInstance();
		} catch (NoSuchMethodException | IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println("Instance 1: " + instance1);
		System.out.println("Instance 2: " + instance2);
		System.out.println("Are the instances equal? " + (instance1 == instance2));

	}

	public static void main(String[] args) {
		breakEagerSingletonByRefelection();
	}
}
