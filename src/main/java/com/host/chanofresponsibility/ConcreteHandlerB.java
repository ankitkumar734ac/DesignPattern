package com.host.chanofresponsibility;

public class ConcreteHandlerB extends Handler {
	public void handleRequest(Request request) {
		if (request.getType().equals("TypeB")) {
			System.out.println("ConcreteHandlerB handles the request");
		} else if (nextHandler != null) {
			nextHandler.handleRequest(request);
		} else {
			System.out.println("No handler available for the request");
		}
	}
}

/*
 * Pros of the Chain of Responsibility pattern:
 * 
 * 1.Decouples the sender and receiver of a request.
 * 
 * 2.Allows for dynamic configuration of the chain.
 * 
 * 3.Enables you to add or remove handlers without modifying the client code.
 * 
 * 4.Provides flexibility in defining how the request is handled.
 * 
 * Cons of the Chain of Responsibility pattern:
 * 
 * 1.Requests may go unhandled if there is no handler in the chain capable of
 * handling them.
 * 
 * 2.Debugging can be difficult if the chain is long and complex.
 * 
 */