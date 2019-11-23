package com.hackerearth.interview.questions;

import java.util.Scanner;

/*
 * 
 *Convert an integer number to equivalent Roman representation
 **/
public class IntegerToRoman {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		System.out.println(convertToRoman(num));
	}
	
	private static String convertToRoman(int num) {
		String[] thousands = {"","M","MM","MMM"};
		String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] units = {"","I","II","III","IV","V","VI","VII","VIII","XI"};
		
		return thousands[num/1000] +
				hundreds[(num%1000)/100] +
				tens[(num%100)/10] +
				units[num%10];
	}

}
