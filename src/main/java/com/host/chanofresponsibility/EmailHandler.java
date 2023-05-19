package com.host.chanofresponsibility;

public class EmailHandler implements Runnable {
	private Request request;
	private int threadNumber;

	public EmailHandler(Request request, int threadNumber) {
		this.request = request;
		this.threadNumber = threadNumber;
	}

	@Override
	public void run() {
		System.out.println("Thread " + threadNumber + " started.");
		long startTime = System.currentTimeMillis();

		// Simulating email sending for each request
		for (int i = 1; i <= request.getNumEmails(); i++) {
			System.out.println(
					"Thread " + threadNumber + " sending email " + i + " for request " + request.getRequestNumber());
			// Send email logic goes here
		}

		long endTime = System.currentTimeMillis();
		System.out.println("Thread " + threadNumber + " ended. Start Time: " + startTime + ", End Time: " + endTime);

	}

	public String getThreadInfo() {
		return "Thread " + threadNumber + " - Start Time: " + System.currentTimeMillis() + ", End Time: "
				+ System.currentTimeMillis();
	}

}
