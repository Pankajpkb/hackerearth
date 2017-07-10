package com.hackerearth.algorithms.sort;

import java.util.Random;
import java.util.Scanner;

/**
 * Quick sort is based on the divide-and-conquer approach based on the idea of
 * choosing one element as a pivot element and partitioning the array around it
 * such that: Left side of pivot contains all the elements that are less than
 * the pivot element Right side contains all elements greater than the pivot
 * 
 * It reduces the space complexity and removes the use of the auxiliary array
 * that is used in merge sort. Selecting a random pivot in an array results in
 * an improved time complexity in most of the cases.
 * 
 */

/**
 * You have been given an array A of size N.This array contains integers ranging
 * from 1 to 109
 * 
 * . You need to sort the contents of this array by their value and then print
 * the contents of it.
 * 
 * Input Format:
 * 
 * The first line contains a single integers N denoting the size of the array.
 * The next line contains N
 * 
 * space separated integers denoting the contents of the array.
 * 
 * Output Format:
 * 
 * Print N
 * 
 * space separated integers, i.e. the final sorted array.
 * 
 * Constraints:
 * 
 * 1≤N≤106
 * 
 * 1≤A[i]≤109
 *
 */

public class QuickSortDemo {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		// Perform quick sort
		quickSort(A, 0, N - 1);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}

	private static void quickSort(int[] A, int start, int end) {
		if (start < end) {
			int pivot = partition(A,start,end);
			quickSort(A,start,pivot-1);
			quickSort(A,pivot+1,end);
		}
	}

	private static int partition(int[] A, int start, int end) {
		Random random = new Random();
		int pivot = random.nextInt(end);
		System.out.println(pivot);
		int pivotIndex = start;
		
		for (int i = start; i < end; i++) {
			if(A[i]<=pivot){
				int temp = A[i];
				A[i] = A[pivotIndex];
				A[pivotIndex] = temp;
				pivotIndex++;
			}
		}
		
		int temp = A[end];
		A[end] =A[pivotIndex];
		A[pivotIndex] = temp;
		return pivotIndex;
	}
}
