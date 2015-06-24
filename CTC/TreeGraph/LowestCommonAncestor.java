package CTC.TreeGraph;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node lca(Node node, int n1, int n2){
		if(node == null) return null;
		
		if(node.value == n1 || node.value == n2)
			return node;
		
		Node left = lca(node.left,n1,n2);
		Node right = lca(node.right,n1,n2);
		
		if(left != null && right != null) return node;
		return left != null?left:right;
	}

}
