package com.hackerearth.algorithms.sort;

import java.util.Scanner;

public class SelectionSortDemo {
	/*
	 * Consider an Array a of size N Iterate from 1 to N In ith iteration select
	 * the ith minimum and swap it with a[i]
	 * 
	 * You are given an array a , size of the array N and an integer x. Follow
	 * the above algorithm and print the state of the array after x
	 * 
	 * iterations have been performed.
	 * 
	 * Input Format
	 * 
	 * The first line contains two integer N and x denoting the size of the
	 * array and the steps of the above algorithm to be performed respectively.
	 * The next line contains N
	 * 
	 * space separated integers denoting the elements of the array.
	 * 
	 * Output Format
	 * 
	 * Print N space separated integers denoting the state of the array after x
	 * 
	 * steps
	 * 
	 * Constraints
	 * 
	 * 1≤N≤100
	 * 
	 * 1≤a[i]≤100
	 * 
	 * 1≤x≤N
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int x = s.nextInt();
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();
		}
		
		//Perform selection sort based upon x iterations
		for (int j = 0; j < x; j++) {
			int minimum = j;
			for (int k = j; k < arr.length; k++) {
				if(arr[minimum] > arr[k]){
					minimum = k;
				}		
			}
			int temp = arr[j];
			arr[j] = arr[minimum];
			arr[minimum] = temp;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print( arr[i] + " ");
		}
		
		s.close();
	}
}
