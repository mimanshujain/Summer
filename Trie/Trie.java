package Trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Trie {
	private Node root = null;
	private static final int R = 26;
	public ArrayList<String> dictionary = new ArrayList<String>();
	
	public Trie(){
		createDictionary();
	}
	
	public class Node{
		//Using Array. Can be done with HashMaps when no queries related to order of the Keys
		Node[] child = new Node[R];
		private int depth;
		private int childNum = -1;//To store the index of the string in the dictionary
		private boolean isLeaf = false;
		int n=0;//Number of times this path has been taken
		public Node(int d){
			depth = d;
		}
		public boolean isLeaf() {
			return isLeaf;
		}
		public void setLeaf(boolean isLeave) {
			this.isLeaf = isLeave;
		}
		public int getChildNum() {
			return childNum;
		}
		public void setChildNum(int childNum) {
			this.childNum = childNum;
		}
		public int getDepth() {
			return depth;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();

		Node node = trie.get("rooting");
		System.out.println(node.childNum);
		
//		Iterator<String> it = trie.getKeysWithPattern("****").iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
		System.out.println(trie.longestPrefixOf("raining"));
	}
	
	public void createDictionary(){
		dictionary.add("foot");
		dictionary.add("root");
		dictionary.add("rooted");
		dictionary.add("foo");
		dictionary.add("roots");
		dictionary.add("rooting");
		dictionary.add("route");
		dictionary.add("fool");
		dictionary.add("rain");
		dictionary.add("banana");
		
		int i = 0;
		for(String key : dictionary){
			add(key, i++);
		}
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void add(String key, int num){
		root = add(root,key,0,num);
	}
	
	private Node add(Node node, String key, int d, int num){
		if(node == null) node = new Node(d);
		if(d == key.length()){
			node.setChildNum(num);
			node.setLeaf(true);
		}
		else{
			char ch = key.charAt(d);
			node.child[ch-97] = add(node.child[ch-97],key,d+1,num);
//			node.isLeaf = false;
			node.child[ch-97].n++;//Number of times this route has been taken
		}		
		return node;
	}
	
	public Node get(String key){
		return get(root,key);
	}
	private Node get(Node node, String key){
		if(node == null) return null;
		if(node.getDepth() == key.length()) return node;
		return get(node.child[key.charAt(node.getDepth()) - 97],key);
	}
	
	//Empty prefix will return all the keys
	public Iterable<String> collectKeys(String prefix){
		Queue<String> queue = new LinkedList<String>();
		Node node = get(root,prefix);
		collectKeys(new StringBuilder(prefix), queue, node);
		return queue;
	}
	
	private void collectKeys(StringBuilder prefix, Queue<String> queue, Node node){
		if(node == null) return;
		if(node.isLeaf)
			queue.add(dictionary.get(node.getChildNum()));
		if(node.isLeaf && node.n == 1) return;
//		if(node.n > 1){
//
//		}
		for(int i = 0; i < R; i++){
			char ch = (char) (i+97);
			prefix.append(ch);
//			if(ch == 'e' || ch == 't')
//				System.out.println(ch);
			collectKeys(prefix, queue, node.child[i]);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	public Iterable<String> getKeysWithPattern(String pattern){
		Queue<String> queue = new LinkedList<String>();
		getKeysWithPattern(new StringBuilder(),pattern, root, queue);
		return queue;
	}
    /**
     * Returns all of the keys in the symbol table that match <tt>pattern</tt>,
     * where * symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match <tt>pattern</tt>,
     *     as an iterable, where . is treated as a wildcard character.
     */
	private void getKeysWithPattern(StringBuilder prefix, String pattern, Node node, Queue<String> queue){
		if(node == null) return;
		int d = prefix.length();
		if(d == pattern.length() && node.isLeaf())
			queue.add(dictionary.get(node.getChildNum()));
		if(d == pattern.length()) return;
		char ch = pattern.charAt(d);
		if(ch == '*')
		{
			for(int i = 0; i < R; i++){
				char c = (char) (i+97);
				prefix.append(c);
				getKeysWithPattern(prefix, pattern, node.child[i], queue);
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
		else{
			prefix.append(ch);
			getKeysWithPattern(prefix, pattern, node.child[ch-97], queue);
			prefix.deleteCharAt(prefix.length()-1);
		}			
	}
	
	//Longest prefix matching which is a part of the dictionary of this query
	public String longestPrefixOf(String query){
		int length = longestPrefixOf(query, root, -1);
		if(length == -1) return null;
		else return query.substring(0, length);
	}
	private int longestPrefixOf(String query, Node node, int length){
		if(node == null) return length;
		if(node.isLeaf) length = node.getDepth();
		if(node.getDepth() == query.length()) return length;
		char ch = query.charAt(node.getDepth());
		return longestPrefixOf(query, node.child[ch-97], length);
	}
	
	public Iterable<String> uniquePrefix(){
		Queue<String> queue = new LinkedList<String>();
		uniquePrefix(queue);		
		return queue;
	}
	
	private void uniquePrefix(Queue<String> queue) {
		
		for(String key : dictionary){
			Node node = root;
			StringBuilder prefix = new StringBuilder();
			for(char ch : key.toCharArray()){
				node = node.child[ch-97];
				if(node != null)
					prefix.append(ch);
				if(node.n == 1) break;				
			}
			queue.add(prefix.toString());
		}
	}
}
