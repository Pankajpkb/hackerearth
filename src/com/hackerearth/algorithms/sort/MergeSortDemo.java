package com.hackerearth.algorithms.sort;

import java.util.Scanner;

/**
 * 
 * Merge sort is a divide-and-conquer algorithm based on the idea of breaking
 * down a list into several sub-lists until each sublist consists of a single
 * element and merging those sublists in a manner that results into a sorted
 * list.
 * 
 * Idea:
 * 
 * Divide the unsorted list into N
 * 
 * sublists, each containing 1 element. Take adjacent pairs of two singleton
 * lists and merge them to form a list of 2 elements. N will now convert into
 * N/2
 * 
 * lists of size 2. Repeat the process till a single sorted list of obtained.
 * 
 * While comparing two sublists for merging, the first element of both lists is
 * taken into consideration. While sorting in ascending order, the element that
 * is of a lesser value becomes a new element of the sorted list. This procedure
 * is repeated until both the smaller sublists are empty and the new combined
 * sublist comprises all the elements of both the sublists.
 * 
 **/

/**
 * Given an array A on size N, you need to find the number of ordered pairs
 * (i,j) such that i<j and A[i]>A[j]
 * 
 * .
 * 
 * Input: First line contains one integer, N , size of array. Second line
 * contains N space separated integers denoting the elements of the array A
 * 
 * .
 * 
 * Output: Print the number of ordered pairs (i,j) such that i<j and A[i]>A[j]
 * 
 * .
 * 
 * Constraints: 1≤N≤106
 * 
 * 1≤A[i]≤106
 */
public class MergeSortDemo {
	
	static int pairCount =0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i]=s.nextInt();
		}
		
		//Perform merge sort
		mergeSort(A, 0, N-1);
		System.out.println(pairCount);
		s.close();
	}

	private static void mergeSort(int[] A, int start, int end) {
		if(start < end ){
			int mid = (start + end)/2;
			mergeSort(A, start, mid);
			mergeSort(A, mid+1,end);
			
			//merge both parts
			merge(A, start, mid, end);
		}
	}

	private static void merge(int[] A, int start, int mid, int end) {
		//stores the starting positions of both parts in temporary variable
		int p = start; int q = mid+1;
		int Arr[] = new int[end-start+1], k=0;
		
		for (int i = start; i <= end; i++) {
			if(p>mid)
				Arr[k++] = A[q++];
			else if(q > end){
				Arr[k++] = A[p++];
			}else if(A[p] <= A[q])
				Arr[k++] = A[p++];
			else{
				pairCount+= mid-p+1;	// Consider {1,4,5,6} and {2,3,7,9} if 4>2 => 5,6> 2.
				Arr[k++] = A[q++];
			}
		}
		
		for (p = 0; p < k; p++) {
			A[start++] = Arr[p];
		}
		
	}
}
