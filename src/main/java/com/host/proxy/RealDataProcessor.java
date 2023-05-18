package com.host.proxy;

public class RealDataProcessor implements DataProcessor{
	private String data;
	
	public RealDataProcessor(String data) {
		this.data = data;
	}

	@Override
	public void process() {
		System.out.println("Processing data "+data);
		
	}

}
