package com.hackerearth.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 *
 * Depth First Search (DFS)
 * 
 * The DFS algorithm is a recursive algorithm that uses the idea of
 * backtracking. It involves exhaustive searches of all the nodes by going
 * ahead, if possible, else by backtracking.
 * 
 * Here, the word backtrack means that when you are moving forward and there are
 * no more nodes along the current path, you move backwards on the same path to
 * find nodes to traverse. All the nodes will be visited on the current path
 * till all the unvisited nodes have been traversed after which the next path
 * will be selected.
 * 
 **/

/**
 *
 *
 * Unreachable Nodes
 * 
 * You have been given a graph consisting of N nodes and M edges. The nodes in
 * this graph are enumerated from 1 to N
 * 
 * . The graph can consist of self-loops as well as multiple edges. This graph
 * consists of a special node called the head node. You need to consider this
 * and the entry point of this graph. You need to find and print the number of
 * nodes that are unreachable from this head node.
 * 
 * Input Format
 * 
 * The first line consists of a 2 integers N and M denoting the number of nodes
 * and edges in this graph. The next M lines consist of 2 integers a and b
 * denoting an undirected edge between node a and b. The next line consists of a
 * single integer x
 * 
 * denoting the index of the head node.
 * 
 * Output Format *:
 * 
 * You need to print a single integer denoting the number of nodes that are
 * unreachable from the given head node.
 * 
 * Constraints
 * 
 * 1≤N≤105
 * 
 * 1≤M≤105
 * 
 * 1≤x≤N
 * 
 * Sample Input: 10 10 8 1 8 3 7 4 7 5 2 6 10 7 2 8 10 9 2 10 5 10 2 Sample
 * Output: 0
 *
 **/
public class DepthFirstSearchDemo {
	
	@SuppressWarnings({"unchecked"})
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		List<Integer> adjacencyList[] = new ArrayList[N+1];
		
		for (int i = 0; i< adjacencyList.length;i++) { 
			adjacencyList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			adjacencyList[a].add(b);
			adjacencyList[b].add(a);
		}
		
		int headNode = s.nextInt();
		Set<Integer> reachableNodes = new HashSet<>();
		reachableNodes = findReachableNodesUsingDFS(adjacencyList, headNode, reachableNodes);
		
		System.out.println((adjacencyList.length-1) - reachableNodes.size());
		
		s.close();
	}

	private static Set<Integer> findReachableNodesUsingDFS(List<Integer>[] adjacencyList, int headNode, Set<Integer> visited) {
		visited.add(headNode);
		
		for (Integer node : adjacencyList[headNode]) {
			if(!visited.contains(node))
				findReachableNodesUsingDFS(adjacencyList, node, visited);
		}
		
		return visited;
	}
}
