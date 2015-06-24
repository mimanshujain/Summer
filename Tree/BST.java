package Tree;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class BST {

	Node root = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST test = new BST();
		test.add(5);
		test.add(4);
		test.add(1);
		test.add(2);		
		test.add(3);
		test.add(19);
		test.add(6);
		test.add(12);
		test.add(10);
		test.bfsTraversal();
		System.out.println();
//		System.out.println(test.max().val);
//		test.deleteMax();test.deleteMax();
//		System.out.println(test.max().val);
		test.delete(6);
		test.bfsTraversal();
		test.inOrder();
	}
//Add	
	public void add(int val){
		if(isEmpty())
			root = new Node(val);
		else
			root = add(root,val);
	}
	private Node add(Node node, int val){
		if(node == null) return new Node(val);
		
		if(val > node.val)
			node.right = add(node.right,val);
		else
			node.left = add(node.left, val);
		
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
//Search	
	public Node search(int val){
		if(isEmpty()) return null;
		return search(root,val);
	}	
	private Node search(Node node, int val){
		if(node == null) return null;
		
		if(node.val == val) return node;
		if(val > node.val) return search(node.right, val);
		return search(node.left, val);
	}
	
//Delete
	public void delete(int val){
		if(isEmpty()) return;
		root = delete(root,val);
	}	
	private Node delete(Node node, int val){
		if(node == null) return null;
		
		if(val > node.val) node.right = delete(node.right,val);
		else if(val < node.val) node.left = delete(node.left,val);
		else{
			Node min = min(node.right);
			node.right = deleteMin(node.right);
			min.left = node.left;
			min.right = node.right;
			node = min;
		}
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public void deleteMin(){
		if(isEmpty()) return;
		root = deleteMin(root);
	}	
	private Node deleteMin(Node node){
		if(node.left == null) return node.right;
		node.left = deleteMin(node.left);
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public void deleteMax(){
		if(isEmpty()) return;
		root = deleteMax(root);
	}	
	private Node deleteMax(Node node){
		if(node.right == null) return node.left;
		node.right = deleteMax(node.right);
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	public Node max(){
		if(isEmpty()) return null;
		return max(root);
	}
	private Node max(Node node){
		if(node.right == null) return node;
		return max(node.right);
	}
	
	public Node min(){
		if(isEmpty()) return null;
		return min(root);
	}
	private Node min(Node node){
		if(node.left == null) return node;
		return min(node.left);
	}
	
	public Node floor(int val){
		if(isEmpty()) return null;
		return floor(root, val);
	}
	private Node floor(Node node, int val){
		if(node == null) return null;
		
		if(node.val == val) return node;
		if(val < node.val) return floor(node.left, val);
		else{
			Node temp = floor(node.right, val);
			if(temp != null) return temp;
			return node;
		}
	}
	
	public Node ceiling(int val){
		if(isEmpty()) return null;
		return ceiling(root, val);
	}
	private Node ceiling(Node node, int val){
		if(node == null) return null;
		
		if(node.val == val) return node;
		if(val > node.val) return ceiling(node.right,val);
		else{
			Node temp = ceiling(node.left, val);
			if(temp != null) return temp;
			return node;
		}
	}
	
	public Iterable<Node> inOrder(){
		if(isEmpty()) return null;
		
		Queue<Node> queue = new LinkedList<Node>();
		inOrder(root, queue);
		System.out.println();
		Iterator<Node> it = queue.iterator();
		while(it.hasNext())
			System.out.print(it.next().val+" ");
		System.out.println();
		return queue;
	}
	private void inOrder(Node node, Queue<Node> queue){
		if(node.left != null) inOrder(node.left,queue);
		queue.add(node);
		if(node.right != null) inOrder(node.right, queue);
	}
	
	public void bfsTraversal(){
		if(isEmpty()) return;
		
		Queue<Node> queue = new LinkedList<Node>();
		root.isVisited = true;
		queue.add(root);
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(node.val+" ");
			Node left = node.left;
			Node right = node.right;
			if(left != null) queue.add(left);
			if(right != null) queue.add(right);
		}
	}
	
	private int size(Node node){
		if(node == null) return 0;
		else return node.size;
	}
	
	private boolean isEmpty(){
		return root == null;
	}

}

class Node{
	int val;
	Node left;
	Node right;
	int height;
	int depth;
	int size; //Number of nodes in the tree with root as this node
	boolean isVisited;
	
	public Node(int val){
		this.val = val;
		left = null;
		right = null;
		isVisited = false;
	}
}
