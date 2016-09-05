	package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		Custom custom = new Custom();
		
		CustomAnnotation annotation = custom.getClass().getAnnotation(CustomAnnotation.class);
		Method classDescriptionMethod = custom.getClass().getMethod(annotation.ClassDescription(), String.class);
		
		classDescriptionMethod.invoke(custom, annotation.ClassDescription());
	}

}
