package com.sj.constructors.reflectionapi2;


import java.nio.charset.Charset;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import static java.lang.System.out;
import com.sj.constructors.reflectionapi3.SyntheticConstructor;

import java.io.Console;

public class ConsoleCharset {
    public static void main(String... args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException 
    {
    	
//    	Console consol = Console.class.newInstance();
//    	String st = String.class.newInstance();
    	

    	
//		Constructor[] ctors = Console.class.getDeclaredConstructors();
//    	Constructor<?> ctor = Foo.class.getConstructor();
    	
//    	Constructor<?>[] ctors = Foo.class.getDeclaredConstructors();
    	
    	Constructor<?>[] ctors = SyntheticConstructor.class.getDeclaredConstructors();
    	Constructor<?> ctor = null;
		for (int i = 0; i < ctors.length; i++)
		{
		    ctor = ctors[i];
		    if (ctor.getGenericParameterTypes().length == 0)
		    {
		    	break;
		    }
		}
	
		try 
		{
			boolean isSet = ctor.trySetAccessible();
		    ctor.setAccessible(true);
//	 	    Console c = (Console)ctor.newInstance();
//	 	    Foo c = (Foo) ctor.newInstance();
		    
		    Object c = ctor.newInstance();
		    Field f = c.getClass().getDeclaredField("st");
		    if(isSet = f.trySetAccessible())
		    {
			    f.setAccessible(true); 
			    out.format("Console charset         :  %s%n", f.get(c));
			    out.format("Charset.defaultCharset():  %s%n",
				Charset.defaultCharset());
		    }
	        // production code should handle these exceptions more gracefully
		}
		catch (InstantiationException x) 
		{
		    x.printStackTrace();
	 	} 
		catch (InvocationTargetException x) 
		{
	 	    x.printStackTrace();
		} 
		catch (IllegalAccessException x)
		{
		    x.printStackTrace();
		} 
		catch (NoSuchFieldException x)
		{
		    x.printStackTrace();
		}
	     
	    catch (InaccessibleObjectException x)
	    {
	    	x.printStackTrace();
		}
    }
}