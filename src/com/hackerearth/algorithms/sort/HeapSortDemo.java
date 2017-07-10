package com.hackerearth.algorithms.sort;

import java.util.Scanner;

/**
 * 
 * Heap Sort
 * 
 * Heaps can be used in sorting an array. In max-heaps, maximum element will
 * always be at the root. Heap Sort uses this property of heap to sort the
 * array.
 * 
 * Consider an array Arr
 * 
 * which is to be sorted using Heap Sort.
 * 
 * Initially build a max heap of elements in Arr
 * 
 * . The root element, that is Arr[1] , will contain maximum element of Arr.
 * After that, swap this element with the last element of Arr and heapify the
 * max heap excluding the last element which is already in its correct position
 * and then decrease the length of heap by one. Repeat the step 2, until all the
 * elements are in their correct position.
 * 
 */

/**
 *
 * You are given a list of amount of money of T
 * 
 * people, one by one. After each element in the list print the top 3 richest
 * people's amount of money.
 * 
 * Input: First line contains an integer, T , number of queries. Next T lines
 * contains an integer each, X. ith query contains amount of money ith
 * 
 * person have.
 * 
 * Output: For each query, print the top 3 richest people's amount of money in
 * the town and if there are less than 3 people in town then print -1.
 * 
 * Constraints: 1≤T≤105
 * 
 * 1≤X≤106
 *
 **/
public class HeapSortDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < A.length; i++) {
			A[i] = s.nextInt();
			if (i < 2) {
				System.out.println("-1");
			} else {
				heapsort(A, i + 1);
				System.out.println(A[i] + " " + A[i - 1] + " " + A[i - 2]);
			}
		}
		s.close();
	}

	private static void heapsort(int[] A, int n) {

		// Rearrange Array
		for (int i = n / 2 - 1; i >= 0; i--) {
			max_heapify(A, n, i);
		}

		// Extracting elements
		for (int j = n - 1; j >= 0; j--) {
			int temp = A[0];
			A[0] = A[j];
			A[j] = temp;
			max_heapify(A, j, 0);
		}

	}

	private static void max_heapify(int[] A, int n, int i) {
		int largest = i;
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && A[l] > A[largest])
			largest = l;

		// If right child is larger than largest so far
		if (r < n && A[r] > A[largest])
			largest = r;

		// If largest is not root
		if (largest != i) {
			int swap = A[i];
			A[i] = A[largest];
			A[largest] = swap;

			// Recursively max_heapify the affected sub-tree
			max_heapify(A, n, largest);
		}
	}
}
