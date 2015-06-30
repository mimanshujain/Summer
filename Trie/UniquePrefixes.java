package Trie;

import java.util.Iterator;

public class UniquePrefixes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		Iterator<String> it = trie.uniquePrefix().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
