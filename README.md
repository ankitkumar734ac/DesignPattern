# DesignPattern
## Singleton Design Pattern
 The Singleton Design Pattern is a creational design pattern that restricts the instantiation of a class to one object and ensures that this object is globally accessible to other parts of the program. This pattern is commonly used when you need to ensure that only one instance of a particular class is created and that this instance is easily accessible from other parts of the program.
 
### There are several scenarios where you might want to make a class a Singleton in Java:
1. Resource management: You have a resource, such as a database connection or a file system handle, that is expensive to create or maintain, and you want to ensure that only one instance of the resource is created and shared among multiple parts of your application.
2. Configuration management: You have a configuration class that holds global settings or preferences for your application, and you want to ensure that these settings are accessed and modified consistently across all parts of your application.
3. Logging: You have a logging class that writes log messages to a file or database, and you want to ensure that all log messages are written to a single instance of the logging class to avoid conflicts or inconsistencies in the log data.
4. GUI components: You have a GUI component, such as a dialog box or menu, that should only be instantiated once and reused throughout the lifetime of your application.
5. State management: You have a stateful class that holds the state of your application, such as a game engine or an e-commerce shopping cart, and you want to ensure that all parts of your application access and modify the same instance of the class to maintain consistency in the application state.

###  While the Singleton Design Pattern can be useful in certain scenarios, it also has some drawbacks that should be considered:
1. Global state: By creating a single instance of a class that is accessible throughout the application, you introduce global state into your application. This can make it difficult to reason about the behavior of your code and can lead to unexpected side effects or race conditions.
2. Reduced testability: Because the Singleton class is tightly coupled to other parts of your application, it can be difficult to test in isolation. This can make it harder to write unit tests or to mock dependencies when testing other parts of your application.
3. Dependency management: Because the Singleton class is a shared resource, it can be difficult to manage dependencies between different parts of your application. Changes to the Singleton class can have unintended effects on other parts of the application, and it can be difficult to ensure that all dependencies are updated correctly.
4. Thread safety: In a multi-threaded environment, the Singleton pattern can introduce race conditions or other concurrency issues. You may need to introduce additional synchronization or locking mechanisms to ensure that only one thread can access the Singleton instance at a time.
5. Difficulty in extending the Singleton class: If you need to extend the Singleton class, you may run into difficulties because the constructor is private and cannot be called from outside the class. You may need to create a new class that extends the Singleton class and overrides its behavior, which can make your code more complex and harder to maintain.

`Normal Singleton Pattern`
```Java
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

//Calling
		Singleton singleton = Singleton.getInstance();
		singleton.showMessage();
		Singleton singleton1 = Singleton.getInstance();
   		singleton1.showMessage();
```


### This approach has some potential drawbacks:
1. Thread safety: The lazy initialization approach used in the example is not thread-safe, which means that it can lead to race conditions if multiple threads try to access the Singleton instance simultaneously. To make the Singleton class thread-safe, you can use techniques like double-checked locking or synchronization to ensure that only one thread can access the instance at a time.
2. Reflection: The Singleton class can be broken using reflection. By using reflection, it is possible to bypass the private constructor and create multiple instances of the Singleton class. To prevent this, you can throw an exception in the constructor if an instance already exists.
3. Serialization: The Singleton class can also be broken during serialization and deserialization. When an object is serialized and then deserialized, it creates a new instance of the object. To prevent this, you can implement the readResolve() method to return the existing instance instead of creating a new one.
4. Classloaders: If your application uses multiple classloaders, it is possible to create multiple instances of the Singleton class. To prevent this, you can use a single classloader or implement a registry of instances to ensure that only one instance is created.
5. Object Cloning: 

## Break Singleton By Thread
 Two threads are created and both try to access the Singleton instance using the getInstance() method. Because the getInstance() method is not thread-safe, it is possible for both threads to simultaneously determine that
the instance variable is null and then proceed to create their own instance of the Singleton class. This can result in two different instances of the Singleton class being created, which violates the Singleton pattern.
```Java
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

```

## Break Singleton by Reflection
Reflection is a feature in Java that allows you to inspect and modify the runtime behavior of a program, including the ability to access private fields and methods. In this example, we first obtain an instance of the Singleton class using the getInstance() method. We then use Reflection to access the private constructor of the Singleton class and create a second instance of the class. Finally, we print out both instances to confirm that we have successfully created a second instance of the Singleton class.

```Java
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
```
## Break Singletion by Serialization
Possible to break the Singleton pattern using serialization in Java. Serialization is the process of converting an object into a stream of bytes so that it can be easily stored or transmitted across a network. In this
example, we first obtain an instance of the Singleton class using the getInstance() method. We then serialize the Singleton object to a file and then deserialize it back to a new instance of the Singleton class. Finally, we print out both instances to confirm that we have successfully created a second instance of the Singleton class. Note: To break the singleton by serialization we need to implement the singleton class with Serializable interface.

```Java
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
```

## Break Singletion by ClassLoader
The Singleton pattern can also be broken using the classloader mechanism in Java. If two classloaders load the same class separately, they will get different instances of the Singleton, breaking the pattern. In this example, we have defined a custom ClassLoader that loads the Singleton class. We create two instances of this ClassLoader and use them to load the Singleton class separately. We then instantiate two objects of the Singleton class, one using each of the loaded classes. When we run this code, we will see that we have two different instances of the Singleton class, breaking the Singleton pattern.

```Java
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
```
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {
	public CustomClassLoader(ClassLoader parent) {
        super(parent);
	}
	public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("com.host.singleton.Singleton")) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals("com.host.singleton.Singleton")) {
            try {
                byte[] classBytes = loadClassData(name);
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (Exception e) {
                throw new ClassNotFoundException("Could not load class data");
            }
        }
        return super.findClass(name);
    }


    private byte[] loadClassData(String className) {
        // Load class data from a file or a database or a network stream, etc.
        // Return the byte array containing the class data.
    	String fileName = "target/classes/"+className.replace('.', '/') + ".class";
        Path path = Paths.get(fileName);
        try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
```

## Break Singletion by Object Cloning
To break the Singleton pattern by object cloning, you can override the `clone()` method in the Singleton class  and provide an implementation that creates a new instance.
```Java
  	@Override
	  protected Object clone() throws CloneNotSupportedException {
	 		return new Singleton();
	  }
```
The `clone()` method is overridden to create a new instance of the Singleton class using the constructor directly. This allows cloning to generate a new instance rather than returning the existing singleton instance.

```Java
	public static void breakSingletonByObjectCloning() {
		Singleton singleton1 = Singleton.getInstance();
        	Singleton singleton2 = (Singleton) singleton1.clone();
        
        	System.out.println("singleton1: " + singleton1);
        	System.out.println("singleton2: " + singleton2);
	}
```

## Eager Singleton 
In this modified version, the instance variable is declared as final and initialized with a new instance of the Singleton class. This ensures that the instance is created eagerly at the time of class loading.
Now, whenever you call getInstance(), it will simply return the already created instance without checking for null or creating a new instance.

```java
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
```
```java
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
```

## Lazy initialization VS Eager initialization
The choice between lazy initialization and eager initialization for a Singleton depends on the specific requirements and constraints of your application. 
Both approaches have their advantages and considerations.
 
`Lazy Initialization:`
1. Lazy initialization creates the Singleton instance only when it is first requested.
2. It provides on-demand instance creation, which can be beneficial for memory and resource management.
3. Lazy initialization can incur a slight overhead when multiple threads access the getInstance() method simultaneously, requiring synchronization to ensure thread safety.
4. It is suitable when the Singleton instance is resource-intensive or its creation is costly.
 
`Eager Initialization:`
1. Eager initialization creates the Singleton instance when the class is loaded by the JVM.
2. It ensures that the instance is available immediately without any additional checks or synchronization.
3. Eager initialization can be useful in scenarios where the Singleton instance needs to be available upfront or when the overhead of lazy initialization is undesirable.
4. It may consume memory and resources even if the instance is not used during the application's lifetime.
 
In general, if the Singleton instance is not always required and its creation is expensive, lazy initialization can be a good choice. On the other hand, if the Singleton instance is always needed and the overhead of creating it is minimal, eager initialization can be a straightforward option. It's important to note that both lazy and eager initialization can be implemented with thread-safe techniques to ensure proper Singleton behavior in multi-threaded environments.


## Thread Safe Singleton
You can make the getInstance() method thread-safe by using techniques like double-checked locking or synchronization to ensure that only one thread can access the instance at a time. Here's an example of how you could modify the Singleton class to use double-checked locking.In this modified version of the Singleton class, the instance variable is declared as volatile to ensure that changes to it are immediately visible to all threads. The getInstance() method uses double-checked locking to ensure that only one thread can access the instance at a time. This approach can help to prevent race conditions and ensure that the Singleton instance is only created once, even in a multi-threaded environment.
```Java
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
```

## ClassLoader Safe Singleton
To prevent this from happening, we can use the ClassLoader.getSystemClassLoader() method to ensure that only one instance of the Singleton class is loaded by the system class loader
```Java
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
```
In this modified version of the Singleton class, we have made the getInstance() method synchronized  to ensure that only one instance of the Singleton class is created even when multiple threads access it concurrently. Additionally, we have added a static block that sets the default assertion status of the system class loader to true. This ensures that the Singleton class is loaded only once by the system class loader, preventing the classloader attack on the Singleton pattern.

## Reflection Safe Singleton
To prevent the Singleton pattern from being broken using Reflection, you can modify the Singleton class to throw an exception if a second instance is attempted to be created using Reflection.In this modified version of the Singleton class, the private constructor throws an exception if an attempt is made to create a second instance of the Singleton class. This approach can help to prevent the Singleton pattern from being broken using Reflection.
```java
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
```
## Serialization Safe Singleton
To prevent the Singleton pattern from being broken using serialization, you can implement the readResolve() method in the Singleton class. This method is automatically called by the Java Serialization framework after the deserialization process is complete, and it allows you to return a reference to the original Singleton instance instead of creating a new one
```Java
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
```
## Best Singleton
```java
import java.io.ObjectStreamException;
import java.io.Serializable;

public class BestSingleton implements Serializable {
    private static final long serialVersionUID = 1L;// This line defines a unique identifier for the class during serialization. It helps ensure compatibility between serialized objects and their class definitions.
    
    /**
     * This line defines a private static inner class called SingletonHolder. 
     * It is responsible for holding the instance of PerfectSingleton and ensures lazy initialization in a thread-safe manner.
     *
     */
    private static class SingletonHolder {
        private static final BestSingleton INSTANCE = new BestSingleton();
    }
    /**
     * This is the private constructor of the PerfectSingleton class. It is marked private to prevent instantiation from outside the class. 
     * The constructor checks if an instance already exists using the SingletonHolder.INSTANCE reference and throws an exception if it does.
     */
    private BestSingleton() {
        // Private constructor to prevent instantiation from outside the class
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
    }
    /**
     * This is a public static method that provides access to the Singleton instance. It returns the instance held by the SingletonHolder class.
     */
    public static BestSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello Perfect Singleton!");
    }

    // Override readResolve method to prevent object creation during deserialization
    /**
     * This is an overridden method from the Serializable interface. It is used during deserialization to control the instance creation process. 
     * In this case, it returns the existing instance from the SingletonHolder.
     */
    protected Object readResolve() throws ObjectStreamException {
        return SingletonHolder.INSTANCE;
    }

    // Override clone method to prevent object cloning
    /**
     * This is an overridden method from the Object class to prevent cloning of the Singleton object. It throws a CloneNotSupportedException to indicate that the Singleton class cannot be cloned.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton class cannot be cloned");
    }

    // Override finalize method to prevent object resurrection
    /**
     * This is an overridden method from the Object class that is called by the garbage collector when the object is about to be reclaimed. 
     * In this case, it throws an UnsupportedOperationException to prevent the resurrection of the Singleton object.
     */
    @Override
    protected void finalize() throws Throwable {
        throw new UnsupportedOperationException("Singleton class cannot be finalized");
    }
}
```
This implementation follows the best practices for creating a perfect Singleton class. It addresses the following concerns:
1. Thread safety: The Singleton instance is created in a thread-safe manner using the initialization-on-demand holder idiom.
2. Classloader safety: The Singleton instance is initialized only once per classloader.
3. Object cloning safety: The clone() method is overridden to throw a CloneNotSupportedException, preventing the creation of a cloned instance.
4. Reflection safety: The private constructor throws an exception if an instance already exists, preventing the creation of multiple instances using reflection.
5. Serialization safety: The readResolve() method is overridden to return the existing instance during deserialization, ensuring that only one instance is used.
6. Object finalization safety: The finalize() method is overridden to throw an UnsupportedOperationException, preventing the resurrection of the Singleton object.
By incorporating these precautions, the PerfectSingleton class provides a robust implementation of a Singleton pattern that is safe from various vulnerabilities.

## Perfect Singleton
```java
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
```

## Perfect Eager Singleton
```java
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
```









 
