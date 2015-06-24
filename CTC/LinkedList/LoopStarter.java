package CTC.LinkedList;

public class LoopStarter {

	public static void main(String[] args) {
		LinkedListTest link = new LinkedListTest();
		Node node = link.createLoopList();
		LoopStarter test = new LoopStarter();
		Node loop = test.startOfLoop(node);		
		System.out.println();
		System.out.println(loop.val);
	}
	
	public Node startOfLoop(Node node){
		Node slow = node;
		Node fast = node;
		System.out.println();
		while(true){
			slow = slow.next;
			fast = fast.next.next;
//			System.out.print(slow.val+" "+fast.val+"-");
			if(slow == fast) break;
		}
		slow = node;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
