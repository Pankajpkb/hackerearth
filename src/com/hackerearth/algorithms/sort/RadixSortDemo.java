package com.hackerearth.algorithms.sort;

import java.util.Scanner;

/**
 * 
 * Prerequisite: Counting Sort
 * 
 * QuickSort, MergeSort, HeapSort are comparison based sorting algorithms.
 * CountSort is not comparison based algorithm. It has the complexity of O(n+k)
 * , where k is the maximum element of the input array. So, if k is O(n)
 * ,CountSort becomes linear sorting, which is better than comparison based
 * sorting algorithms that have O(nlogn) time complexity. The idea is to extend
 * the CountSort algorithm to get a better time complexity when k goes O(n2).
 * Here comes the idea of Radix Sort.
 * 
 * Algorithm: For each digit i where i varies from the least significant digit
 * to the most significant digit of a number Sort input array using countsort
 * algorithm according to ith digit.
 * 
 * We used count sort because it is a stable sort.
 */

/**
 *
 *
 *
 **/
public class RadixSortDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] A = new int[N];
				
		for (int i = 0; i < N; i++) {
			A[i] = s.nextInt();
		}
		
		
		//Find maximum
		int max = A[0];
		for (int i = 0; i < A.length; i++) {
			max = Math.max(A[i], max);
		}
		
		//Perform radix sort
		radixSort(A,N,max);
		s.close();
	}

	private static void radixSort(int[] A, int n, int max) {
		int mul =1;
		while(max > 0){
			countSort(A,n,mul);
			mul*=10;
			max/=10;
		}
	}

	private static void countSort(int[] A, int n, int place) {
		
		int i,range=10,freq[]= new int[range];         //range for integers is 10 as digits range from 0-9
        int output[] = new int[n];
        for(i=0;i<n;i++)
                freq[(A[i]/place)%range]++;
        for(i=1;i<range;i++)
                freq[i]+=freq[i-1];
        for(i=n-1;i>=0;i--)
        {
                output[freq[(A[i]/place)%range]-1]=A[i];
                freq[(A[i]/place)%range]--;
        }
        for(i=0;i<n;i++){
                A[i]=output[i];
                System.out.print(A[i] + " ");
        }
        System.out.println();
	}
}
