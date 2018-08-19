package com.enumeration2;

import org.junit.Test;


public class Demo1 {
	@Test
	public void test() {
		print(Grade.B);
	}

	public void print(Grade g) {
		String value = g.localValue();
		System.out.println(value);
	}
	@Test
	public void test2() {
		System.out.println(Grade.C.name());
		System.out.println(Grade.B.ordinal());
		
		String str = "C";
		Grade g =  Grade.valueOf(Grade.class,str);
		System.out.println(g);
	}
}

//class Grade{
//	private Grade() {}
//	public static final Grade A = new Grade();
//}


enum Grade{
	A("100-90"){
		public String localValue() {
			return "��";
		}
	},
	B("89-80"){
		public String localValue() {
			return "��";
		}
	},
	C("79-70"){
		public String localValue() {
			return "��";
		}
	},
	D("69-60"){
		public String localValue() {
			return "��";
		}
	}, 
	E("failed"){
		public String localValue() {
			return "������";
		}
	};  //object
	
	private String value;
	private Grade(String value) {
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	
	public abstract String localValue() ;
}