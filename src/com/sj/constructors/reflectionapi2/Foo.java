package com.sj.constructors.reflectionapi2;

public class Foo 
{
	private String name;
	
	private Foo()
	{
		name = "hello";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
