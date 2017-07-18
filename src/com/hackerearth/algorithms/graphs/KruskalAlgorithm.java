/**
 * 
 * Original Source
 * @link https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/KruskalMST.java
 * */

package com.hackerearth.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * The cost of the spanning tree is the sum of the weights of all the edges in
 * the tree. There can be many spanning trees. Minimum spanning tree is the
 * spanning tree where the cost is minimum among all the spanning trees. There
 * also can be many minimum spanning trees.
 * 
 * 
 * Minimum spanning tree has direct application in the design of networks. It is used in algorithms approximating the travelling salesman problem, multi-terminal minimum cut problem and minimum-cost weighted perfect matching. Other practical applications are:
 *	Cluster Analysis
 *  Handwriting recognition
 *  Image segmentation
 *
 **/

/***
 * Minimum spanning tree has direct application in the design of networks. It is
 * used in algorithms approximating the travelling salesman problem,
 * multi-terminal minimum cut problem and minimum-cost weighted perfect
 * matching. Other practical applications are:
 * 
 * Cluster Analysis Handwriting recognition Image segmentation
 * 
 * 
 * Sample Input: 4 5 1 2 7 1 4 6 4 2 9 4 3 8 2 3 6 Sample Output: 19
 * 
 **/
public class KruskalAlgorithm {

	private static long totalWeight = 0;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // Number of vertices in the graph
		int M = s.nextInt(); // Number of edges
		KruskalAlgorithm mst = new KruskalAlgorithm();
		Graph<Integer> graph = new Graph<Integer>(false);

		for (int i = 0; i < M; i++) {
			int node1 = s.nextInt();
			int node2 = s.nextInt();
			int weight = s.nextInt();
			graph.addEdge(node1, node2, weight);
		}

		List<Edge<Integer>> result = mst.getMST(graph);

		System.out.println(totalWeight);
		s.close();
	}

	public List<Edge<Integer>> getMST(Graph<Integer> graph) {
		List<Edge<Integer>> allEdges = graph.getAllEdges();
		EdgeComparator edgeComparator = new EdgeComparator();

		// sort all edges in non decreasing order
		Collections.sort(allEdges, edgeComparator);
		DisjointSet disjointSet = new DisjointSet();

		// create as many disjoint sets as the total vertices
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			disjointSet.makeSet(vertex.getId());
		}

		List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

		for (Edge<Integer> edge : allEdges) {
			// get the sets of two vertices of the edge
			long root1 = disjointSet.findSet(edge.getVertex1().getId());
			long root2 = disjointSet.findSet(edge.getVertex2().getId());

			// check if the vertices are in same set or different set
			// if verties are in same set then ignore the edge
			if (root1 == root2) {
				continue;
			} else {
				// if vertices are in different set then add the edge to result
				// and union these two sets into one
				resultEdge.add(edge);
				disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
				totalWeight += edge.getWeight();
			}

		}
		return resultEdge;
	}

}

class Graph<T> {

	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertex;
	boolean isDirected;

	public Graph(boolean isDirected) {
		allEdges = new ArrayList<Edge<T>>();
		allVertex = new HashMap<Long, Vertex<T>>();
	}

	public void addVertex(Vertex<T> vertex) {
		if (allVertex.containsKey(vertex.getId())) {
			return;
		}
		allVertex.put(vertex.getId(), vertex);
		for (Edge<T> edge : vertex.getEdges()) {
			allEdges.add(edge);
		}
	}

	public Vertex<T> addSingleVertex(long id) {
		if (allVertex.containsKey(id)) {
			return allVertex.get(id);
		}
		Vertex<T> v = new Vertex<T>(id);
		allVertex.put(id, v);
		return v;
	}

	public Vertex<T> getVertex(long id) {
		return allVertex.get(id);
	}

	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}

	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> vertex1 = null;
		if (allVertex.containsKey(id1)) {
			vertex1 = allVertex.get(id1);
		} else {
			vertex1 = new Vertex<T>(id1);
			allVertex.put(id1, vertex1);
		}
		Vertex<T> vertex2 = null;
		if (allVertex.containsKey(id2)) {
			vertex2 = allVertex.get(id2);
		} else {
			vertex2 = new Vertex<T>(id2);
			allVertex.put(id2, vertex2);
		}

		Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
		allEdges.add(edge);
		vertex1.addAdjacentVertex(edge, vertex2);
		if (!isDirected) {
			vertex2.addAdjacentVertex(edge, vertex1);
		}

	}

	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}

	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();
	}

	public void setDataForVertex(long id, T data) {
		if (allVertex.containsKey(id)) {
			Vertex<T> vertex = allVertex.get(id);
			vertex.setData(data);
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Edge<T> edge : getAllEdges()) {
			buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
			buffer.append("\n");
		}
		return buffer.toString();
	}

}

class Vertex<T> {
	long id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<>();
	private List<Vertex<T>> adjacentVertex = new ArrayList<>();

	Vertex(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertex.add(v);
	}

	public String toString() {
		return String.valueOf(id);
	}

	public List<Vertex<T>> getAdjacentVertexes() {
		return adjacentVertex;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public int getDegree() {
		return edges.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

class Edge<T> {
	private boolean isDirected = false;
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	private int weight;

	Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.isDirected = isDirected;
	}

	Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.isDirected = isDirected;
	}

	Vertex<T> getVertex1() {
		return vertex1;
	}

	Vertex<T> getVertex2() {
		return vertex2;
	}

	int getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertex1 == null) {
			if (other.vertex1 != null)
				return false;
		} else if (!vertex1.equals(other.vertex1))
			return false;
		if (vertex2 == null) {
			if (other.vertex2 != null)
				return false;
		} else if (!vertex2.equals(other.vertex2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight
				+ "]";
	}
}

class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int rank;
	}

	/**
	 * Create a set with only one element.
	 */
	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		map.put(data, node);
	}

	/**
	 * Combines two sets together to one. Does union by rank
	 *
	 * @return true if data1 and data2 are in different set before union else
	 *         false.
	 */
	public boolean union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);

		// if they are part of same set do nothing
		if (parent1.data == parent2.data) {
			return false;
		}

		// else whoever's rank is higher becomes parent of other
		if (parent1.rank >= parent2.rank) {
			// increment rank only if both sets have same rank
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
		return true;
	}

	/**
	 * Finds the representative of this set
	 */
	public long findSet(long data) {
		return findSet(map.get(data)).data;
	}

	/**
	 * Find the representative recursively and does path compression as well.
	 */
	private Node findSet(Node node) {
		Node parent = node.parent;
		if (parent == node) {
			return parent;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}
}

class EdgeComparator implements Comparator<Edge<Integer>> {
	@Override
	public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
		if (edge1.getWeight() < edge2.getWeight()) {
			return -1;
		}else if (edge1.getWeight() > edge2.getWeight()) {
			return 1;
		}else{
			return 0;
		}
	}
	
}
