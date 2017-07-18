package com.hackerearth.algorithms.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Sort the Substring
 * 
 * Given a string S , and two numbers N, M - arrange the characters of string in
 * between the indexes N and M
 * 
 * (both inclusive) in descending order. (Indexing starts from 0).
 * 
 * Input Format: First line contains T - number of test cases. Next T lines
 * contains a string(S) and two numbers(N, M
 * 
 * ) separated by spaces.
 * 
 * Output Format: Print the modified string for each test case in new line.
 * 
 * Constraints:
 * 
 * 1≤T≤1000
 * 
 * 1≤|S|≤10000 // |S| denotes the length of string. 0≤N≤M<|S| S∈[a,z]
 * 
 **/
public class SortTheSubstring2 { //Using in-built utility methods
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			String str = s.next();
			int N = s.nextInt();
			int M = s.nextInt();

			sortSubstring(str, N, M);
		}
		s.close();
	}

	private static void sortSubstring(String str, int n, int m) {
		char [] subChar = str.substring(n, m + 1).toCharArray();
		Arrays.sort(subChar);

		StringBuffer sub = new StringBuffer(String.valueOf(subChar));
		str = str.substring(0, n) + sub.reverse() + str.substring(m + 1);

		System.out.println(str);
	}

}
