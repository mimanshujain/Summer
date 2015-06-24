//Problem 1.1
package CTC.ArrayStrings;
import java.util.HashMap;

public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueChar test = new UniqueChar();
		System.out.println(test.hashUniqNoDataStruc("azz"));
	}
	
	public boolean hasAllUnique(String inp){
		boolean result = true;
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		char[] chArr = inp.toCharArray();
		
		for(char ch : chArr){
			if(map.containsKey(ch)) return false;
			map.put(ch, 1);
		}		
		
		return result;
	}
	public boolean hashUniqNoDataStruc(String inp){
		boolean result = true;
		boolean[] marker = new boolean[26];
		char[] chArr = inp.toLowerCase().toCharArray();
		
		for(int ch : chArr){
			ch = ch - 97;
			if(marker[ch]) return false;
			marker[ch] = true;
		}
		
		return result;
	}
}
