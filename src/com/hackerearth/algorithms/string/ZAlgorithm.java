package com.hackerearth.algorithms.string;

import java.util.Scanner;

/**
 * 
 *
 * Count Substring Occurrences
 * 
 * Given 2 Strings C,S. Find the number of occurrences of C in S. Length of S is
 * N, length of C is M
 * 
 * .
 * 
 * Input:
 * 
 * Given 2 Strings C,S
 * 
 * .
 * 
 * Output:
 * 
 * Print the number of occurrences of C in S
 * 
 * .
 * 
 * Constraints:
 * 
 * 1≤M≤N≤105 .
 * 
 * Sample Input: abc abcabdabc Sample Output: 2
 * 
 **/
public class ZAlgorithm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String pattern = s.next();
		String test = s.next();

		System.out.println(countSubstring(pattern.toCharArray(), test.toCharArray()));

		s.close();
	}

	 private static int[] calculateZ(char input[]) {
	        int Z[] = new int[input.length];
	        int left = 0;
	        int right = 0;
	        for(int k = 1; k < input.length; k++) {
	            if(k > right) {
	                left = right = k;
	                while(right < input.length && input[right] == input[right - left]) {
	                    right++;
	                }
	                Z[k] = right - left;
	                right--;
	            } else {
	                //we are operating inside box
	                int k1 = k - left;
	                //if value does not stretches till right bound then just copy it.
	                if(Z[k1] < right - k + 1) {
	                    Z[k] = Z[k1];
	                } else { //otherwise try to see if there are more matches.
	                    left = k;
	                    while(right < input.length && input[right] == input[right - left]) {
	                        right++;
	                    }
	                    Z[k] = right - left;
	                    right--;
	                }
	            }
	        }
	        return Z;
	    }

	    
	    private static int countSubstring(char pattern[],char text[]) {
	        char newString[] = new char[text.length + pattern.length + 1];
	        int i = 0,count =0;
	        for(char ch : pattern) {
	            newString[i] = ch;
	            i++;
	        }
	        newString[i] = '$';
	        i++;
	        for(char ch : text) {
	            newString[i] = ch;
	            i++;
	        }
	       
	        int Z[] = calculateZ(newString);

	        for(i = 0; i < Z.length ; i++) {
	            if(Z[i] == pattern.length) {
	                count++;
	            }
	        }
	        return count;
	}

}
