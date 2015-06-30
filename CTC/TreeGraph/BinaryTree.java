package CTC.TreeGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public void setRoot(Node root) {
		this.root = root;
	}

	Node root = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void createTree(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
//		n3.right = n9;
//		n9.left = n10;
//		n6.left = n7;
//		n6.right = n8;
//		n8.left = n9;
//		n8.right = n10;
//		n9.right = n11;
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n6.left = n8;
		n7.right = n9;
		n8.left = n10;
		n9.left = n11;
	
		root = n1;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public Iterable<Node> postOrder(){
		Queue<Node> queue = new LinkedList<Node>();
		postOrder(root,queue);
		return queue;
	}
	
	private void postOrder(Node node, Queue<Node> queue){
		if(node == null) return;
		postOrder(node.left, queue);
		postOrder(node.right, queue);
		queue.add(node);
	}
	
	public Iterable<Node> inOrder(){
		Queue<Node> queue = new LinkedList<Node>();
		inOrder(root,queue);
		return queue;
	}
	
	private void inOrder(Node node, Queue<Node> queue){
		if(node == null) return;
		inOrder(node.left, queue);
		queue.add(node);
		inOrder(node.right, queue);
		
	}
	
	public void traversal(Iterable<Node> queue){
		if(queue == null) return;
		Iterator<Node> it = queue.iterator();
		while(it.hasNext())
			System.out.print(it.next().value+" ");
		System.out.println();
	}
	
	public void iterativeInorder(){
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		boolean done = false;
		while(!done){
			if(current != null){		
				stack.push(current);
				current = current.left;
			}
			else{
				Node node = stack.pop();
				System.out.print(node.value+" ");
				current = node.right;
			}
			if(stack.isEmpty() && current == null)
				done = true;
		}
		System.out.println();
	}
	
	public void iterativePostOrder(){
		Stack<Node> buffer = new Stack<Node>();
		Stack<Node> out = new Stack<Node>();

		buffer.push(root);
		while(!buffer.isEmpty()){
			Node node = buffer.pop();
			if(node.left != null)
				buffer.push(node.left);
			if(node.right != null)
				buffer.push(node.right);
			out.push(node);
		}
		
		while(!out.isEmpty()){
			System.out.print(out.pop().value+" ");
		}
		System.out.println();
	}
	

}

//class Node{
//
//}
