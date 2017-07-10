package com.hackerearth.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * Bucket sort is a comparison sort algorithm that operates on elements by
 * dividing them into different buckets and then sorting these buckets
 * individually. Each bucket is sorted individually using a separate sorting
 * algorithm or by applying the bucket sort algorithm recursively. Bucket sort
 * is mainly useful when the input is uniformly distributed over a range.
 **/

/**
 *
 *
 *
 **/
public class BucketSortDemo {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for(int i=0;i<N;i++){
			A[i] = s.nextInt();
		}
		
		//Perform BucketSort
		bucketSort(A,N);
		s.close();
		
	}

	private static void bucketSort(int[] A, int n) {
		List<ArrayList<Integer>> bucket= new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			bucket.add(i,new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			int bi = n*A[i];
			if(bucket.get(bi).isEmpty()){
				bucket.add(bi,A[i]);
			}
		}
		for (int i = 0; i < n; i++) {
			Arrays.sort(bucket.);bucket.add(bi,A[i]);
		}
		
		
	}
}
