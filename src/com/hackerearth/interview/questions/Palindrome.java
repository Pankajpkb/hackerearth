package com.hackerearth.interview.questions;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();				

		System.out.println("Checking if the number is palindrome");
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		if(str == null)
			return false;
		int length = str.length();
		for(int i = 0; i <length/2; i++) {
			if(str.charAt(i) != str.charAt(length-i-1))
				return false;
		}
		return true;
	}

}
