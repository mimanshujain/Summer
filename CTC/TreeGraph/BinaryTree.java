package CTC.TreeGraph;

public class BinaryTree {

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
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n9;
		n9.left = n10;
		n6.left = n7;
		n6.right = n8;
//		n8.left = n9;
//		n8.right = n10;
//		n9.right = n11;
		
		root = n1;
	}

}

class Node{
	Node left = null;
	Node right = null;
	int value;
	int height;
	int depth;
	
	public Node(int val){
		value = val;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return this.height;
	}
	
	public void setDepth(int depth){
		this.depth = depth;
	}
	public int getDepth(){
		return this.depth;
	}
}
