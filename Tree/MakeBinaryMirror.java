package Tree;

import CTC.TreeGraph.BinaryTree;
import CTC.TreeGraph.Node;
import java.util.*;

public class MakeBinaryMirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.createTree();
		tree.traversal(tree.inOrder());
		makeMirrorCopy(tree);
		tree.traversal(tree.postOrder());
		tree.iterativeInorder();
		tree.iterativePostOrder();
		
		ArrayList<String> list = new ArrayList<String>();
//		Collection<Integer> coll = null;
//		list.addAll(coll);
//		Collections.binarySearch(list, 1)
		TreeSet<String> set = new TreeSet<String>(list);
		
		
	}

	public static BinaryTree makeMirrorCopy(BinaryTree tree){
		if(tree == null || tree.getRoot() == null) return tree;
		tree.setRoot(makeMirrorCopy(tree.getRoot()));
		return tree;
	}
	
	private static Node makeMirrorCopy(Node node){
		if(node == null) return null;
		
		//Do a post order traversal
		makeMirrorCopy(node.getLeft());
		makeMirrorCopy(node.getRight());
		Node temp = node.getLeft();
		node.setLeft(node.getRight());
		node.setRight(temp);
		return node;
	}

}