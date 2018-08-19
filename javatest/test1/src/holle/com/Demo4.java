package holle.com;

import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo4 {
	@Test
	public void test1() {
		Map map = new HashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = (String)map.get(key);
			System.out.println(key+" = "+value);
			}
	}
	@Test
	public void test2() {
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		for(Object obj : map.keySet()) {
			String key = (String)obj;
			String value = (String)map.get(key);
			System.out.println(key+" = "+value);
			}
	}
	@Test
	public void test3() {
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			String key = (String) entry.getKey();
			String value = (String)entry.getValue();
			System.out.println(key+" = "+value);
			}
	}
	@Test
	public void test4() {
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");

		for(Object obj : map.entrySet()) {
			Map.Entry entry = (Entry) obj;
			String key = (String) entry.getKey();
			String value = (String)entry.getValue();
			System.out.println(key+" = "+value);
		}
	}
	
	public void test5() {
		Map map = new LinkedHashMap();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");

		for(Object obj : map.entrySet()) {
			Map.Entry entry = (Entry) obj;
			String key = (String) entry.getKey();
			String value = (String)entry.getValue();
			System.out.println(key+" = "+value);
		}
	}//增强for循环不能改变数组的值，一般用于数据的读取

}
