package com.hackerearth.algorithms.string;

import java.util.Scanner;

public class ManachersAlgorithm {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String test = s.next();
		longestPalindromeSubstring(test.toCharArray());
		s.close();
	}

	private static void longestPalindromeSubstring(char[] input) {
		int index = 0;
		// pre-processing the input to convert it into type abc -> $a$b$c$ to
		// handle even length cases.
		// Total size will be 2*n + 1 of this new array.
		char newInput[] = new char[2 * input.length + 1];
		for (int i = 0; i < newInput.length; i++) {
			if (i % 2 != 0) {
				newInput[i] = input[index++];
			} else {
				newInput[i] = '$';
			}
		}

		// create temporary array for holding largest palindrome at every point.
		int T[] = new int[newInput.length];
		int start = 0;
		int end = 0;

		// here i is the center.
		for (int i = 0; i < newInput.length;) {
			// expand around i. See how far we can go.
			while (start > 0 && end < newInput.length - 1 && newInput[start - 1] == newInput[end + 1]) {
				start--;
				end++;
			}
			// set the longest value of palindrome around center i at T[i]
			T[i] = end - start + 1;

			// Current palindrome is proper suffix of input.
			// Need not proceed further. Break out of loop.
			if (end == T.length - 1) {
				break;
			}

			// Mark newCenter to be either end or end + 1 depending on if we
			// dealing with even or old number input.
			int newCenter = end + (i % 2 == 0 ? 1 : 0);

			for (int j = i + 1; j <= end; j++) {

				// i - (j - i) is left mirror. Its possible left mirror might go
				// beyond current center palindrome. So take minimum
				// of either left side palindrome or distance of j to end.
				T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
				// Only proceed if we get case 3. This check is to make sure we
				// do not pick j as new center for case 1 or case 4
				// As soon as we find a center lets break out of this inner
				// while loop.
				if (j + T[i - (j - i)] / 2 == end) {
					newCenter = j;
					break;
				}
			}
			// make i as newCenter. Set right and left to atleast the value we
			// already know should be matching based of left side palindrome.
			i = newCenter;
			end = i + T[i] / 2;
			start = i - T[i] / 2;
		}

		// find the max palindrome in T and return it.
		int max = Integer.MIN_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		for (int i = 0; i < T.length; i++) {
			int val;
			val = T[i] / 2;
			if (max < val) {
				max = val;
				maxIndex = i/2;
			}
		}
		
		char[] maxPalindrome = new char[max];
		int startOfPalindrome = maxIndex - max/2;
		for (int i = 0; i < maxPalindrome.length; i++) {
			maxPalindrome[i] = input[startOfPalindrome++];
		}
		
		System.out.println(max);
		System.out.println(maxPalindrome);

	}

}
