package generic;

import java.util.List;

import org.junit.Test;

import java.util.ArrayList;

public class Demo1 {
	@Test
	public static void mian(String[] args) {
		
		List list = new ArrayList();
		list.add("aa");
		Integer i = (Integer)list.get(0);
		
		List<String> list1 = new ArrayList<String>();
		list1.add("aaaa");
		String s = list1.get(0);
	}

}
