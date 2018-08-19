package holle.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.omg.CORBA.PRIVATE_MEMBER;

public class Demo2 {
	private Demo1 p;
	@Before
	public void before() {
		p = new Demo1();
	}
	@Test
	public void testrun() {
		
		p.run();
	}
	@After
	public void after() {
		p= null;
	}
	@Test
	public void testeat() {
		
		p.eat();
	}
}
