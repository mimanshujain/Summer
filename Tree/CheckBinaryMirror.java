package Tree;
//import java.util.Arrays;
//import java.util.List;

import CTC.TreeGraph.BinaryTree;
import CTC.TreeGraph.Node;

public class CheckBinaryMirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.createTree();
		System.out.println(checkIfMirror(tree));
//		List<BinaryTree> list = Arrays.asList(tree);
	}
	
	public static boolean checkIfMirror(BinaryTree tree){
		if(tree == null || tree.getRoot() == null) return true;
		Node root = tree.getRoot();
		return checkIfMirror(root.getLeft(),root.getRight());
	}
	
	private static boolean checkIfMirror(Node node1, Node node2){
		if(node1 == null || node2 == null) return node1 == null && node2 == null;
		if(node1.getValue() != node2.getValue()) return false;
		
		return (node1.getValue() == node2.getValue()) &&
				checkIfMirror(node1.getLeft(), node2.getRight()) && checkIfMirror(node1.getRight(), node2.getLeft());
	}

}
