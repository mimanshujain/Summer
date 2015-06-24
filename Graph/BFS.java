package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void traversal(Node<Integer> start){
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(start);
		start.isVisited = true;
		start.distance = 1;
		while(!queue.isEmpty())
		{
			Node<Integer> head = queue.poll();
			System.out.print(head.val+"-");
			if(head != null){
				for(Node<Integer> node : head.adj){
					if(!node.isVisited){
						node.isVisited  = true;
						queue.add(node);
					}
				}
			}
		}
	}
}
