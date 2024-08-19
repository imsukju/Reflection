package com.sj.methods.reflectionapi2;


public class MethodParameterExamples {
    
    public class InnerClass { }
    
    enum Colors {
        RED, WHITE;
    }
    
    public static void main(String... args) {
        System.out.println("InnerClass:");
        MethodParameterSpy.printClassConstructors(InnerClass.class);
        System.out.println("------------------------------------------------------");       
        System.out.println("enum Colors:");
        MethodParameterSpy.printClassConstructors(Colors.class);
        System.out.println("------------------------------------------------------");
        MethodParameterSpy.printClassMethods(Colors.class);
    }
}