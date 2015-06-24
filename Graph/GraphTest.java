package Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphTest bfsTest = new GraphTest();
		BFS bfs = new BFS();
		bfs.traversal(bfsTest.createGraph("bfsTest"));
	}

	public Node<Integer> createGraph(String type){
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n8 = new Node<Integer>(8);
		//		   1
	    //		2	  3
		//	  7   8	4	5
		//            6
		if(type.equals("bfsTest")){
			n1.addNode(n2);
			n1.addNode(n3);
			n3.addNode(n4);
			n3.addNode(n5);
			n5.addNode(n6);
			n2.addNode(n7);
			n2.addNode(n8);			
		}
		return n1;
	}
}

class Node<Key>{
	Key val;
	List<Node<Key>> adj;
	boolean isVisited;
	int distance;
	public Node(Key val){
		this.val = val;
		adj = new ArrayList<Node<Key>>();
		isVisited = false;
		distance = 0;
	}
	public void addNode(Node<Key> neigh){
		adj.add(neigh);
	}
}