package CTC.LinkedList;

public class Partition {

	public static void main(String[] args) {
		LinkedListTest link = new LinkedListTest();
		Node head = link.createUnsortedList();
		Partition test = new Partition();
		link.printList(head);
		head = test.unstable(head, 6);
		System.out.println();
		link.printList(head);
	}
	
	//Stable in the sense that the order of the element is not being changed while moving
	public Node stable(Node node, int x){
		
		Node leftBegin = null;
		Node leftEnd = null;
		Node rightBegin = null;
		Node rightEnd = null;
		
		while(node != null){
			if(node.val <= x){
				if(leftBegin == null){
					leftBegin = node;
					leftEnd = node;
				}
				else{
					leftEnd.next = node;
					leftEnd = leftEnd.next;
				}
			}
			else{
				if(rightBegin == null){
					rightBegin = node;
					rightEnd = node;
				}
				else{
					rightEnd.next = node;
					rightEnd = rightEnd.next;
				}
			}
			node = node.next; 
		}
		if(leftEnd != null){
			leftEnd.next = rightBegin;
			return leftBegin;
		}
		else return rightBegin;
	}	
	
	public Node unstable(Node node, int x){
		Node head = node;
		Node tail = node;
//		while(head != null){
//			tail = head;
//			head = head.next;
//		}
//		head = node;
		
		while(node != null)
		{
			Node next = node.next;
			if(node.val <= x){
				node.next = head;
				head = node;
			}
			else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}

}
