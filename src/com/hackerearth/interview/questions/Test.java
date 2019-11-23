package com.hackerearth.interview.questions;

public class Test {

	public static void main(String[] args) {
		String str2 = new String("Java").intern();
		String str = "Java";
		System.out.println(str == str2 );
	}

}
