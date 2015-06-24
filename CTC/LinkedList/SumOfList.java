package CTC.LinkedList;

public class SumOfList {

	public static void main(String[] args) {
		LinkedListTest link = new LinkedListTest();
		Node node1 = link.createUnsortedList(3);
		Node node2 = link.createUnsortedList(4);
		SumOfList test = new SumOfList();
		link.printList(node1);
		System.out.println();
		link.printList(node2);
		System.out.println();
		Node head = test.sumNonForward(node1, node2);
		link.printList(head);
	}

	public Node sumForwardList(Node node1, Node node2){
		Node head = null, start = null;
		int carry = 0;
		//		Node sum = node1;
		while(node1 != null || node2 != null){
			Node temp = null;
			int sum = 0;
			if(node1 == null)	{
				sum = (carry + node2.val);
				node2 = node2.next;
			}
			else if(node2 == null)	{
				sum = (carry + node1.val);
				node1 = node1.next;
			}
			else {
				sum = (carry + node1.val + node2.val);
				node1 = node1.next;
				node2 = node2.next;
			}

			carry = (sum-10) < 0 ? 0 : 1; 
			temp = new Node(sum%10);

			if(head == null) {
				head = temp;
				start = head;
			}
			else{
				head.next = temp;
				head = temp;
			}



		}
		if(carry > 0) head.next = new Node(carry);

		return start;
	}

	public Node sumNonForward(Node node1, Node node2){
		if(node1 == null && node2 == null) return null;
		int len1 = listLength(node1);
		int len2 = listLength(node2);
		if(len1 < len2) node1 = leftPadding(node1, len2-len1);
		else if(len1 > len2) node2 = leftPadding(node2, len1-len2);
		Node sum = findSum(node1, node2).sum;		
		return sum;
	}
	
	private Wrapper findSum(Node node1, Node node2){
		if(node1 == null || node2 == null){
			return null;
		}
		Wrapper result = findSum(node1.next, node2.next);
		int carry = 0;
		if(result == null){
			result = new Wrapper();		
		}
		else{
			carry = result.carry;
		}
		int sum = node1.val + node2.val + carry;
		carry = sum>=10?1:0;
		Node temp = new Node(sum%10);
		temp.next = result.sum;
		result.sum = temp;
		result.carry = carry;
		return result;
	}

	private int listLength(Node node){
		int len = 0;
		while(node != null){
			len++;
			node = node.next;
		}
		return len;
	}

	private Node leftPadding(Node node, int k){
		while(k != 0){
			Node temp = new Node(0);
			temp.next = node;
			node = temp;
			k--;
		}
		return node;
	}

	class Wrapper{
		Node sum = null;
		int carry = 0;
	}

}
