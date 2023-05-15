package com.host.adapter;

//Adapter to adapt the new payment gateway to the existing interface
public class NewPaymentGatewayAdapter implements PaymentGateway {
	private NewPaymentGateway newPaymentGateway;

	public NewPaymentGatewayAdapter(NewPaymentGateway newPaymentGateway) {
		this.newPaymentGateway = newPaymentGateway;
	}

	public void processPayment(double amount) {
		newPaymentGateway.makePayment(amount);
	}
}
/*
To adapt the new payment gateway to the existing PaymentGateway interface, 
an adapter class named NewPaymentGatewayAdapter is created. 
This adapter class implements the PaymentGateway interface and internally uses an instance of 
NewPaymentGateway to delegate the payment processing. The processPayment method of the adapter 
calls the makePayment method of the NewPaymentGateway object.
*/