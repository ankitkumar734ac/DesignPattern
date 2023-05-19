package com.host.chanofresponsibility;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChainOfResponsibilityThreadTest {
	public static void main(String[] args) {
		BlockingQueue<Request> requestQueue = new LinkedBlockingQueue<>();

		Handlerr handlerA = new ConcreteHandlerAA(requestQueue);
		Handlerr handlerB = new ConcreteHandlerBB(requestQueue);

		handlerA.setNextHandler(handlerB);

		Thread threadA = new Thread(handlerA);
		Thread threadB = new Thread(handlerB);

		threadA.start();
		threadB.start();

		// Dynamically create requests and put them in the request queue
		Request requestA = new Request("TypeA");
		requestQueue.offer(requestA);

		Request requestB = new Request("TypeB");
		requestQueue.offer(requestB);

		Request requestC = new Request("TypeC");
		requestQueue.offer(requestC);
	}
}

abstract class Handlerr implements Runnable {
	protected BlockingQueue<Request> requestQueue;
	protected Handlerr nextHandler;

	public Handlerr(BlockingQueue<Request> requestQueue) {
		this.requestQueue = requestQueue;
	}

	public void setNextHandler(Handlerr nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void run() {
		while (true) {
			try {
				Request request = requestQueue.take();
				handleRequest(request);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public abstract void handleRequest(Request request);
}

class ConcreteHandlerAA extends Handlerr {
	public ConcreteHandlerAA(BlockingQueue<Request> requestQueue) {
		super(requestQueue);
	}

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

class ConcreteHandlerBB extends Handlerr {
	public ConcreteHandlerBB(BlockingQueue<Request> requestQueue) {
		super(requestQueue);
	}

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
