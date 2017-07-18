package com.hackerearth.algorithms.graphs;

import java.util.Scanner;

/**
 *
 *
 * Edge Existence
 * 
 * You have been given an undirected graph consisting of N nodes and M edges.
 * This graph can consist of self-loops as well as multiple edges. In addition ,
 * you have also been given Q queries. For each query , you shall be given 2
 * integers A and B. You just need to find if there exists an edge between node
 * A and node B
 * 
 * . If yes, print "YES" (without quotes) else , print "NO"(without quotes).
 * 
 * Input Format:
 * 
 * The first line consist of 2 integers N and M denoting the number of nodes and
 * edges respectively. Each of the next M lines consist of 2 integers A and B
 * denoting an undirected edge between node A and B. The next line contains a
 * single integer Q denoting the number of queries. The next Line contains 2
 * integers A and B
 * 
 * denoting the details of the query.
 * 
 * Output Format
 * 
 * Print Q lines, the answer to each query on a new line.
 * 
 * Constraints:
 * 
 * 1≤N≤103
 * 
 * 1≤M≤103
 * 
 * 1≤A,B≤N
 * 
 * 1≤Q≤103
 **/
public class EdgeExistenceUsingArrayDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // Number of nodes
		int M = s.nextInt(); // Number of edges
		int[][] adjacencyMatrix = new int[N+1][N+1]; //Using N+1 matrix as the position of node is to be represented using array index.
		
		for (int i = 0; i < M; i++) {
			int x = s.nextInt();
			int y = s.nextInt();	
			adjacencyMatrix[x][y] = adjacencyMatrix[y][x] = 1; //As it is an undirected graph
		}
		
		int Q = s.nextInt();
		for (int i = 0; i < Q; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			if(adjacencyMatrix[a][b]>0){
				System.out.println("YES");	//The path exists in the adjacency matrix
			}else{
				System.out.println("NO");
			}
		}
		s.close();
	}
}
