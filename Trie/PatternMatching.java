package Trie;

import java.util.Iterator;

public class PatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		Iterator<String> it = trie.getKeysWithPattern("****").iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
