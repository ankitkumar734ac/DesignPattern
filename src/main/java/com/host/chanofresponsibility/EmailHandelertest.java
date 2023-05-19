package com.host.chanofresponsibility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 
 * Certainly! Based on your requirements, here's an example that demonstrates
 * how to design an email handler that handles multiple requests dynamically
 * using threads. Each thread represents the handling of one request, and upon
 * completion, it returns a string object with the thread number, start time,
 * and end time.
 */
public class EmailHandelertest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		// Dynamically create requests
		for (int i = 1; i <= 5; i++) {
			int numEmails = (int) (Math.random() * 11) + 10; // Randomly generate number of emails between 10 and 20
			Request request = new Request(i, numEmails);

			executorService.execute(new EmailHandler(request, i));
		}

		executorService.shutdown();
	}
}
/**
 * In this example, we have an EmailHandler class that implements the Runnable
 * interface. Each instance of EmailHandler represents the handling of one
 * request and multiple emails. The run method simulates the email sending
 * process for the given request, printing relevant information at different
 * stages.
 * 
 * The Request class represents a single request and holds the request number
 * and the number of emails associated with that request.
 * 
 * In the Main class, we use the ExecutorService and the CachedThreadPool to
 * manage the execution of the email handlers. We dynamically create requests
 * and submit them to the executor service, which assigns a thread from the
 * thread pool to handle each request.
 * 
 * Upon completion of each thread's execution, it prints the start time and end
 * time. If you want to collect this information, you can modify the
 * EmailHandler class to store the thread information and provide a getter
 * method (getThreadInfo) to retrieve it.
 * 
 * Note that in this example, we're simulating the email sending process using a
 * loop. You can replace the loop with your actual email sending logic inside
 * the run method.
 * 
 * I hope this example helps you achieve your desired functionality!
 */