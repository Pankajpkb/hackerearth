package com.hackerearth.algorithms.string;

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
public class SortTheSubstring {
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
		char [] sub = str.substring(n, m + 1).toCharArray();
		mergeSort(sub,0,sub.length-1);

		str = str.substring(0, n) + String.copyValueOf(sub) + str.substring(m + 1);

		System.out.println(str);
	}

	private static void mergeSort(char[] A, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(A, start, mid);
			mergeSort(A, mid + 1, end);

			// merge both parts
			merge(A, start, mid, end);
		}
	}

	private static void merge(char[] A, int start, int mid, int end) {
		// stores the starting positions of both parts in temporary variable
		int p = start;
		int q = mid + 1;
		char Arr[] = new char[end - start + 1], k = 0;

		for (int i = start; i <= end; i++) {
			if (p > mid)
				Arr[k++] = A[q++];
			else if (q > end) {
				Arr[k++] = A[p++];
			} else if (A[p] <= A[q])
				Arr[k++] = A[q++];
			else {
				Arr[k++] = A[p++];
			}
		}

		for (p = 0; p < k; p++) {
			A[start++] = Arr[p];
		}

	}
}
