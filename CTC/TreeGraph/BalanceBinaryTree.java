package CTC.TreeGraph;

//import Tree.BalanceBST.Node;

public class BalanceBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.createTree();
		System.out.println(isBalance(tree.root));
	}
	
	public static boolean isBalance(Node node){
		if(node == null) return true;

		if(isLeaf(node)){
			node.setHeight(0);
			return true;
		}
		
		boolean leftBalance = true;
		int leftHeight = 0;
		if(node.left != null){
			leftBalance = isBalance(node.left);
			leftHeight = node.left.getHeight() + 1;
			if(!leftBalance) return leftBalance;
		}
		
		boolean rightBalance = true;
		int rightHeight = 0;
		if(node.right != null){
			rightBalance = isBalance(node.right);
			rightHeight = node.right.getHeight() + 1;
			if(!rightBalance) return rightBalance;
		}
		
		node.setHeight(Math.max(leftHeight, rightHeight));
		if(Math.abs(leftHeight - rightHeight) <= 1)	return true;
		
		return false;
	}
	
	private boolean isBalance2(Node x)
	{
		if(x == null)
			return true;

		boolean lBalance = isBalance(x.left);
		boolean rBalance = isBalance(x.right);

		int lHeight = x.left != null ? x.left.height : 0;
		int rHeight = x.right != null ? x.right.height : 0;

		x.height = lHeight > rHeight ? lHeight : rHeight + 1;

		if(Math.abs(lHeight - rHeight) >= 2)
			return false;

		return lBalance && rBalance;

	}
	
	public static boolean isLeaf(Node node){
		return (node.left == null && node.right == null);
	}

}
