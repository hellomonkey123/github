package com.enumeration;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test() {
		print(Grade.B);
	}

	public void print(Grade g) {
		String value = g.getValue();
		System.out.println(value);
	}
}

//class Grade{
//	private Grade() {}
//	public static final Grade A = new Grade();
//}


enum Grade{
	A("100-90"), B("89-80"), C("79-70"), D("69-60"), E("failed");  //object
	
	private String value;
	private Grade(String value) {
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}