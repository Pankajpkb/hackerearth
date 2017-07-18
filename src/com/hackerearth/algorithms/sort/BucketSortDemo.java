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
/**
 *
 * You have been given an array A of size N
 * 
 * . The array contains integers. You need to divide the elements of this array
 * into buckets on the basis of the number of set bits in its binary
 * representation. You need to then print the content of each bucket in a new
 * line. The buckets should appear in the output in ascending order, i.e the
 * bucket that stands for lesser number of set bits should appear before any
 * other bucket which stands for higher number of set bits.The elements of each
 * bucket should appear in ascending order too. That is if 2 integers appear in
 * the same bucket, the one with the lower value should appear in the bucket
 * list before the one with higher value.
 * 
 * Input Format:
 * 
 * The first line contains a single integer N denoting the size of the array.
 * The next line contains N
 * 
 * space separated integers denoting the elements of the array.
 * 
 * Output Format:
 * 
 * The output should contain the number of lines equal to the number of distnict
 * bucket. If a bucket remains empty, it should not appear in the output. Print
 * the contents of each bucket on a new line.
 * 
 * Constraints:
 * 
 * 1≤N≤103
 * 
 * 1≤A[i]≤103
 * 
 * Note
 * 
 * It is guaranteed that each array element is unique.
 *
 **/

public class BucketSortDemo {

	public static void main(String args[] ) throws Exception {
	    
        Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}

		// Perform BucketSort
		bucketSort(A, N);
		s.close();
    }
    
    @SuppressWarnings("unchecked")
	private static void bucketSort(int[] A, int n) {

		// Find max element
		int max = Integer.bitCount(A[0]);
		for (int i = 1; i < A.length; i++) {
			max = Math.max(max, Integer.bitCount(A[i]));
		}

		int bucketNumber = max;
		List<Integer> bucket[] = new ArrayList[bucketNumber + 1];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();
			System.out.println(bucket[i]);
		}

		for (int i = 0; i < A.length; i++) {
			int bi = Integer.bitCount(A[i]);
			bucket[bi].add(A[i]);
		}

		for (int i = 0; i < bucketNumber; i++) {
			Collections.sort(bucket[i]);
		}

		
		for (int i = 0; i <= bucketNumber; i++) {
			if(!bucket[i].isEmpty()){
				for (Integer val : bucket[i]) {
					System.out.print(val+ " ");
				}
				System.out.println();
			}
		}
	}

}
