package com.sj.classes.reflectionapi;

public class Program {

	static Object o = new Object() {
		public void m() {}
	};
	
	static Class<?> c = o.getClass().getEnclosingClass();
	
	
	public static void getObjectgetClass()
	{
		Class<?> c = "foo".getClass();
		
		enum E { A, B }
		Class<? extends E> c1 = E.A.getClass();
		// String 클래스 객체를 만들어줌
		
		byte[] bytes = new byte[1024];
		Class c2 = bytes.getClass();
		
		String abc = "abc";
		int baa = 1;
		
		Class c3 = abc.getClass();
		Class c4 = Double.class;
		Class c5 = int.class;
	}
	
	public static void main(String[] args)
	{
		 getObjectgetClass();
		 
		 //플그램 클래스의 스태틱 필드인 c가 main 메서드 로컬 변수인 c에 의해 shadow 되었음
		 Class<?> c = Thread.State.class.getEnclosingClass();
		 Class<?>[] cs = Child.class.getClasses();
		 for (Class clazz:cs)
		     System.out.println(clazz.getTypeName());
		 
		 System.out.println("[Ljava.lang.String;".getClass().toString());
		 
		 
	}

}
