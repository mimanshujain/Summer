package Strings;
import java.util.Iterator;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.lang.StringBuilder;

public class WordLadder {

	public static void main(String[] args) {		
		WordLadder test = new WordLadder();
		Set<String> wordDict =  new HashSet<String>();		
		test.createDict(wordDict);
		//		test.ladderLength("hit", "cog", wordDict);
//		System.out.println(test.ladderLength("hit", "cog", wordDict));
		test.allLaddersUtil("qa", "sq", wordDict);
	}

	public void createDict(Set<String> wordDict)
	{
		String[] words = 
			{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba",
				"to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb",
				"if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh",
				"wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//			{"hot","dot","dog","lot","log"};
		//{"a","b","c"};
		//{"miss","dusk","kiss","musk","tusk","diss","disk","sang","ties","muss"};
		for(String word : words){
			wordDict.add(word);
		}
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		int steps = 0;
		wordDict.add(endWord);
		wordDict.add(beginWord);
		HashMap<String, ArrayList<Node>> bucket = createBucket(wordDict);
		Node head = createEdges(bucket, beginWord);
		if(head != null){
			Queue<Node> queue = new LinkedList<Node>();
			head.isVisited = true;
			head.steps = 1;
			head.pred = null;
			queue.add(head);
			while(!queue.isEmpty()){				
				head = queue.poll();
				if(head != null){
					if(head.word.equals(endWord)) {						
						printLadder(head);
						return head.steps;
					}
					for(Node node : head.adj){
						if(!node.isVisited){
							node.isVisited = true;
							node.pred = head;
							node.steps = head.steps + 1;
							queue.add(node);
						}
					}
				}
			}
		}
		return steps;
	}

	public List<List<String>> allLaddersUtil(String beginWord, String endWord, Set<String> wordDict)
	{
		wordDict.add(endWord);
		wordDict.add(beginWord);
		HashMap<String, ArrayList<Node>> bucket = createBucket(wordDict);
		Node head = createEdges(bucket, beginWord);
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		List<List<String>> list2 = new ArrayList<List<String>>();
		if(head != null){
			head.isVisited = true;
			head.steps = 1;
			Stack<String> dfs = new Stack<String>();
//			dfs.add(beginWord);
			StringBuilder sb = new StringBuilder();
			allLaders(sb, dfs, endWord, head);

			String[] trails = sb.toString().split("#");
			int min = 0;
			for(String trail : trails)
			{
				String[] words = trail.split("-");
				ArrayList<String> tempList = new ArrayList<String>();
				//				if(list.isEmpty()){					
				//					min = words.length;
				//				}
				//				else if(words.length > min)
				//					continue;
				for(String word : words){
					if(word != null && !"".equals(word))
						tempList.add(word);		
				}
				list.add(tempList);
			}
			min = list.get(0).size();
			for(int i = 1; i < list.size(); i++)
			{
				int len = list.get(i).size();
				if(min > len) min = len;
			}
			int listLen = list.size();
			for(int i = 0; i < listLen; i++){
				if(list.get(i).size() == min) list2.add(list.get(i));
			}
		}
		return list2;
	}

	private void allLaders(StringBuilder sb,Stack<String> dfs, String endWord, Node head){		
		dfs.add(head.word);		
		if(head.word.equals(endWord)){
			String trail = "";
			Iterator<String> it = dfs.iterator();
			while(it.hasNext())
				trail = trail+"-"+it.next();

			dfs.remove(head.word);
			sb.append(trail+"#");
			return;
		}
		//		head.isVisited = true;
		for(Node node : head.adj)
		{
			if(!node.isVisited){
				node.steps = head.steps + 1;
				node.isVisited = true;
				allLaders(sb,dfs,endWord,node);
				node.isVisited = false;
			}
		}
		dfs.remove(head.word);
	}

	public HashMap<String, ArrayList<Node>> createBucket(Set<String> wordDict){
		HashMap<String, ArrayList<Node>> bucket = new HashMap<String, ArrayList<Node>>();
		HashMap<String, Node> addressMap = new HashMap<String, Node>();
		for(String word : wordDict){
			Node node = null;
			if(addressMap.containsKey(word)) node = addressMap.get(word);
			else node = new Node(word);
			for(int i = 0; i < word.length(); i++)
			{
				String key = "";
				if(i == 0) key = "_" + word.substring(i+1);
				else key = word.substring(0, i) + "_" + word.substring(i+1);
				ArrayList<Node> list;
				if(bucket.containsKey(key)) list = bucket.get(key);
				else list = new ArrayList<Node>();
				list.add(node);
				bucket.put(key, list);
			}		
		}				
		return bucket;
	}

	public Node createEdges(HashMap<String, ArrayList<Node>> bucket, String beginWord){
		Node head = null;
		for(String key : bucket.keySet()){
			for(Node node1 : bucket.get(key)){
				for(Node node2 : bucket.get(key)){
					if(!node1.word.equals(node2.word)){
						node1.createEdge(node2);
					}
				}
				if(node1.word.equals(beginWord))
					head = node1;
			}
		}
		return head;
	}

	public void printLadder(Node node){
		if(node.pred == null) {		
			System.out.print(node.word + "->");
			return;
		}
		printLadder(node.pred);	
		System.out.print(node.word + "->");
	}
}


class Node{
	String word;
	Node pred;
	int steps;
	List<Node> adj;
	boolean isVisited;
	public Node(String word){
		adj = new ArrayList<Node>();
		this.word = word;
		steps = Integer.MAX_VALUE;
		isVisited = false;
		pred = null;
	}
	public void createEdge(Node node){
		adj.add(node);
	}
}
