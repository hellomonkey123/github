package holle.com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo3 {

	@BeforeClass
	public static void beforeclass() {
		System.out.println("beforeclass");
	}

	@Test
	public void testRun() {
		Demo1 p = new Demo1();
		p.run();
	}

	@Test
	public void testEat() {
		Demo1 p = new Demo1();
		p.eat();
	}

	@AfterClass
	public static void afterclass() {
		System.out.println("afterclass");
	}

	Integer i = 1; // ×°Ïä
	int j = i; // ²ðÏä

	public static void mian(String[] args) {
		List list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Iterator it = list.iterator();
		while(it.hasNext()) {
		int k = (Integer)it.next();  //chaixiang
		}
	}
}
