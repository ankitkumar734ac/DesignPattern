package com.host.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		// Create the proxy object
		Image image = (Image) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] { Image.class },
				new ImageProxy("image.jpg"));
		// Call the methods on the proxy object
		image.display();
		// The real object is only created when needed
		image.display();
		
		//----------------------------------------
		System.out.println();
		String userRole = "admin";
        String data = "Sensitive Data";

        if (userRole.equals("admin")) {
            DataProcessor dataProcessor = new RealDataProcessor(data);
            dataProcessor.process(); // Processing data: Sensitive Data
        } else {
            System.out.println("Access denied. Only administrators can process the data.");
        }
        DataProcessor adminProxy = new DataProcessorProxy("Sensitive Data", "admin");
        adminProxy.process(); // Processing data: Sensitive Data

        DataProcessor userProxy = new DataProcessorProxy("Sensitive Data", "user");
        userProxy.process(); // Access denied. Only administrators can process the data.
    
	}

}
/**
 * In this example, we have an Image interface representing the real object and
 * a RealImage class that implements this interface. The RealImage class
 * represents the actual image loading and displaying functionality.
 * 
 * The ImageProxy class implements the InvocationHandler interface, which allows
 * it to intercept method calls to the proxy object. In the invoke method, we
 * check if the real object (image) is null. If it is, we create an instance of
 * RealImage and store it in the image variable. Then, we invoke the requested
 * method on the real object.
 * 
 * In the main method, we create an instance of the proxy object using
 * Proxy.newProxyInstance, passing the class loader, the interfaces it should
 * implement (Image in this case), and the InvocationHandler implementation
 * (ImageProxy). We can then call the methods on the proxy object, and the proxy
 * will handle the creation and forwarding of the requests to the real object as
 * needed.
 * 
 * When you run the ProxyExample class, you will see that the image is only
 * loaded from disk and displayed when the display method is called on the proxy
 * object. This demonstrates the lazy loading behavior provided by the proxy.
 */
