package CTC.LinkedList;

public class KthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthElement test = new KthElement();
		LinkedListTest link = new LinkedListTest();
		Node head = link.createUnsortedList();
		Node node = test.kthElement(head, 3);
		link.printList(head);
		System.out.println("\n"+node.val);
	}
	
	public Node kthElement(Node head, int k){
		
		if(head == null) return null;
		
		Node p1 = head;
		Node p2;
		for(int i=0;i<k;i++){
			if(p1 == null) return null;
			p1 = p1.next;
		}
		p2 = head;
		while(p1 != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		
		return p2;
	}

}

//class Node{
//	int val;
//	Node next;
//
//	public Node(int val){
//		this.val = val;
//		next = null;
//	}
//}