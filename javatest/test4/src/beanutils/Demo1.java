package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class Demo1 {
	
	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException {
		
		Job p = new  Job();
		BeanUtils.setProperty(p, "name", "xcc");
		System.out.println(p.getName());
	}
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException {
		
		String name = "aaaa";
		String password = "123";
		String age = "34";
		String birthday = "2018-04-12";
		
		ConvertUtils.register(new Converter() {
			
			public Object convert(Class type, Object value) {
				
				if(value==null) {
					return null;
				}
				if(!(value instanceof String)) {
					throw new ConversionException("only surport type of String");
				}
				String str = (String) value;
				if(str.trim().equals("")) {
					return null;
				}
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
					}catch (ParseException e){
						throw new RuntimeException(e);
					}
			}
		}, Date.class);
		
		Job p = new Job();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		//Date date =  p.getBirthday();
		System.out.println(p.getBirthday());
		
	}
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException {
		
		Map map = new HashMap();
		map.put("name", "aaa");
		map.put("password", "123");
		map.put("age", "13");
		map.put("birthday", "1980-02-20");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Job bean = new Job();
		BeanUtils.populate(bean, map);
		
		System.out.println(bean.getName());
		System.out.println(bean.getPassword());
		System.out.println(bean.getAge());
		System.out.println(bean.getBirthday());
	}
	

}
