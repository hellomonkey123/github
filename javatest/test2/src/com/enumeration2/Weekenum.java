package com.enumeration2;

import org.junit.Test;

public class Weekenum {
	@Test
	public void test() {
		print(Week1.FRI);
	}
	
	public void print(Week1 g) {
		String value = g.getValue();
		System.out.println(value);
	}

}

enum Week1{
	MON("星期一"),TUE("星期二"),WED("星期三"),
	THU("星期四"),FRI("星期五"),SAT("星期六"),SUN("星期日");
	
	private String value;
	private  Week1(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}