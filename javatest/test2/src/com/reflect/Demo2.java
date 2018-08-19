package com.reflect;

import com.reflect.Person;

import java.lang.reflect.Constructor;


import org.junit.Test;

//解剖类的构造函数，创建类的对象

public class Demo2 {
	@Test
	public void test1() throws Exception   {
		Class clazz = Class.forName("test2.src.com.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		System.out.println(p.name);
	}

	@Test
	public void test2() throws Exception {
		Class<?> clazz = Class.forName("test2.src.com.reflect.Person");
		Constructor<?> c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("hdfkjf");
		System.out.println(p.name);
	}
	@Test
	public void test3() throws Exception  {
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("/test2/src/com/reflect/Person");
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
	}
}
