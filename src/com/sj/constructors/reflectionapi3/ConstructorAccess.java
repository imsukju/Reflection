package com.sj.constructors.reflectionapi3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import com.sj.constructors.reflectionapi2.Foo;

import static java.lang.System.out;

public class ConstructorAccess {
	public static void callInner()
	{
    	Constructor<?>[] ctors = Foo.class.getDeclaredConstructors();
    	Constructor<?> ctor = null;
		for (int i = 0; i < ctors.length; i++)
		{
		    ctor = ctors[i];
		    if (ctor.getGenericParameterTypes().length == 0)
		    {
		    	break;
		    }
		}
	}
    public static void main(String... args)
    {
		try 
		{
			Class<?> clazz = Class.forName(args[0]);
		    Class<?> c = Class.forName(args[0]);
		    Constructor[] allConstructors = clazz.getDeclaredConstructors();
		    for (Constructor ctor : allConstructors) 
		    {
				int searchMod = modifierFromString(args[1]);
				int mods = accessModifiers(ctor.getModifiers());
				if (searchMod == mods) 
				{
				    out.format("%s%n", ctor.toGenericString());
				    out.format("  [ synthetic=%-5b var_args=%-5b ]%n",
				    ctor.isSynthetic(), ctor.isVarArgs());
				}
		    }

        // production code should handle this exception more gracefully
		} 
		catch (ClassNotFoundException x)
		{
		    x.printStackTrace();
		}
    }

    private static int accessModifiers(int m) 
    {
		return m & (Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED);
    }

    private static int modifierFromString(String s)
    {
		if ("public".equals(s))               return Modifier.PUBLIC;
		else if ("protected".equals(s))       return Modifier.PROTECTED;
		else if ("private".equals(s))         return Modifier.PRIVATE;
		else if ("package-private".equals(s)) return 0;
		else return -1;
    }
}