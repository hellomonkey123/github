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
	MON("����һ"),TUE("���ڶ�"),WED("������"),
	THU("������"),FRI("������"),SAT("������"),SUN("������");
	
	private String value;
	private  Week1(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}