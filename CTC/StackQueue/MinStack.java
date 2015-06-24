package CTC.StackQueue;
import java.util.Stack;

@SuppressWarnings("serial")
public class MinStack extends Stack<Node>{

	int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack test = new MinStack();
		
		test.push(13);
		test.push(12);
		test.push(1);
		test.push(11);
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());		
	}
	
	private void push(int value){
		min = Math.min(min, value);
		push(new Node(value,min));
	}
	
	public Node pop(){
		Node node = super.pop();
		if(node.min == min){
			min = peek().min;
		}
		return node;
	}
	
	private int min(){
		if(isEmpty()) return Integer.MAX_VALUE;
		return min;
	}

}

class Node{
	int val;
	int min = Integer.MAX_VALUE;
	public Node(int val, int min){
		this.val = val;
		this.min = min;
	}
}
