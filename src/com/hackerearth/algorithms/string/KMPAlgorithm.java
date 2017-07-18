package com.hackerearth.algorithms.string;

import java.util.Scanner;

/***
 *
 *
 * Apply KMP
 * 
 * Given 2 strings, P and T, find the number of occurrences of P in T
 * 
 * .
 * 
 * Input:
 * 
 * First line contains string P , and second line contains the string T
 * 
 * .
 * 
 * Output:
 * 
 * Print a single integer, the number of occurrences of P in T
 * 
 * .
 * 
 * Constraints:
 * 
 * 1≤|P|≤|T|≤105
 * 
 * 
 * Sample Input: sda sadasda Sample Output: 1
 *
 **/
public class KMPAlgorithm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String P = s.next();
		String T = s.next();

		System.out.println(KMPStringMatch(P, T));
		s.close();
	}

	private static int KMPStringMatch(String P, String T) {
		int count = 0;
		// Compute the prefix function
		int[] prefix = getPrefixArray(P);
		int i = 0;
		int j = 0;
		while (i < T.length()) {
			if (T.charAt(i) == P.charAt(j)) {
				i++;
				j++;
				if (j == P.length()) {
					count++;
					j = prefix[j - 1];
				}
			} else {
				if (j != 0) {
					j = prefix[j - 1];
				} else {
					i++;
				}
			}
		}
		return count;
	}

	private static int[] getPrefixArray(String P) {
		int[] prefix = new int[P.length()];
		prefix[0] = 0;

		for (int i = 1; i < prefix.length; i++) {
			int j = prefix[i - 1];
			while (j > 0 && P.charAt(i) != P.charAt(j))
				j = prefix[j - 1];
			if (P.charAt(i) == P.charAt(j))
				j++;
			prefix[i] = j;
		}
		return prefix;
	}

}
