package com.host.chanofresponsibility;

public class ConcreteHandlerA extends Handler {
	public void handleRequest(Request request) {
		if (request.getType().equals("TypeA")) {
			System.out.println("ConcreteHandlerA handles the request");
		} else if (nextHandler != null) {
			nextHandler.handleRequest(request);
		} else {
			System.out.println("No handler available for the request");
		}
	}
}
/*
 * 
 * When to use the Chain of Responsibility pattern:
 * 
 * 1.When you want to decouple the sender of a request from its receivers and
 * give multiple objects a chance to handle the request.
 * 
 * 2.When you have a group of objects that can handle a request in different
 * ways, but the sender doesn't need to know which object will handle the
 * request.
 * 
 * 3.When you want to add new handlers dynamically without modifying the
 * existing client code.
 */