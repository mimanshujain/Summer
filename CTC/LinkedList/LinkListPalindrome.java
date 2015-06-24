package CTC.LinkedList;
import java.util.Stack;
public class LinkListPalindrome {

	public static void main(String[] args) {
		Node n0 = new Node(1);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(2);
		Node n5 = new Node(1);
		Node n6 = new Node(1);
		n1.next = n2;n2.next = n3;n3.next = n4; n4.next = n5; n5.next = n6; n0.next = n1;
		LinkListPalindrome test = new LinkListPalindrome();
		System.out.println(test.isPalindromeIter(n0));
//		test.test(n0);
//		System.out.println(n0.val);
	}

	private boolean isPalindromeIter(Node node){
		boolean result = true;
		Stack<Integer> s = new Stack<Integer>();
		Node slow = node;
		Node fast = node;
		while(true){
			s.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
			if(fast == null || fast.next == null) break;
		}
		if(fast != null)
			slow = slow.next;
		while(!s.isEmpty() && slow != null){
			int val = s.pop();
			if(slow.val != val) return false;
			slow = slow.next;
		}
		return result;
	}
}
