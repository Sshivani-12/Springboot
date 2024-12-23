package com.example.demo;

public class Account {

	private String name;
	private String level;

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

	public Account() {

	}

	public String getName() {
		return name;
	}

	public Account(String name, String level) {
		super();
		this.name = name;
		this.level = level;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
