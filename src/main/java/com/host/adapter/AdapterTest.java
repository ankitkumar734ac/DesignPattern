package com.host.adapter;

public class AdapterTest {
	/**
	 * The Adapter design pattern is a structural design pattern that allows objects with incompatible interfaces to work together 
	 * by acting as a bridge between them. It converts the interface of one class into another interface that clients expect, 
	 * enabling them to interact seamlessly.
	 * A real-time project example of the Adapter design pattern is integrating a third-party payment gateway into 
	 * an e-commerce application. Suppose the application initially supported payments using a specific payment gateway, 
	 * but now needs to integrate a new payment gateway with a different interface. Instead of modifying the existing codebase 
	 * extensively, an Adapter can be implemented to adapt the new payment gateway to the existing interface expected by the application.
	 */
	/**
	 * Finally, in the main method of the Main class, two scenarios are demonstrated. 
	 * First, an instance of ExistingPaymentGateway is created and used directly to process a payment. 
	 * Then, a new payment gateway object (NewPaymentGateway) is created, and an adapter (NewPaymentGatewayAdapter) is 
	 * used to adapt it to the existing PaymentGateway interface. The adapter is then used to process a payment using 
	 * the new payment gateway.
	 * 
	 */
	public static void main(String[] args) {
		// Existing payment gateway
        PaymentGateway existingGateway = new ExistingPaymentGateway();
        existingGateway.processPayment(100.0);

        // New payment gateway (using adapter)
        NewPaymentGateway newGateway = new NewPaymentGateway();
        PaymentGateway newGatewayAdapter = new NewPaymentGatewayAdapter(newGateway);
        newGatewayAdapter.processPayment(100.0);
	}

}
