package com.sj.constructors.reflectionapi3;

public class SyntheticConstructor {
	private String st;
    private SyntheticConstructor() {}
    class Inner {
	// Compiler will generate a synthetic constructor since
	// SyntheticConstructor() is private.
	Inner() { new SyntheticConstructor(); }
    }
}