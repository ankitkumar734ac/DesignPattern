package com.host.proxy;

public interface DataProcessor {
	void process();
}
/**
 * In this example, we have the DataProcessor interface and the
 * RealDataProcessor class, just like before. However, instead of using a proxy,
 * we directly perform the access control check in the main method. If the user
 * has the role of "admin", we create an instance of RealDataProcessor and call
 * the process() method to perform the data processing. Otherwise, we display an
 * error message indicating that access is denied.
 * 
 * While this approach may work for a simple scenario with a single access
 * control check, it can become more complex and less maintainable as the
 * application grows and additional access control rules or conditions are
 * introduced. The Proxy design pattern provides a more flexible and modular
 * solution by separating the access control logic into a dedicated proxy
 * object, making the code more scalable and easier to extend or modify in the
 * future.
 */