package CTC.TreeGraph;

public class Node {
	Node left = null;
	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}
	Node right = null;
	public Node getRight() {
		return right;
	}
	int value;
	public int getValue() {
		return value;
	}
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
