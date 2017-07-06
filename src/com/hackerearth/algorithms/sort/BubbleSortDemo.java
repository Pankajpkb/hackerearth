package com.hackerearth.algorithms.sort;

import java.util.Scanner;

public class BubbleSortDemo {

	/**
	 * 
	 * You have been given an array A of size N
	 * 
	 * . you need to sort this array non-decreasing order using bubble sort.
	 * However, you do not need to print the sorted array . You just need to
	 * print the number of swaps required to sort this array using bubble sort
	 * 
	 * Input Format
	 * 
	 * The first line consists of a single integer N denoting size of the array.
	 * The next line contains N
	 * 
	 * space separated integers denoting the elements of the array.
	 * 
	 * Output Format Print the required answer in a single line
	 * 
	 * Constrains 1≤N≤100
	 * 
	 * 1≤a[i]≤100
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}
		int swaps =0;
		// Perform Bubble sort
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N - j - 1; k++) {
				if (arr[k] > arr[k+1]) {
					int temp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = temp;
					swaps++;
				}
			}
		}
		System.out.println(swaps);
		s.close();
	}

}
