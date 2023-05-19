package com.host.proxy;

public class DataProcessorProxy implements DataProcessor {
	private DataProcessor realDataProcessor;
	private String userRole;

	public DataProcessorProxy(String data, String userRole) {
		this.realDataProcessor = new RealDataProcessor(data);
		this.userRole = userRole;
	}

	public void process() {
		if (userRole.equals("admin")) {
			realDataProcessor.process();
		} else {
			System.out.println("Access denied. Only administrators can process the data.");
		}
	}
}
/**
 * In this example, we have an DataProcessor interface representing the data
 * processing operations. The RealDataProcessor class implements this interface
 * and performs the actual data processing.
 * 
 * The DataProcessorProxy class acts as a proxy and implements the DataProcessor
 * interface as well. It intercepts the process() method call and checks the
 * user's role. If the user is an administrator, it delegates the operation to
 * the real object (RealDataProcessor) to perform the data processing.
 * Otherwise, it denies access and displays an error message.
 * 
 * In the main method, we create two instances of the proxy: one with the role
 * of "admin" and another with the role of "user". When calling the process()
 * method on the adminProxy, it successfully processes the data. However, when
 * calling the process() method on the userProxy, it denies access due to
 * insufficient privileges.
 * 
 * By using the Proxy design pattern in this scenario, we can enforce access
 * control rules and restrict certain operations based on the user's role or
 * permissions, providing an additional layer of security to our sensitive data
 * processing application.
 */