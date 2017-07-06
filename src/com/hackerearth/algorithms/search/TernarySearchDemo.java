package com.hackerearth.algorithms.search;

import java.util.Scanner;

public class TernarySearchDemo {

	/**
	 * 
	 * You have been given an Unimodal function: f(x)=2x^2−12x+7 with N
	 * intervals. For each interval you will be given two integer values l and r
	 * , where l≤r and you need to find the minimum value of f(x) where x will
	 * be in the range [l,r] (both inclusive). Input: The first line will
	 * consists of one integer N denoting the number of intervals. In next N
	 * lines, each line contains 2 space separated integers, l and r denoting
	 * the range of interval.
	 * 
	 * Output: Print N lines, where ith line denotes the minimum value of f(x),
	 * where x will be in range [li,ri]
	 * 
	 * 
	 * .
	 * 
	 * Constraints: 1≤N≤10^5
	 * 
	 * −10^6≤l≤r≤10^6
	 */

	/* IMPORTANT: Multiple classes and nested static classes are supported */

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i][0] = s.nextInt();
			arr[i][1] = s.nextInt();
		}

		for (int i = 0; i < N; i++) {
			System.out.println(calculateMinimum(arr[i][0], arr[i][1]));
		}
		s.close();
	}

	private static double func(double x) {
		return 2 * x * x - 12 * x + 7;
	}

	private static long calculateMinimum(double start, double end) {
		double l = start;
		double r = end;

		for (int i = 0; i < 100; i++) {
			double mid1 = (l*2+r)/3;
			double mid2 = (l+2*r)/3;
			if (func(mid1) < func(mid2))
				r = mid2;
			else
				l = mid1;
		}

		double x = l;
		return (long)Math.round(func(x));

	}

}
