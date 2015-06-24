package Strings;

import java.util.HashMap;
import java.util.Map;
/* Name of the class has to be "Main" only if the class is public. */
public class Isomorphic
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Isomorphic obj = new Isomorphic();
		System.out.println("The result is: "+obj.isIsomorphic("zbxz", "opqr"));
	}
	
	//Checking 1st for the key for the c2 value.
	//Then checking if the key c1 is present.
	public boolean isIsomorphic(String s, String t)
	{
		if(s == null || t == null) return false;
		if(s.length() != t.length()) return false;
		if("".equals(s) || "".equals(t)) return true;
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		for(int i = 0; i < s.length(); i++)
		{
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			Character key = null;
			for(Map.Entry<Character, Character> entry : map.entrySet()){
				if(entry.getValue() == c2){
					key = entry.getKey();
					break;
				}
			}
			if(key != null && key != c1) return false;
			Character value = null;
			if(map.containsKey(c1))
				value = map.get(c1);
			if(value != null && value != c2) return false;
			map.put(c1, c2);
		}
		return true;
		
	}
}