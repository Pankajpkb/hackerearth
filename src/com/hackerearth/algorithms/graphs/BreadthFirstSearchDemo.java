package com.hackerearth.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * Breadth First Search (BFS)
 * 
 * There are many ways to traverse graphs. BFS is the most commonly used
 * approach.
 * 
 * BFS is a traversing algorithm where you should start traversing from a
 * selected node (source or starting node) and traverse the graph layerwise thus
 * exploring the neighbour nodes (nodes which are directly connected to source
 * node). You must then move towards the next-level neighbour nodes.
 * 
 * As the name BFS suggests, you are required to traverse the graph breadthwise
 * as follows:
 * 
 * 1.First move horizontally and visit all the nodes of the current layer 2.Move
 * to the next layer
 * 
 * 
 **/

/**
 *
 * 
 * Level Nodes
 * 
 * You have been given a Tree consisting of N nodes. A tree is a fully-connected
 * graph consisting of N nodes and N−1 edges. The nodes in this tree are indexed
 * from 1 to N. Consider node indexed 1 to be the root node of this tree. The
 * root node lies at level one in the tree. You shall be given the tree and a
 * single integer x . You need to find out the number of nodes lying on level x
 * 
 * .
 * 
 * Input Format
 * 
 * The first line consists of a single integer N denoting the number of nodes in
 * the tree. Each of the next n−1 lines consists of 2 integers a and b denoting
 * an undirected edge between node a and node b. The next line consists of a
 * single integer x
 * 
 * .
 * 
 * Output Format
 * 
 * You need to print a single integers denoting the number of nodes on level x
 * 
 * .
 * 
 * Constraints
 * 
 * 1≤N≤105
 * 
 * 1≤a,b≤N
 * 
 * Note
 * 
 * It is guaranteed that atleast one node shall lie on level x
 * 
 **/
public class BreadthFirstSearchDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // Number of nodes
		int M = N - 1; // Number of edges
		List<Integer> adjacencyList[] = new ArrayList[N + 1];

		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new ArrayList<Integer>(); // Initializing the
															// list
		}

		// Populate the list
		for (int i = 0; i < M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			adjacencyList[a].add(b);
			adjacencyList[b].add(a); // Undirected edges
		}

		int x = s.nextInt(); // Query level
		// Perform BFS to find the number of nodes at level x
		System.out.println(bfs(adjacencyList, x, 1));
		s.close();
	}

	private static int bfs(List<Integer>[] adjacencyList, int x, int start) {
		List<Integer> levelNodes = new ArrayList<>(); // List as should have
														// duplicate values and
														// ordered is preserved
		List<Integer> successor = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();

		successor.add(start); // As stated in problem node indexed 1 is the root
								// node
		visited.add(start);
		levelNodes.add(start);

		while (!successor.isEmpty()) {
			List<Integer> next = new ArrayList<>();
			int totalNodes = 0;
			for (Integer u : successor) {
				for (int i = 0; i < adjacencyList[u].size(); i++) {
					if (!visited.contains(adjacencyList[u].get(i))) {
						next.add(adjacencyList[u].get(i));
						visited.add(adjacencyList[u].get(i));
						totalNodes++;
					}

				}
			}
			successor.clear();
			successor.addAll(next);
			levelNodes.add(totalNodes);
		}
		return levelNodes.get(x - 1);
	}
}
