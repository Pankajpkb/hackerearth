package com.hackerearth.algorithms.search;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;


public class BinarySearchDemo{
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */
        
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = s.nextInt();
        }
        Arrays.sort(A);
        
        int q = s.nextInt();
        int[] x = new int[q];
        
        for (int j = 0; j < q; j++) {
            x[j] = s.nextInt();
        }
        
        //Perform the binary search and print the rank for each input query
        for (int k = 0; k < q; k++) {
            System.out.println(findRank(0,N-1,A,x[k]));
        }
        s.close();
    }
    
    static int findRank(int low, int high, int[] array, int key){
        
        while(low <= high){
        	int mid = (low +high)/2;
        	if(key < array[mid]){
                high = mid-1;
            }else if(key > array[mid]){
            	low = mid+1;
            }else {
                return mid+1;
            }
        }
        return -1;
    }
}
