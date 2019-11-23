package com.hackerearth.interview.questions;

import java.util.LinkedList;
import java.util.List;

/**
 *Reverse the order of a linked list
 **/
public class LinkedListReversal {

	public static void main(String[] args) {
		List<String> namesList = new LinkedList<>();

		namesList.add("C++");
		namesList.add("C#");
		namesList.add("Java");
		namesList.add("Angular");
		namesList.add("Typescript");
		
		namesList.forEach(System.out::println);
		
		System.out.println("Reversing list");
		reverseList(namesList).forEach(System.out::println);
	}

	private static List<String> reverseList(List<String> namesList) {
		List<String> reversedList = new LinkedList<>();
		int length = namesList.size();
		for (int i=0; i<length; i++) {
			String last = ((LinkedList<String>)namesList).getLast();
			reversedList.add(last);
			((LinkedList<String>)namesList).removeLast();			
		}
		
		return reversedList;
	}

}
