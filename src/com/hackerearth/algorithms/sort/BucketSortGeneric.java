package com.hackerearth.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Bucket sort is a comparison sort algorithm that operates on elements by
 * dividing them into different buckets and then sorting these buckets
 * individually. Each bucket is sorted individually using a separate sorting
 * algorithm or by applying the bucket sort algorithm recursively. Bucket sort
 * is mainly useful when the input is uniformly distributed over a range.
 **/


public class BucketSortGeneric {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		// Perform BucketSort
		bucketSort(A, N);
		for (int i : A) {
			System.out.print(i + " ");
		}
		s.close();

	}

	@SuppressWarnings("unchecked")
	private static void bucketSort(int[] A, int n) {

		// Find max element
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}

		int bucketNumber = (int) Math.ceil(Math.sqrt(max));
		List<Integer> bucket[] = new ArrayList[bucketNumber + 1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n; i++) {
			int bi = (int) Math.sqrt(A[i]);
			bucket[bi].add(A[i]);
		}

		for (int i = 0; i <= bucketNumber; i++) {
			Collections.sort(bucket[i]);
		}

		int index = 0;
		for (int i = 0; i <= bucketNumber; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				A[index++] = bucket[i].get(j);
			}
		}
	}

}
