package com.hackerearth.basicprogramming.complexity;

import java.math.BigInteger;
import java.util.Scanner;

public class AplusB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			BigInteger A = in.nextBigInteger();
			BigInteger B = in.nextBigInteger();
			System.out.println(A.add(B));
		}
		in.close();
	}

}