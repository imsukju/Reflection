package com.sj.fields.reflectionapi2;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.out;


enum Spy { BLACK , WHITE }

public class FieldModifierSpy {
    volatile int share;
    int instance;
    public static String name;
    class Inner {}
    private Double dou;
    private Inner inner; 
    
    public class Inner1{
    	int a;
        private FieldModifierSpy this$0;
        Inner1 (FieldModifierSpy a)
        {
        	this$0 = a;
        }
        
        public FieldModifierSpy hi()
        {
        	return this$0;
        }
    	}
  
    

    public static void main(String... args) {
		try {
		    Class<?> c = Class.forName(args[0]);
		    int searchMods = 0x0;
		    for (int i = 1; i < args.length; i++) {
		    	searchMods |= modifierFromString(args[i]);
//		    	searchMods = modifierFromConstant(args[i]);
 
		    }
	
		    Field[] flds = c.getDeclaredFields();
		    out.format("Fields in Class '%s' containing modifiers:  %s%n",
			       c.getName(),
			       Modifier.toString(searchMods));
		    boolean found = false;
		    for (Field f : flds) {
			int foundMods = f.getModifiers();

			// Require all of the requested modifiers to be present
			if ((foundMods & searchMods) == searchMods) {
			    out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n",
				       f.getName(), f.isSynthetic(),
				       f.isEnumConstant());
			    found = true;
				}
		    }
		    
		    Optional<Field> ab; 
		   Class<?> abcc =  Class.forName("com.sj.fields.reflectionapi2.FieldModifierSpy.Inner");
		   Field[] abccfield = abcc.getDeclaredFields();
		   Stream<Field> streamfield = Arrays.stream(abccfield);
		   
		 streamfield.forEach(field->{
			 if(field.isSynthetic())
			 {
				 
			 }
		 }
		 );

		    if (!found) {
			out.format("No matching fields%n");
		    }

		        // production code should handle this exception more gracefully
			} catch (ClassNotFoundException x) {
			    x.printStackTrace();
			}
	}

    private static int modifierFromString(String s) {
		int m = 0x0;

		if ("public".equals(s))           m |= Modifier.PUBLIC;
		else if ("protected".equals(s))   m |= Modifier.PROTECTED;
		else if ("private".equals(s))     m |= Modifier.PRIVATE;
		else if ("static".equals(s))      m |= Modifier.STATIC;
		else if ("final".equals(s))       m |= Modifier.FINAL;
		else if ("transient".equals(s))   m |= Modifier.TRANSIENT;
		else if ("volatile".equals(s))    m |= Modifier.VOLATILE;
		else if ("synthetic".equals(s))   m |= Modifier.SYNCHRONIZED;
		return m;
    }
    
    private static int modifierFromConstant(int foundMods)
    {
    	
    	String ret = "Modifiers :";
    	
		if ((foundMods & Modifier.PUBLIC) == Modifier.PUBLIC)
		{
			ret = ret +"public";
		}
		if ((foundMods & Modifier.PROTECTED) == Modifier.PROTECTED)
		{
			ret = ret +"protected";
		}
		if ((foundMods & Modifier.PRIVATE) == Modifier.PRIVATE)
		{
			ret = ret +"private";
		}
		if ((foundMods & Modifier.STATIC) == Modifier.STATIC)
		{
			ret = ret +"static";
		}		
		if ((foundMods & Modifier.FINAL) == Modifier.FINAL)
		{
			ret = ret +"final";
		}
		if ((foundMods & Modifier.TRANSIENT) == Modifier.TRANSIENT)
		{
			ret = ret +"transient";
		}
		if ((foundMods & Modifier.VOLATILE) == Modifier.VOLATILE)
		{
			ret = ret +"VOLATILE";
		}	
		out.println(ret);
		return foundMods;
    	
    }
}