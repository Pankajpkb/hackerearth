package com.hackerearth.algorithms.sort;

import java.util.Scanner;

/**
 *
 * In Counting sort, the frequencies of distinct elements of the array to be
 * sorted is counted and stored in an auxiliary array, by mapping its value as
 * an index of the auxiliary array.
 * 
 * Algorithm:
 * 
 * Let's assume that, array A of size N
 * 
 * needs to be sorted.
 * 
 * Initialize the auxillary array Aux[]
 * 
 * as 0. Note: The size of this array should be ≥max(A[]) . Traverse array A and
 * store the count of occurrence of each element in the appropriate index of the
 * Aux array, which means, execute Aux[A[i]]++ for each i, where i ranges from
 * [0,N−1] . Initialize the empty array sortedA[] Traverse array Aux and copy i
 * into sortedA for Aux[i] number of times where 0≤i≤max(A[])
 * 
 * .
 * 
 * Note: The array A can be sorted by using this algorithm only if the maximum
 * value in array A is less than the maximum size of the array Aux. Usually, it
 * is possible to allocate memory up to the order of a million (106). If the
 * maximum value of A
 * 
 * exceeds the maximum memory- allocation size, it is recommended that you do
 * not use this algorithm. Use either the quick sort or merge sort algorithm.
 *  
 **/

/**
 *
 * You have been given an integer array A of size N. Each element of the array
 * ranges between 1 and 105
 * 
 * . You need to find the frequency of each distinct element of the array. The
 * elements need to be present in the output in ascending order. You need to
 * print the value and then frequency of each distinct element.
 * 
 * Input Format:
 * 
 * The first line contains a single integer N denoting the size of the array.
 * The next line contains N
 * 
 * space separated integers, denoting the elements of the array.
 * 
 * Output Format
 * 
 * For each distinct integer, print its value and then frequency in a new line.
 * The distinct integers should appear in the output in ascending order.
 * 
 * Constraints
 * 
 * 1≤N≤100
 * 
 * 1≤A[i]≤100
 **/
public class CountingSortDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		int sortedA[] = new int[N];
		int Aux[] = null;
		// Perform counting sort
		countingSort(A, Aux, sortedA);

		s.close();
	}

	private static void countingSort(int[] A, int[] Aux, int[] sortedA) {
		int k = 0;
		// Find the maximum value
		for (int i = 0; i < A.length; i++)
			k = Math.max(A[i], k);

		Aux = new int[k + 1];
		for (int i = 0; i < A.length; i++)
			Aux[A[i]]++;

		int j = 0;
		for (int i = 0; i < Aux.length; i++) {
			int tempCount = Aux[i];
			while (tempCount!= 0) {
				sortedA[j++] = i;
				tempCount--;
			}
		}
		
		//Printing the desired output
		for (int i = 0; i < sortedA.length; i++) {
			System.out.print(sortedA[i] + " " + Aux[sortedA[i]]+"\n");
		}
	}
}
