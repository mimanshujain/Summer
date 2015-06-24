package CTC.LinkedList;

import java.util.HashSet;

public class DuplicateRemoval {

	public static void main(String[] args) {
		DuplicateRemoval test = new DuplicateRemoval();
		LinkedListTest link = new LinkedListTest();
		Node head = link.createUnsortedList();
		link.printList(head);
		System.out.println();
		head = test.removeDupsWithBuffer(head);
		link.printList(head);
	}

	public Node removeDuplicate(Node start)
	{
		if(start == null) return start;
		Node next = start.next;
		Node previous = start;
		boolean hasChanged = false;

		while(next != null){
			Node current = start;
			while(current != next){
				if(current.val == next.val){
					previous.next = next.next;
					hasChanged = true;
					break;
				}
				current = current.next;
			}			
			if(!hasChanged){
				previous = previous.next;
				next = next.next;
			}
			else{
				next = next.next;
				hasChanged = false;
			}
				
		}

		return start;
	}
	
	public Node removeDupsWithBuffer(Node start){
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		Node head = start;
		while(start != null){
			if(set.contains(start.val)){
				previous.next = start.next;
			}
			else{
				set.add(start.val);
				previous = start;				
			}
			start = start.next; 
		}
		return head;
	}
}
