package com.hackerearth.algorithms.greedy_algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * What is a 'Greedy algorithm'?
 * 
 * A greedy algorithm, as the name suggests, always makes the choice that seems
 * to be the best at that moment. This means that it makes a locally-optimal
 * choice in the hope that this choice will lead to a globally-optimal solution.
 *
 **/

/**
 * 
 * 
 *
 * Being greedy for Water
 * 
 * You are given container full of water. Container can have limited amount of
 * water. You also have N
 * 
 * bottles to fill. You need to find the maximum numbers of bottles you can
 * fill.
 * 
 * Input: First line contains one integer, T , number of test cases. First line
 * of each test case contains two integer, N and X, number of bottles and
 * capacity of the container. Second line of each test case contains N
 * 
 * space separated integers, capacities of bottles.
 * 
 * Output: For each test case print the maximum number of bottles you can fill.
 * 
 * Constraints: 1≤T≤100
 * 
 * 1≤N≤104 1≤X≤109 1≤capacitiesofbottles≤106
 **/

public class BasicsOfGreedyAlgorithm {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for (int i = 0; i < T; i++) {
			int N = s.nextInt(); // Number of bottles
			int X = s.nextInt(); //Capacity of container
			int bottleCapacity[]= new int[N];
			for(int j=0;j<N;j++){
				bottleCapacity[j] = s.nextInt(); //Capacity of each bottle
			}
			System.out.println(findMaxBottlesToFill(N,X,bottleCapacity));
		}
		
		s.close();
	}

	private static int findMaxBottlesToFill(int n, int x, int[] bottleCapacity) {
		Arrays.sort(bottleCapacity);
		int bottlesFilled =0;
		for (int i = 0; i < bottleCapacity.length && x>0; i++) {
			if(x>=bottleCapacity[i]){
				x -= bottleCapacity[i];
				bottlesFilled++;
			}else{
				break;
			}
		}
		return bottlesFilled;
	}
}
