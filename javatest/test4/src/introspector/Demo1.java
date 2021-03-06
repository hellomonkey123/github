package introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

import beanutils.Job;

public class Demo1 {
	
	
	@Test
	public void test1() throws Exception{
		
		BeanInfo info = Introspector.getBeanInfo(Job.class,Object.class);
		PropertyDescriptor[] ps = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : ps) {
			System.out.println(pd.getName());
		}
	}
	
	@Test
	public void test2() throws Exception {
		
		Job p = new Job();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Job.class);
		Method method = pd.getWriteMethod();
		method.invoke(p, 45);
		
		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
	}
	
	@Test
	public void test3() throws Exception {
		
		Job p = new Job();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Job.class);
		
		System.out.println(pd.getPropertyType());
	}
}
