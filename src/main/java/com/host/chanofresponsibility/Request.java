package com.host.chanofresponsibility;

public class Request {
	private String type;

    public Request(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    private int requestNumber;
    private int numEmails;

    public Request(int requestNumber, int numEmails) {
        this.requestNumber = requestNumber;
        this.numEmails = numEmails;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public int getNumEmails() {
        return numEmails;
    }
}
