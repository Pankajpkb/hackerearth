package com.hackerearth.interview.questions;

public class LinkedListReversal2 {

	public static void main(String[] args) {
		
		Node n1 = new Node("Java",null);
		Node n2 = new Node("Javascript",null);
		Node n3 = new Node("Angular",null);
		Node n4 = new Node("Typescript",null);
		Node n5 = new Node("Kubernetes",null);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node n = n1;
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
		
		n = reverseList(n1);
		System.out.println("Reversed linked list");
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

	private static Node reverseList(Node n1) {
		Node prev = null;
		Node next = null;
		Node curr = n1;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}

class Node{
	String val;
	Node next;
	
	public Node(String val, Node next) {
		this.val = val;
		this.next = next;
	}
}
