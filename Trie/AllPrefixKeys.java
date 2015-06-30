package Trie;

import java.util.Iterator;

public class AllPrefixKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iterator<String> it = getAllKeys("foo").iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
	}
	
	public static Iterable<String> getAllKeys(String prefix){
		Trie trie = new Trie();
		return trie.collectKeys(prefix);
	}

}
