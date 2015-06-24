package CTC.LinkedList;

import java.util.Random;

public class LinkedListTest {
	public Node createUnsortedList()
	{
		Node head = null;
		Node start = null;
		Random randomGenerator = new Random();
		int i = 0;
		while(i < 10){
			Node temp = new Node(randomGenerator.nextInt(15));

			if(i == 0) {
				head = temp;
				start = head;
			}
			else{
				head.next = temp;
				head = head.next;
			}
			i++;			
		}
		return start;
	}
	
	public Node createUnsortedList(int size)
	{
		Node head = null;
		Node start = null;
		Random randomGenerator = new Random();
		int i = 0;
		while(i < size){
			Node temp = new Node(randomGenerator.nextInt(9));

			if(i == 0) {
				head = temp;
				start = head;
			}
			else{
				head.next = temp;
				head = head.next;
			}
			i++;			
		}
		return start;
	}
	
	public Node createLoopList()
	{
		Node head = null;
		Node start = null;
		Random randomGenerator = new Random();
		int i = 0;
		Node loop = null;
		while(i < 15){
			Node temp = new Node(randomGenerator.nextInt(25));
			if(i == 6) loop = temp;
			if(i == 0) {
				head = temp;
				start = head;
			}
			else{
				head.next = temp;
				head = head.next;
			}
			i++;			
		}
		printList(start);
		System.out.println("\n"+loop.val);
		head.next = loop;
		return start;
	}
	

	public void printList(Node start){
		while(start != null){
			System.out.print(start.val+"->");
			start = start.next;
		}
	}
}

class Node{
	int val;
	Node next;

	public Node(int val){
		this.val = val;
		next = null;
	}
}
