package com.hackerearth.datastructures.singlylinkedlist;

import java.util.Scanner;

/**
 * You are given a linked list that contains integers. You have performed the
 * following reverse operation on the list:
 * 
 * Select all the subparts of the list that contain only even integers. For
 * example, if the list is , then the selected subparts will be , . Reverse the
 * selected subpart such as and . Now, you are required to retrieve the original
 * list.
 * 
 * Input format
 * 
 * First line: Next line: space-separated integers that denote elements of the
 * reverse list Output format
 * 
 * Print the elements of the original list.
 */
public class ReversedLinkedList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		Node head;
		Node element = new Node();
		element.val = in.nextInt();
		element.next = null;
		head = element;
		for (int i=1; i <N; i++) {
			Node temp = new Node();
			temp.val = in.nextInt();
			temp.next = null;
			element.next = temp;
			element = temp;
		}
		element = head;
		for (int i=0; i <N; i++) {
			System.out.print(element.val + "\t");
			element = element.next;
		}
		
		in.close();
	}

}

class Node{
	int val;
	Node next;
}
