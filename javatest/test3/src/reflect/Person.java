package reflect;

import java.util.List;

public class Person {

	public String name="aaaa";
	public Person() {
		System.out.println("Person");
	}
	
	public Person(String name) {
		System.out.println("Person name");
	}
	
	public Person(String name,int password) {
		System.out.println("Person name password");
	}
	private Person(List list) {
		System.out.println("Person List");
	}
}
