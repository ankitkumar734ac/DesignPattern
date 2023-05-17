package com.host.composite;

//Leaf
public class Developer implements Employee {
	private String name;

	public Developer(String name) {
		this.name = name;
	}

	public void showDetails() {
		System.out.println("Developer: " + name);
	}
}
