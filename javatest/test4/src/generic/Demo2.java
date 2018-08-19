package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo2 {
	
	@Test
	public void test1() {
		
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
		
		for (String s:list) {
			
			System.out.println(s);
		}
	}

	@Test
	public void test2() {

		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		map.put(3, "ccc");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while(it.hasNext()) {
			
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + "=" +value);
		}
		
		for(Map.Entry<Integer, String> s:map.entrySet()) {
			int key = s.getKey();
			String value = s.getValue();
			
			System.out.println(key + "=" +value);
		}
		}
		
}
