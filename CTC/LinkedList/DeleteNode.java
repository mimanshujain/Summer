package CTC.LinkedList;

public class DeleteNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListTest link = new LinkedListTest();
		Node head = link.createUnsortedList();
		DeleteNode test = new DeleteNode();
		link.printList(head);
		test.delete(head.next.next.next);
		System.out.println();
		link.printList(head);
	}
	
	public void delete(Node node){
		
		if(node == null || node.next == null) return;
		
		node.val = node.next.val;
		node.next = node.next.next;
		
	}

}
