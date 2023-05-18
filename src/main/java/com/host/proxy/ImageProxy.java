package com.host.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//Step 3: Implement the proxy class using InvocationHandler
public class ImageProxy implements InvocationHandler {
	private String filename;
	private Image image;

	public ImageProxy(String filename) {
		this.filename = filename;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (image == null) {
			image = new RealImage(filename);
		}
		return method.invoke(image, args);
	}

}
/**
 * To break the Proxy design pattern, you would typically need to directly
 * access the real object instead of going through the proxy. This can be done
 * by bypassing or ignoring the proxy object and interacting directly with the
 * real object. However, breaking the pattern defeats the purpose of using a
 * proxy in the first place, as it's designed to control access and provide
 * additional functionality to the real object.
 * 
 * Now let's discuss the pros and cons of using the Proxy design pattern:
 * 
 * Pros:
 * 
 * 1.Provides a level of indirection: The proxy acts as a surrogate or
 * placeholder for the real object, allowing you to control access to it. This
 * can be useful in scenarios such as remote communication, lazy initialization,
 * or access control.
 * 
 * 2.Enhanced functionality: The proxy can add additional behaviors or
 * responsibilities to the real object without modifying its code. This allows
 * you to transparently provide features like logging, caching, or security
 * checks.
 * 
 * 3.Improved performance: By implementing techniques like lazy initialization
 * or caching, the proxy can optimize performance by avoiding unnecessary
 * operations or reducing resource consumption.
 * 
 * 4.Simplified client code: The client interacts with the proxy object, which
 * provides a simplified interface. The client doesn't need to know about the
 * complexity of accessing the real object, as the proxy handles it.
 * 
 * Cons:
 * 
 * 1.Additional complexity: Introducing a proxy layer can add complexity to the
 * system, as you now have multiple objects involved in the communication. This
 * can make the codebase harder to understand and maintain.
 * 
 * 2.Indirect access: The proxy introduces an additional layer of indirection,
 * which can slightly impact performance. Method invocations need to go through
 * the proxy before reaching the real object, adding a small overhead.
 * 
 * 3.Increased code size: Implementing a proxy requires writing additional code
 * for the proxy class and handling method forwarding. This can increase the
 * size of the codebase.
 * 
 * 4.Dependency on the proxy: If the client code is tightly coupled to the proxy
 * object, it can make it harder to switch or replace the proxy with a different
 * implementation or change the underlying real object.
 * 
 * 5.Potential synchronization issues: In multi-threaded environments, if the
 * proxy or real object is shared among multiple threads, you need to ensure
 * proper synchronization to avoid race conditions or inconsistent behavior.
 * 
 * It's important to consider these pros and cons in the context of your
 * specific application and requirements. The Proxy design pattern is a valuable
 * tool, but it should be used judiciously when the benefits outweigh the
 * drawbacks.F
 */
