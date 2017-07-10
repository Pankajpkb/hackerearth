package com.hackerearth.algorithms.sort;

import java.util.Scanner;

/**
 * Insertion sort is based on the idea that one element from the input elements
 * is consumed in each iteration to find its correct position i.e, the position
 * to which it belongs in a sorted array.
 * 
 * It iterates the input elements by growing the sorted array at each iteration.
 * It compares the current element with the largest value in the sorted array.
 * If the current element is greater, then it leaves the element in its place
 * and moves on to the next element else it finds its correct position in the
 * sorted array and moves it to that position. This is done by shifting all the
 * elements, which are larger than the current element, in the sorted array to
 * one position ahead Time Complexity:
 * 
 * In worst case,each element is compared with all the other elements in the
 * sorted array. For N elements, there will be N2 comparisons. Therefore, the
 * time complexity is O(N2)
 */

/**
 * 
 * You have been given an A array consisting of N integers. All the elements in
 * this array are guaranteed to be unique. For each position i in the array A
 * you need to find the position A[i] should be present in, if the array was a
 * sorted array. You need to find this for each i
 * 
 * and print the resulting solution.
 * 
 * Input Format:
 * 
 * The first line contains a single integer N denoting the size of array A. The
 * next line contains N space separated integers denoting the elements of array
 * A
 * 
 * .
 * 
 * Output Format:
 * 
 * Print N space separated integers on a single line , where the Ith integer
 * denotes the position of A[i]
 * 
 * if this array were sorted.
 * 
 * Constraints:
 * 
 * 1≤N≤100
 * 
 * 1≤A[i]≤100
 */
public class InsertionSortDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int arr[] = new int[N], copyArr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = copyArr[i] = s.nextInt();
		}
		// Perform the insertion sort
		for (int i = 1; i < N; i++) {
			int temp = arr[i];
			int pos = i;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
					pos = j;
				}
			}
			arr[pos] = temp;
		}

		for (int i = 0; i < copyArr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (copyArr[i] == arr[j]) {
					System.out.print(j+1 + " ");
					break;
				}
			}
		}
		s.close();
	}
}
