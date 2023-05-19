package com.host.chanofresponsibility;

public class ChanOfResponsibilityTest {
	public static void main(String[] args) {
		Handler handlerA = new ConcreteHandlerA();
		Handler handlerB = new ConcreteHandlerB();

		handlerA.setNextHandler(handlerB);

		Request requestA = new Request("TypeA");
		handlerA.handleRequest(requestA);

		Request requestB = new Request("TypeB");
		handlerA.handleRequest(requestB);

		Request requestC = new Request("TypeC");
		handlerA.handleRequest(requestC);
	}
}
/**
 * The Chain of Responsibility design pattern is a behavioral pattern that
 * allows an object to pass a request along a chain of potential handlers until
 * the request is handled or reaches the end of the chain. Each handler in the
 * chain has the ability to handle the request or pass it to the next handler.
 */
