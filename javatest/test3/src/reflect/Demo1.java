package reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test1() throws Exception  {
		
		Person p = new Person();
		Class clazz = Class.forName("/test3/src/reflect/Person");
		Method method = clazz.getMethod("aa1", null);
		method.invoke(p, null);
	}

}
